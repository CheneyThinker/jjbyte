package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantDouble extends Constant {

  private double bytes;

  public ConstantDouble(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setBytes(dataInputStream.readDouble());
  }

  public double getBytes() {
    return bytes;
  }

  public void setBytes(double bytes) {
    this.bytes = bytes;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantDouble");
    builder.append("[").append(tag).append("]");
    builder.append("(bytes = ").append(bytes).append(")");
    return builder.toString();
  }

}
