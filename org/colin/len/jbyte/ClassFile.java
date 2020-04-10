package org.colin.len.jbyte;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.JByte;
import org.colin.len.jbyte.util.IOUtils;

public final class ClassFile {

  public int magic;
  public int minorVersion;
  public int majorVersion;
  public ConstantPool constantPool;
  public int accessFlags;
  public int thisClass;
  public int superClass;
  public int interfaces[];
  public Field fields[];
  public Method methods[];
  public Attribute attributes[];
  private DataInputStream dataInputStream;

  public ClassFile(String classFileName) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(classFileName);
    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
    dataInputStream = new DataInputStream(bufferedInputStream);
    readClassFile();
    IOUtils.closeQuietly(dataInputStream);
    IOUtils.closeQuietly(bufferedInputStream);
    IOUtils.closeQuietly(fileInputStream);
  }

  public void readClassFile() throws IOException {
    readMagic();
    readVersion();
    readConstantPool();
    readClassInfo();
    readInterfaces();
    readFields();
    readMethods();
    readAttributes();
  }

  public void readMagic() throws IOException {
    magic = dataInputStream.readInt();
  }

  public void readVersion() throws IOException {
    minorVersion = dataInputStream.readUnsignedShort();
    majorVersion = dataInputStream.readUnsignedShort();
  }

  public void readConstantPool() throws IOException {
    constantPool = new ConstantPool(dataInputStream);
  }

  public void readClassInfo() throws IOException {
    accessFlags = dataInputStream.readUnsignedShort();
    thisClass = dataInputStream.readUnsignedShort();
    superClass = dataInputStream.readUnsignedShort();
    if ((accessFlags & JByte.ACC_INTERFACE) != 0) {
      accessFlags |= JByte.ACC_ABSTRACT;
    }
    if ((accessFlags & JByte.ACC_ABSTRACT) != 0 && (accessFlags & JByte.ACC_FINAL) !=0) {
      //error
    }
  }

  public void readInterfaces() throws IOException {
    int interfacesCount = dataInputStream.readUnsignedShort();
    interfaces = new int[interfacesCount];
    for (int i = 0; i < interfacesCount; i++) {
      interfaces[i] = dataInputStream.readUnsignedShort();
    }
  }

  public void readFields() throws IOException {
    int fieldsCount = dataInputStream.readUnsignedShort();
    fields = new Field[fieldsCount];
    for (int i = 0; i < fieldsCount; i++) {
      fields[i] = new Field(dataInputStream, constantPool);
    }
  }

  public void readMethods() throws IOException {
    int methodsCount = dataInputStream.readUnsignedShort();
    methods = new Method[methodsCount];
    for (int i = 0; i < methodsCount; i++) {
      methods[i] = new Method(dataInputStream, constantPool);
    }
  }

  public void readAttributes() throws IOException {
    int attributesCount = dataInputStream.readUnsignedShort();
    attributes = new Attribute[attributesCount];
    for (int i = 0; i < attributesCount; i++) {
      attributes[i] = Attribute.readAttribute(dataInputStream, constantPool);
    }
  }

  public ConstantPool getConstantPool() {
    return constantPool;
  }

  public Field[] getFields() {
    return fields;
  }

  public Method[] getMethods() {
    return methods;
  }

  public Attribute[] getAttributes() {
    return attributes;
  }

}
