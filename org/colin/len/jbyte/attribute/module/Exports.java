package org.colin.len.jbyte.attribute.module;

import java.io.DataInputStream;
import java.io.IOException;

public class Exports {

  private int exportsIndex;
  private int exportsFlags;
  private int exportsToCount;
  private int exportsToIndex[];

  public Exports(DataInputStream dataInputStream) throws IOException {
    setExportsIndex(dataInputStream.readUnsignedShort());
    setExportsFlags(dataInputStream.readUnsignedShort());
    setExportsToCount(dataInputStream.readUnsignedShort());
    setExportsToIndex(new int[exportsToCount]);
    for (int i = 0; i < exportsToCount; i++) {
      exportsToIndex[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int getExportsIndex() {
    return exportsIndex;
  }

  public void setExportsIndex(int exportsIndex) {
    this.exportsIndex = exportsIndex;
  }

  public int getExportsFlags() {
    return exportsFlags;
  }

  public void setExportsFlags(int exportsFlags) {
    this.exportsFlags = exportsFlags;
  }

  public int getExportsToCount() {
    return exportsToCount;
  }

  public void setExportsToCount(int exportsToCount) {
    this.exportsToCount = exportsToCount;
  }

  public int[] getExportsToIndex() {
    return exportsToIndex;
  }

  public void setExportsToIndex(int[] exportsToIndex) {
    this.exportsToIndex = exportsToIndex;
  }

}
