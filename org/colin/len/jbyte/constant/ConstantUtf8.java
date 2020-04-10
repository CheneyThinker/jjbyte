package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantUtf8 extends Constant {

  private String bytes;

  public ConstantUtf8(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setBytes(dataInputStream.readUTF());
  }

  public String getBytes() {
    return bytes;
  }

  public void setBytes(String bytes) {
    this.bytes = bytes;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantUtf8");
    builder.append("[").append(tag).append("]");
    builder.append("(bytes = ").append(bytes).append(")");
    return builder.toString();
  }

}
