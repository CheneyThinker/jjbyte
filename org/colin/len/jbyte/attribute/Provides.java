package org.colin.len.jbyte.attribute;

import java.io.*;

public class Provides {

  private int providesIndex;
  private int[] providesWithIndex;

  public Provides(DataInputStream dataInputStream) throws IOException {
    providesIndex = dataInputStream.readUnsignedShort();
    final int providesWithCount = dataInputStream.readUnsignedShort();
    providesWithIndex = new int[providesWithCount];
    for (int i = 0; i < providesWithCount; i++) {
      providesWithIndex[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int getProvidesIndex() {
    return providesIndex;
  }

  public void setProvidesIndex(int providesIndex) {
    this.providesIndex = providesIndex;
  }

  public int[] getProvidesWithIndex() {
    return providesWithIndex == null ? new int[0] : providesWithIndex;
  }

  public void setProvidesWithIndex(int[] providesWithIndex) {
    this.providesWithIndex = providesWithIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(providesIndex);
    final int providesWithCount = getProvidesWithIndex().length;
    dataOutputStream.writeShort(providesWithCount);
    for (int i = 0; i < providesWithCount; i++) {
      dataOutputStream.writeShort(providesWithIndex[i]);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(providesIndex = ").append(providesIndex);
    for (int i = 0, j = getProvidesWithIndex().length; i < j; i++) {
      if (i == 0) {
        builder.append(", providesWithIndex = [ ");
      }
      builder.append(providesWithIndex[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
