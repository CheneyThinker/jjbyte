package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class Table {

  private int startPC;
  private int length;
  private int index;

  public Table(DataInputStream dataInputStream) throws IOException {
    setStartPC(dataInputStream.readUnsignedShort());
    setLength(dataInputStream.readUnsignedShort());
    setIndex(dataInputStream.readUnsignedShort());
  }

  public int getStartPC() {
    return startPC;
  }

  public void setStartPC(int startPC) {
    this.startPC = startPC;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

}
