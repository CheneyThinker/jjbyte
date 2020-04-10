package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantNameAndType extends Constant {

  private int nameIndex;
  private int descriptorIndex;

  public ConstantNameAndType(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setNameIndex(dataInputStream.readUnsignedShort());
    setDescriptorIndex(dataInputStream.readUnsignedShort());
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

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantNameAndType");
    builder.append("[").append(tag).append("]");
    builder.append("(nameIndex = ").append(nameIndex);
    builder.append(", descriptorIndex = ").append(descriptorIndex).append(")");
    return builder.toString();
  }

}
