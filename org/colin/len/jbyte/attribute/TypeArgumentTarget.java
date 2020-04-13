package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeArgumentTarget extends Target {

  private int offset;
  private int typeArgumentIndex;

  public TypeArgumentTarget(DataInputStream dataInputStream) throws IOException {
    offset = dataInputStream.readUnsignedShort();
    typeArgumentIndex = dataInputStream.readUnsignedByte();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(offset);
    dataOutputStream.writeByte(typeArgumentIndex);
  }

  public String toString() {
    return String.format("(offset = %d, typeArgumentIndex = %d)", offset, typeArgumentIndex);
  }

}
