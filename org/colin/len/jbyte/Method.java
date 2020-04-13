package org.colin.len.jbyte;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.factory.AttributeFactory;

public class Method {

  private int accessFlags;
  private int nameIndex;
  private int descriptorIndex;
  private Attribute[] attributes;
  private ConstantPool constantPool;

  public Method(DataInputStream dataInputStream, ConstantPool constantPool) throws IOException {
    accessFlags = dataInputStream.readUnsignedShort();
    nameIndex = dataInputStream.readUnsignedShort();
    descriptorIndex = dataInputStream.readUnsignedShort();
    final int attributesCount = dataInputStream.readUnsignedShort();
    attributes = new Attribute[attributesCount];
    for (int i = 0; i < attributesCount; i++) {
      attributes[i] = AttributeFactory.readAttribute(dataInputStream, constantPool);
    }
    this.constantPool = constantPool;
  }

  public int getAccessFlags() {
    return accessFlags;
  }

  public void setAccessFlags(int accessFlags) {
    this.accessFlags = accessFlags;
  }

  public int getNameIndex() {
    return nameIndex;
  }

  public void setNameIndex(int nameIndex) {
    this.nameIndex = nameIndex;
  }

  public int getDescriptorIndex() {
    return descriptorIndex;
  }

  public void setDescriptorIndex(int descriptorIndex) {
    this.descriptorIndex = descriptorIndex;
  }

  public Attribute[] getAttributes() {
    return attributes == null ? new Attribute[0] : attributes;
  }

  public void setAttributes(Attribute[] attributes) {
    this.attributes = attributes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(accessFlags);
    dataOutputStream.writeShort(nameIndex);
    dataOutputStream.writeShort(descriptorIndex);
    final int attributesCount = getAttributes().length;
    dataOutputStream.writeShort(attributesCount);
    for (int i = 0; i < attributesCount; i++) {
      attributes[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(constantPool.getUtf8(nameIndex));
    builder.append("(accessFlags = ").append(accessFlags);
    builder.append(", nameIndex = ").append(nameIndex);
    builder.append(", descriptorIndex = ").append(descriptorIndex);
    for (int i = 0, j = getAttributes().length; i < j; i++) {
      if (i == 0) {
        builder.append(", attributes = [ ");
      }
      builder.append(attributes[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
