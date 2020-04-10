package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantString extends Constant {

  private int stringIndex;

  public ConstantString(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setStringIndex(dataInputStream.readUnsignedShort());
  }

  public int getStringIndex() {
    return stringIndex;
  }

  public void setStringIndex(int stringIndex) {
    this.stringIndex = stringIndex;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantString");
    builder.append("[").append(tag).append("]");
    builder.append("(stringIndex = ").append(stringIndex).append(")");
    return builder.toString();
  }

}
