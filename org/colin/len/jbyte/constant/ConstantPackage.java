package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPackage extends Constant {

  private int nameIndex;

  public ConstantPackage(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setNameIndex(dataInputStream.readUnsignedShort());
  }

  public int getNameIndex() {
    return nameIndex;
  }

  public void setNameIndex(int nameIndex) {
    this.nameIndex = nameIndex;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantPackage");
    builder.append("[").append(tag).append("]");
    builder.append("(nameIndex = ").append(nameIndex).append(")");
    return builder.toString();
  }

}
