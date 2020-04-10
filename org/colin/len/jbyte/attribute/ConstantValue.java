package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class ConstantValue extends Attribute {

  private int constantValueIndex;

  public ConstantValue(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setConstantValueIndex(dataInputStream.readUnsignedShort());
  }

  public int getConstantValueIndex() {
    return constantValueIndex;
  }

  public void setConstantValueIndex(int constantValueIndex) {
    this.constantValueIndex = constantValueIndex;
  }

}
