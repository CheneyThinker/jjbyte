package org.colin.len.jbyte;

import java.io.*;

import org.colin.len.jbyte.exception.JByteException;
import org.colin.len.jbyte.factory.AttributeFactory;
import org.colin.len.jbyte.fixed.JByte;
import org.colin.len.jbyte.util.IOUtils;

public class ClassFile {

  private int magic;
  private int minorVersion;
  private int majorVersion;
  private ConstantPool constantPool;
  private int accessFlags;
  private int thisClass;
  private int superClass;
  private int[] interfaces;
  private Field[] fields;
  private Method[] methods;
  private Attribute[] attributes;
  private DataInputStream dataInputStream;

  public ClassFile(String classFileName) {
    FileInputStream fileInputStream = null;
    BufferedInputStream bufferedInputStream = null;
    try {
      fileInputStream = new FileInputStream(classFileName);
      bufferedInputStream = new BufferedInputStream(fileInputStream);
      dataInputStream = new DataInputStream(bufferedInputStream);
      readMagic(classFileName);
      readVersion();
      readConstantPool();
      readClassInfo();
      readInterface();
      readField();
      readMethod();
      readAttribute();
    } catch (IOException e) {
    } finally {
      IOUtils.closeQuietly(dataInputStream);
      IOUtils.closeQuietly(bufferedInputStream);
      IOUtils.closeQuietly(fileInputStream);
    }
  }

  public void readMagic(String classFileName) throws IOException {
    magic = dataInputStream.readInt();
    if (magic != JByte.MAGIC) {
      throw new JByteException(String.format("% is not a Java .class file", classFileName));
    }
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
  }

  public void readInterface() throws IOException {
    final int interfacesCount = dataInputStream.readUnsignedShort();
    interfaces = new int[interfacesCount];
    for (int i = 0; i < interfacesCount; i++) {
      interfaces[i] = dataInputStream.readUnsignedShort();
    }
  }

  public void readField() throws IOException {
    final int fieldsCount = dataInputStream.readUnsignedShort();
    fields = new Field[fieldsCount];
    for (int i = 0; i < fieldsCount; i++) {
      fields[i] = new Field(dataInputStream, constantPool);
    }
  }

  public void readMethod() throws IOException {
    final int methodsCount = dataInputStream.readUnsignedShort();
    methods = new Method[methodsCount];
    for (int i = 0; i < methodsCount; i++) {
      methods[i] = new Method(dataInputStream, constantPool);
    }
  }

  public void readAttribute() throws IOException {
    final int attributesCount = dataInputStream.readUnsignedShort();
    attributes = new Attribute[attributesCount];
    for (int i = 0; i < attributesCount; i++) {
      attributes[i] = AttributeFactory.readAttribute(dataInputStream, constantPool);
    }
  }

  public int getMagic() {
    return magic;
  }

  public void setMagic(int magic) {
    this.magic = magic;
  }

  public int getMinorVersion() {
    return minorVersion;
  }

  public void setMinorVersion(int minorVersion) {
    this.minorVersion = minorVersion;
  }

  public int getMajorVersion() {
    return majorVersion;
  }

  public void setMajorVersion(int majorVersion) {
    this.majorVersion = majorVersion;
  }

  public ConstantPool getConstantPool() {
    return constantPool;
  }

  public void setConstantPool(ConstantPool constantPool) {
    this.constantPool = constantPool;
  }

  public int getAccessFlags() {
    return accessFlags;
  }

  public void setAccessFlags(int accessFlags) {
    this.accessFlags = accessFlags;
  }

  public int getThisClass() {
    return thisClass;
  }

  public void setThisClass(int thisClass) {
    this.thisClass = thisClass;
  }

  public int getSuperClass() {
    return superClass;
  }

  public void setSuperClass(int superClass) {
    this.superClass = superClass;
  }

  public int[] getInterfaces() {
    return interfaces == null ? new int[0] : interfaces;
  }

  public void setInterfaces(int[] interfaces) {
    this.interfaces = interfaces;
  }

  public Field[] getFields() {
    return fields == null ? new Field[0] : fields;
  }

  public void setFields(Field[] fields) {
    this.fields = fields;
  }

  public Method[] getMethods() {
    return methods == null ? new Method[0] : methods;
  }

  public void setMethods(Method[] methods) {
    this.methods = methods;
  }

  public Attribute[] getAttributes() {
    return attributes == null ? new Attribute[0] : attributes;
  }

  public void setAttributes(Attribute[] attributes) {
    this.attributes = attributes;
  }

}
