package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.linenumbertable.LineNumberTable;

public class LineNumberTables extends Attribute {

  private int lineNumberTableLength;
  private LineNumberTable lineNumberTable[];

  public LineNumberTables(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setLineNumberTableLength(dataInputStream.readUnsignedShort());
    setLineNumberTable(new LineNumberTable[lineNumberTableLength]);
    for (int i = 0; i < lineNumberTableLength; i++) {
      lineNumberTable[i] = new LineNumberTable(dataInputStream);
    }
  }

  public int getLineNumberTableLength() {
    return lineNumberTableLength;
  }

  public void setLineNumberTableLength(int lineNumberTableLength) {
    this.lineNumberTableLength = lineNumberTableLength;
  }

  public LineNumberTable[] getLineNumberTable() {
    return lineNumberTable;
  }

  public void setLineNumberTable(LineNumberTable[] lineNumberTable) {
    this.lineNumberTable = lineNumberTable;
  }

}
