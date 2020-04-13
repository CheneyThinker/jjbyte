package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeLineNumberTable extends Attribute {

  private LineNumberTable[] lineNumberTables;

  public AttributeLineNumberTable(DataInputStream dataInputStream) throws IOException {
    final int lineNumberTableLength = dataInputStream.readUnsignedShort();
    lineNumberTables = new LineNumberTable[lineNumberTableLength];
    for (int i = 0; i < lineNumberTableLength; i++) {
      lineNumberTables[i] = new LineNumberTable(dataInputStream);
    }
  }

  public LineNumberTable[] getLineNumberTables() {
    return lineNumberTables == null ? new LineNumberTable[0] : lineNumberTables;
  }

  public void setLineNumberTables(LineNumberTable[] lineNumberTables) {
    this.lineNumberTables = lineNumberTables;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int lineNumberTableLength = getLineNumberTables().length;
    dataOutputStream.writeShort(lineNumberTableLength);
    for (int i = 0; i < lineNumberTableLength; i++) {
      lineNumberTables[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getLineNumberTables().length; i < j; i++) {
      if (i == 0) {
        builder.append("(lineNumberTables = [ ");
      }
      builder.append(lineNumberTables[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
