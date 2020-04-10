package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantFloat extends Constant {

  private float bytes;

  public ConstantFloat(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setBytes(dataInputStream.readFloat());
  }

  public float getBytes() {
    return bytes;
  }

  public void setBytes(float bytes) {
    this.bytes = bytes;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantFloat");
    builder.append("[").append(tag).append("]");
    builder.append("(bytes = ").append(bytes).append(")");
    return builder.toString();
  }

}
