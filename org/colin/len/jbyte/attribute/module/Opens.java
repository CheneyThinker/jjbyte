package org.colin.len.jbyte.attribute.module;

import java.io.DataInputStream;
import java.io.IOException;

public class Opens {

  private int opensIndex;
  private int opensFlags;
  private int opensToCount;
  private int opensToIndex[];

  public Opens(DataInputStream dataInputStream) throws IOException {
    setOpensIndex(dataInputStream.readUnsignedShort());
    setOpensFlags(dataInputStream.readUnsignedShort());
    setOpensToCount(dataInputStream.readUnsignedShort());
    setOpensToIndex(new int[opensToCount]);
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

  public int getOpensToCount() {
    return opensToCount;
  }

  public void setOpensToCount(int opensToCount) {
    this.opensToCount = opensToCount;
  }

  public int[] getOpensToIndex() {
    return opensToIndex;
  }

  public void setOpensToIndex(int[] opensToIndex) {
    this.opensToIndex = opensToIndex;
  }

}
