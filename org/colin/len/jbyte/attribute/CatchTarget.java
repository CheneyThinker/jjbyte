package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CatchTarget extends Target {

  private int exceptionTableIndex;

  public CatchTarget(DataInputStream dataInputStream) throws IOException {
    exceptionTableIndex = dataInputStream.readUnsignedShort();
  }

  public int getExceptionTableIndex() {
    return exceptionTableIndex;
  }

  public void setExceptionTableIndex(int exceptionTableIndex) {
    this.exceptionTableIndex = exceptionTableIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(exceptionTableIndex);
  }

  public String toString() {
    return String.format("(exceptionTableIndex = %d)", exceptionTableIndex);
  }

}
