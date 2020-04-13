package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantInteger extends Constant {

  private int bytes;

  public ConstantInteger(DataInputStream dataInputStream) throws IOException {
    bytes = dataInputStream.readInt();
  }

  public int getBytes() {
    return bytes;
  }

  public void setBytes(int bytes) {
    this.bytes = bytes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeInt(bytes);
  }

  public String toString() {
    return String.format("%s(%s)", super.toString(), String.valueOf(bytes));
  }

}
