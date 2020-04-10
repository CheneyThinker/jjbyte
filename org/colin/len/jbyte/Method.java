package org.colin.len.jbyte;

import java.io.DataInputStream;
import java.io.IOException;

public class Method {

  private int accessFlags;
  private int nameIndex;
  private int descriptorIndex;
  private int attributesCount;
  private Attribute attributes[];

  public Method(DataInputStream dataInputStream, ConstantPool constantPool) throws IOException {
    setAccessFlags(dataInputStream.readUnsignedShort());
    setNameIndex(dataInputStream.readUnsignedShort());
    setDescriptorIndex(dataInputStream.readUnsignedShort());
    setAttributesCount(dataInputStream.readUnsignedShort());
    setAttributes(new Attribute[attributesCount]);
    for (int i = 0; i < attributesCount; i++) {
      attributes[i] = Attribute.readAttribute(dataInputStream, constantPool);
    }
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

  public int getAttributesCount() {
    return attributesCount;
  }

  public void setAttributesCount(int attributesCount) {
    this.attributesCount = attributesCount;
  }

  public Attribute[] getAttributes() {
    return attributes;
  }

  public void setAttributes(Attribute[] attributes) {
    this.attributes = attributes;
  }

}
