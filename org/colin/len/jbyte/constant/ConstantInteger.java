package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantInteger extends Constant {

  private int bytes;

  public ConstantInteger(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setBytes(dataInputStream.readInt());
  }

  public int getBytes() {
    return bytes;
  }

  public void setBytes(int bytes) {
    this.bytes = bytes;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantInteger");
    builder.append("[").append(tag).append("]");
    builder.append("(bytes = ").append(bytes).append(")");
    return builder.toString();
  }

}
