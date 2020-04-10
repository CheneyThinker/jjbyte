package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class OffsetTarget extends Target {

  private int offset;

  public OffsetTarget(DataInputStream dataInputStream) throws IOException {
    setOffset(dataInputStream.readUnsignedShort());
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

}
