package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ThrowsTarget extends Target {

  private int throwsTypeIndex;

  public ThrowsTarget(DataInputStream dataInputStream) throws IOException {
    throwsTypeIndex = dataInputStream.readUnsignedShort();
  }

  public int getThrowsTypeIndex() {
    return throwsTypeIndex;
  }

  public void setThrowsTypeIndex(int throwsTypeIndex) {
    this.throwsTypeIndex = throwsTypeIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(throwsTypeIndex);
  }

  public String toString() {
    return String.format("(throwsTypeIndex = %d)", throwsTypeIndex);
  }

}
