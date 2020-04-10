package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.localvariable.LocalVariableTypeTable;

public class LocalVariableTypeTables extends Attribute {

  private int localVariableTypeTableLength;
  private LocalVariableTypeTable localVariableTypeTable[];

  public LocalVariableTypeTables(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setLocalVariableTypeTableLength(dataInputStream.readUnsignedShort());
    setLocalVariableTypeTable(new LocalVariableTypeTable[localVariableTypeTableLength]);
    for (int i = 0; i < localVariableTypeTableLength; i++) {
      localVariableTypeTable[i] = new LocalVariableTypeTable(dataInputStream);
    }
  }

  public int getLocalVariableTypeTableLength() {
    return localVariableTypeTableLength;
  }

  public void setLocalVariableTypeTableLength(int localVariableTypeTableLength) {
    this.localVariableTypeTableLength = localVariableTypeTableLength;
  }

  public LocalVariableTypeTable[] getLocalVariableTypeTable() {
    return localVariableTypeTable;
  }

  public void setLocalVariableTypeTable(LocalVariableTypeTable[] localVariableTypeTable) {
    this.localVariableTypeTable = localVariableTypeTable;
  }

}
