package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantMethodType extends Constant {

  private int descriptorIndex;

  public ConstantMethodType(DataInputStream dataInputStream) throws IOException {
    descriptorIndex = dataInputStream.readUnsignedShort();
  }

  public int getDescriptorIndex() {
    return descriptorIndex;
  }

  public void setDescriptorIndex(int descriptorIndex) {
    this.descriptorIndex = descriptorIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(descriptorIndex);
  }

  public String toString() {
    return String.format("%s(descriptorIndex = %d)", super.toString(), descriptorIndex);
  }

}
