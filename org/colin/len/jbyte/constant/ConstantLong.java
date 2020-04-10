package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantLong extends Constant {

  private long bytes;

  public ConstantLong(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setBytes(dataInputStream.readLong());
  }

  public long getBytes() {
    return bytes;
  }

  public void setBytes(long bytes) {
    this.bytes = bytes;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantLong");
    builder.append("[").append(tag).append("]");
    builder.append("(bytes = ").append(bytes).append(")");
    return builder.toString();
  }

}
