package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantLong extends Constant {

  private long bytes;

  public ConstantLong(DataInputStream dataInputStream) throws IOException {
    bytes = dataInputStream.readLong();
  }

  public long getBytes() {
    return bytes;
  }

  public void setBytes(long bytes) {
    this.bytes = bytes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeLong(bytes);
  }

  public String toString() {
    return String.format("%s(%s)", super.toString(), String.valueOf(bytes));
  }

}
