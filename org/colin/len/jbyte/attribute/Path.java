package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Path {

  private int typePathKind;
  private int typeArgumentIndex;

  public Path(DataInputStream dataInputStream) throws IOException {
    typePathKind = dataInputStream.readUnsignedByte();
    typeArgumentIndex = dataInputStream.readUnsignedByte();
  }

  public int getTypePathKind() {
    return typePathKind;
  }

  public void setTypePathKind(int typePathKind) {
    this.typePathKind = typePathKind;
  }

  public int getTypeArgumentIndex() {
    return typeArgumentIndex;
  }

  public void setTypeArgumentIndex(int typeArgumentIndex) {
    this.typeArgumentIndex = typeArgumentIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeByte(typePathKind);
    dataOutputStream.writeByte(typeArgumentIndex);
  }

  public String toString() {
    return String.format("(typePathKind = %d, typeArgumentIndex = %d)", typePathKind, typeArgumentIndex);
  }

}
