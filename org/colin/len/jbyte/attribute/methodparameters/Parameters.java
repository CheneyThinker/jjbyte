package org.colin.len.jbyte.attribute.methodparameters;

import java.io.DataInputStream;
import java.io.IOException;

public class Parameters {

  private int nameIndex;
  private int accessFlags;

  public Parameters(DataInputStream dataInputStream) throws IOException {
    setNameIndex(dataInputStream.readUnsignedShort());
    setAccessFlags(dataInputStream.readUnsignedShort());
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

}
