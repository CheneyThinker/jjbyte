package org.colin.len.jbyte.attribute;

import java.io.*;

public class Parameters {

  private int nameIndex;
  private int accessFlags;

  public Parameters(DataInputStream dataInputStream) throws IOException {
    nameIndex = dataInputStream.readUnsignedShort();
    accessFlags = dataInputStream.readUnsignedShort();
  }

  public int getNameIndex() {
    return nameIndex;
  }

  public void setNameIndex(int nameIndex) {
    this.nameIndex = nameIndex;
  }

  public int getAccessFlags() {
    return accessFlags;
  }

  public void setAccessFlags(int accessFlags) {
    this.accessFlags = accessFlags;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(nameIndex);
    dataOutputStream.writeShort(accessFlags);
  }

  public String toString() {
    return String.format("(nameIndex = %d, accessFlags = %d)", nameIndex, accessFlags);
  }

}
