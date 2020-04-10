package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class SuperTypeTarget extends Target {

  private int supertypeIndex;

  public SuperTypeTarget(DataInputStream dataInputStream) throws IOException {
    setSupertypeIndex(dataInputStream.readUnsignedShort());
  }

  public int getSupertypeIndex() {
    return supertypeIndex;
  }

  public void setSupertypeIndex(int supertypeIndex) {
    this.supertypeIndex = supertypeIndex;
  }

}
