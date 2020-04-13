package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeLocalVariableTable extends Attribute {

  private LocalVariableTable[] localVariableTables;

  public AttributeLocalVariableTable(DataInputStream dataInputStream) throws IOException {
    final int localVariableTableLength = dataInputStream.readUnsignedShort();
    localVariableTables = new LocalVariableTable[localVariableTableLength];
    for (int i = 0; i < localVariableTableLength; i++) {
      localVariableTables[i] = new LocalVariableTable(dataInputStream);
    }
  }

  public LocalVariableTable[] getLocalVariableTables() {
    return localVariableTables == null ? new LocalVariableTable[0] : localVariableTables;
  }

  public void setLocalVariableTables(LocalVariableTable[] localVariableTables) {
    this.localVariableTables = localVariableTables;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int localVariableTableLength = getLocalVariableTables().length;
    dataOutputStream.writeShort(localVariableTableLength);
    for (int i = 0; i < localVariableTableLength; i++) {
      localVariableTables[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getLocalVariableTables().length; i < j; i++) {
      if (i == 0) {
        builder.append("(localVariableTables = [ ");
      }
      builder.append(localVariableTables[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
