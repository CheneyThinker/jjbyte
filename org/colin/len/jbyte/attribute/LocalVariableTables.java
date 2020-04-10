package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.localvariable.LocalVariableTable;

public class LocalVariableTables extends Attribute {

  private int localVariableTableLength;
  private LocalVariableTable localVariableTable[];

  public LocalVariableTables(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setLocalVariableTableLength(dataInputStream.readUnsignedShort());
    setLocalVariableTable(new LocalVariableTable[localVariableTableLength]);
    for (int i = 0; i < localVariableTableLength; i++) {
      localVariableTable[i] = new LocalVariableTable(dataInputStream);
    }
  }

  public int getLocalVariableTableLength() {
    return localVariableTableLength;
  }

  public void setLocalVariableTableLength(int localVariableTableLength) {
    this.localVariableTableLength = localVariableTableLength;
  }

  public LocalVariableTable[] getLocalVariableTable() {
    return localVariableTable;
  }

  public void setLocalVariableTable(LocalVariableTable[] localVariableTable) {
    this.localVariableTable = localVariableTable;
  }

}
