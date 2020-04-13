package org.colin.len.jbyte;

import java.io.DataOutputStream;
import java.io.IOException;

public class Attribute {

  private int attributeNameIndex;
  private int attributeLength;
  private ConstantPool constantPool;

  public int getAttributeNameIndex() {
    return attributeNameIndex;
  }

  public void setAttributeNameIndex(int attributeNameIndex) {
    this.attributeNameIndex = attributeNameIndex;
  }

  public int getAttributeLength() {
    return attributeLength;
  }

  public void setAttributeLength(int attributeLength) {
    this.attributeLength = attributeLength;
  }

  public ConstantPool getConstantPool() {
    return constantPool;
  }

  public void setConstantPool(ConstantPool constantPool) {
    this.constantPool = constantPool;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(attributeNameIndex);
    dataOutputStream.writeInt(attributeLength);
  }

  public String toString() {
    return String.format("%s(%d)[%d]", constantPool.getUtf8(attributeNameIndex), attributeNameIndex, attributeLength);
  }

}
