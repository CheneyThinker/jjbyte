package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OffsetTarget extends Target {

  private int offset;

  public OffsetTarget(DataInputStream dataInputStream) throws IOException {
    offset = dataInputStream.readUnsignedShort();
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(offset);
  }

  public String toString() {
    return String.format("(offset = %d)", offset);
  }

}
