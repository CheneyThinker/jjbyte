package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class Path {

  private int typePathKind;
  private int typeArgumentIndex;

  public Path(DataInputStream dataInputStream) throws IOException {
    setTypePathKind(dataInputStream.readUnsignedByte());
    setTypeArgumentIndex(dataInputStream.readUnsignedByte());
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

}
