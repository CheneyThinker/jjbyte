package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantString extends Constant {

  private int stringIndex;

  public ConstantString(DataInputStream dataInputStream) throws IOException {
    stringIndex = dataInputStream.readUnsignedShort();
  }

  public int getStringIndex() {
    return stringIndex;
  }

  public void setStringIndex(int stringIndex) {
    this.stringIndex = stringIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(stringIndex);
  }

  public String toString() {
    return String.format("%s(stringIndex = %d)", super.toString(), stringIndex);
  }

}
