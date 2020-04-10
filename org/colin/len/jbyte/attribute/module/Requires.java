package org.colin.len.jbyte.attribute.module;

import java.io.DataInputStream;
import java.io.IOException;

public class Requires {

  private int requiresIndex;
  private int requiresFlags;
  private int requiresVersionIndex;

  public Requires(DataInputStream dataInputStream) throws IOException {
    setRequiresIndex(dataInputStream.readUnsignedShort());
    setRequiresFlags(dataInputStream.readUnsignedShort());
    setRequiresVersionIndex(dataInputStream.readUnsignedShort());
  }

  public int getRequiresIndex() {
    return requiresIndex;
  }

  public void setRequiresIndex(int requiresIndex) {
    this.requiresIndex = requiresIndex;
  }

  public int getRequiresFlags() {
    return requiresFlags;
  }

  public void setRequiresFlags(int requiresFlags) {
    this.requiresFlags = requiresFlags;
  }

  public int getRequiresVersionIndex() {
    return requiresVersionIndex;
  }

  public void setRequiresVersionIndex(int requiresVersionIndex) {
    this.requiresVersionIndex = requiresVersionIndex;
  }

}
