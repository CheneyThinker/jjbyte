package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class ThrowsTarget extends Target {

  private int throwsTypeIndex;

  public ThrowsTarget(DataInputStream dataInputStream) throws IOException {
    setThrowsTypeIndex(dataInputStream.readUnsignedShort());
  }

  public int getThrowsTypeIndex() {
    return throwsTypeIndex;
  }

  public void setThrowsTypeIndex(int throwsTypeIndex) {
    this.throwsTypeIndex = throwsTypeIndex;
  }

}
