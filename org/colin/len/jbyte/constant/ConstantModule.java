package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantModule extends Constant {

  private int nameIndex;

  public ConstantModule(DataInputStream dataInputStream) throws IOException {
    nameIndex = dataInputStream.readUnsignedShort();
  }

  public int getNameIndex() {
    return nameIndex;
  }

  public void setNameIndex(int nameIndex) {
    this.nameIndex = nameIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(nameIndex);
  }

  public String toString() {
    return String.format("%s(nameIndex = %d)", super.toString(), nameIndex);
  }

}
