package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class CatchTarget extends Target {

  private int exceptionTableIndex;

  public CatchTarget(DataInputStream dataInputStream) throws IOException {
    setExceptionTableIndex(dataInputStream.readUnsignedShort());
  }

  public int getExceptionTableIndex() {
    return exceptionTableIndex;
  }

  public void setExceptionTableIndex(int exceptionTableIndex) {
    this.exceptionTableIndex = exceptionTableIndex;
  }

}
