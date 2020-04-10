package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantMethodType extends Constant {

  private int descriptorIndex;

  public ConstantMethodType(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setDescriptorIndex(dataInputStream.readUnsignedShort());
  }

  public int getDescriptorIndex() {
    return descriptorIndex;
  }

  public void setDescriptorIndex(int descriptorIndex) {
    this.descriptorIndex = descriptorIndex;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantMethodType");
    builder.append("[").append(tag).append("]");
    builder.append("(descriptorIndex = ").append(descriptorIndex).append(")");
    return builder.toString();
  }

}
