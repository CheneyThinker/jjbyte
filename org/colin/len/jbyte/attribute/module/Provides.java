package org.colin.len.jbyte.attribute.module;

import java.io.DataInputStream;
import java.io.IOException;

public class Provides {

  private int providesIndex;
  private int providesWithCount;
  private int providesWithIndex[];

  public Provides(DataInputStream dataInputStream) throws IOException {
    setProvidesIndex(dataInputStream.readUnsignedShort());
    setProvidesWithCount(dataInputStream.readUnsignedShort());
    setProvidesWithIndex(new int[providesWithCount]);
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

  public int getProvidesWithCount() {
    return providesWithCount;
  }

  public void setProvidesWithCount(int providesWithCount) {
    this.providesWithCount = providesWithCount;
  }

  public int[] getProvidesWithIndex() {
    return providesWithIndex;
  }

  public void setProvidesWithIndex(int[] providesWithIndex) {
    this.providesWithIndex = providesWithIndex;
  }

}
