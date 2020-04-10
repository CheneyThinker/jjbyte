package org.colin.len.jbyte.attribute.linenumbertable;

import java.io.DataInputStream;
import java.io.IOException;

public class LineNumberTable {

  private short startPC;
  private short lineNumber;

  public LineNumberTable(DataInputStream dataInputStream) throws IOException {
    setStartPC((short) dataInputStream.readUnsignedShort());
    setLineNumber((short) dataInputStream.readUnsignedShort());
  }

  public short getStartPC() {
    return startPC;
  }

  public void setStartPC(short startPC) {
    this.startPC = startPC;
  }

  public short getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(short lineNumber) {
    this.lineNumber = lineNumber;
  }

}
