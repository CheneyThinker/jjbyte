package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantNameAndType extends Constant {

  private int nameIndex;
  private int descriptorIndex;

  public ConstantNameAndType(DataInputStream dataInputStream) throws IOException {
    nameIndex = dataInputStream.readUnsignedShort();
    descriptorIndex = dataInputStream.readUnsignedShort();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(nameIndex);
    dataOutputStream.writeShort(descriptorIndex);
  }

  public String toString() {
    return String.format("%s(nameIndex = %d, descriptorIndex = %d)", super.toString(), nameIndex, descriptorIndex);
  }

}
