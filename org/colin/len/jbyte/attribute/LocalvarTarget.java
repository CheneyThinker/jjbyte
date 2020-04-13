package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LocalvarTarget extends Target {

  private Table[] tables;

  public LocalvarTarget(DataInputStream dataInputStream) throws IOException {
    final int tableLength = dataInputStream.readUnsignedShort();
    tables = new Table[tableLength];
    for (int i = 0; i < tableLength; i++) {
      tables[i] = new Table(dataInputStream);
    }
  }

  public Table[] getTables() {
    return tables == null ? new Table[0] : tables;
  }

  public void setTables(Table[] tables) {
    this.tables = tables;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int tableLength = getTables().length;
    dataOutputStream.writeShort(tableLength);
    for (int i = 0; i < tableLength; i++) {
      tables[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0, j = getTables().length; i < j; i++) {
      if (i == 0) {
        builder.append("(tables = [ ");
      }
      builder.append(tables[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
