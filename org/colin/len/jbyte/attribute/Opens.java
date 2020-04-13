package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Opens {

  private int opensIndex;
  private int opensFlags;
  private int[] opensToIndex;

  public Opens(DataInputStream dataInputStream) throws IOException {
    opensIndex = dataInputStream.readUnsignedShort();
    opensFlags = dataInputStream.readUnsignedShort();
    final int opensToCount = dataInputStream.readUnsignedShort();
    opensToIndex = new int[opensToCount];
    for (int i = 0; i < opensToCount; i++) {
      opensToIndex[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int getOpensIndex() {
    return opensIndex;
  }

  public void setOpensIndex(int opensIndex) {
    this.opensIndex = opensIndex;
  }

  public int getOpensFlags() {
    return opensFlags;
  }

  public void setOpensFlags(int opensFlags) {
    this.opensFlags = opensFlags;
  }

  public int[] getOpensToIndex() {
    return opensToIndex == null ? new int[0] : opensToIndex;
  }

  public void setOpensToIndex(int[] opensToIndex) {
    this.opensToIndex = opensToIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(opensIndex);
    dataOutputStream.writeShort(opensFlags);
    final int opensToCount = getOpensToIndex().length;
    dataOutputStream.writeShort(opensToCount);
    for (int i = 0; i < opensToCount; i++) {
      dataOutputStream.writeShort(opensToIndex[i]);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(opensIndex = ").append(opensIndex);
    builder.append(", opensFlags = ").append(opensFlags);
    for (int i = 0, j = getOpensToIndex().length; i < j; i++) {
      if (i == 0) {
        builder.append(", opensToIndex = [ ");
      }
      builder.append(opensToIndex[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
