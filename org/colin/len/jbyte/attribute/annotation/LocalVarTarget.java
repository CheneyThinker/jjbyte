package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class LocalVarTarget extends Target {

  private int tableLength;
  private Table table[];

  public LocalVarTarget(DataInputStream dataInputStream) throws IOException {
    setTableLength(dataInputStream.readUnsignedShort());
    setTable(new Table[tableLength]);
    for (int i = 0; i < tableLength; i++) {
      table[i] = new Table(dataInputStream);
    }
  }

  public int getTableLength() {
    return tableLength;
  }

  public void setTableLength(int tableLength) {
    this.tableLength = tableLength;
  }

  public Table[] getTable() {
    return table;
  }

  public void setTable(Table[] table) {
    this.table = table;
  }

}
