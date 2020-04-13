package org.colin.len.jbyte.attribute;

import java.io.*;

public class Requires {

  private int requiresIndex;
  private int requiresFlags;
  private int requiresVersionIndex;

  public Requires(DataInputStream dataInputStream) throws IOException {
    requiresIndex = dataInputStream.readUnsignedShort();
    requiresFlags = dataInputStream.readUnsignedShort();
    requiresVersionIndex = dataInputStream.readUnsignedShort();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(requiresIndex);
    dataOutputStream.writeShort(requiresFlags);
    dataOutputStream.writeShort(requiresVersionIndex);
  }

  public String toString() {
    return String.format("(requiresIndex = %d, requiresFlags = %d, requiresVersionIndex = %d)", requiresIndex, requiresFlags, requiresVersionIndex);
  }

}
