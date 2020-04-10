package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class TypeArgumentTarget extends Target {

  private int offset;
  private int typeArgumentIndex;

  public TypeArgumentTarget(DataInputStream dataInputStream) throws IOException {
    setOffset(dataInputStream.readUnsignedShort());
    setTypeArgumentIndex(dataInputStream.readUnsignedByte());
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getTypeArgumentIndex() {
    return typeArgumentIndex;
  }

  public void setTypeArgumentIndex(int typeArgumentIndex) {
    this.typeArgumentIndex = typeArgumentIndex;
  }

}
