package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Exports {

  private int exportsIndex;
  private int exportsFlags;
  private int[] exportsToIndex;

  public Exports(DataInputStream dataInputStream) throws IOException {
    exportsIndex = dataInputStream.readUnsignedShort();
    exportsFlags = dataInputStream.readUnsignedShort();
    final int exportsToCount = dataInputStream.readUnsignedShort();
    exportsToIndex = new int[exportsToCount];
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

  public int[] getExportsToIndex() {
    return exportsToIndex == null ? new int[0] : exportsToIndex;
  }

  public void setExportsToIndex(int[] exportsToIndex) {
    this.exportsToIndex = exportsToIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(exportsIndex);
    dataOutputStream.writeShort(exportsFlags);
    final int exportsToCount = getExportsToIndex().length;
    dataOutputStream.writeShort(exportsToCount);
    for (int i = 0; i < exportsToCount; i++) {
      dataOutputStream.writeShort(exportsToIndex[i]);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(exportsIndex = ").append(exportsIndex);
    builder.append(", exportsFlags = ").append(exportsFlags);
    for (int i = 0, j = getExportsToIndex().length; i < j; i++) {
      if (i == 0) {
        builder.append(", exportsToIndex = [ ");
      }
      builder.append(exportsToIndex[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return super.toString();
  }

}
