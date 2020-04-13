package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LineNumberTable {

  private int startPC;
  private int lineNumber;

  public LineNumberTable(DataInputStream dataInputStream) throws IOException {
    startPC = dataInputStream.readUnsignedShort();
    lineNumber = dataInputStream.readUnsignedShort();
  }

  public int getStartPC() {
    return startPC;
  }

  public void setStartPC(int startPC) {
    this.startPC = startPC;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(int lineNumber) {
    this.lineNumber = lineNumber;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(startPC);
    dataOutputStream.writeShort(lineNumber);
  }

  public String toString() {
    return String.format("(startPC = %d, lineNumber = %d)", startPC, lineNumber);
  }

}
