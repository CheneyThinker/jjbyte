package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Table {

  private int startPC;
  private int length;
  private int index;

  public Table(DataInputStream dataInputStream) throws IOException {
    startPC = dataInputStream.readUnsignedShort();
    length = dataInputStream.readUnsignedShort();
    index = dataInputStream.readUnsignedShort();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(startPC);
    dataOutputStream.writeShort(length);
    dataOutputStream.writeShort(index);
  }

  public String toString() {
    return String.format("(startPC = %d, length = %d, index = %d)", startPC, length, index);
  }

}
