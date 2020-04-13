package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeLocalVariableTypeTable extends Attribute {

  private LocalVariableTypeTable[] localVariableTypeTables;

  public AttributeLocalVariableTypeTable(DataInputStream dataInputStream) throws IOException {
    final int localVariableTableLength = dataInputStream.readUnsignedShort();
    localVariableTypeTables = new LocalVariableTypeTable[localVariableTableLength];
    for (int i = 0; i < localVariableTableLength; i++) {
      localVariableTypeTables[i] = new LocalVariableTypeTable(dataInputStream);
    }
  }

  public LocalVariableTypeTable[] getLocalVariableTypeTables() {
    return localVariableTypeTables == null ? new LocalVariableTypeTable[0] : localVariableTypeTables;
  }

  public void setLocalVariableTypeTables(LocalVariableTypeTable[] localVariableTypeTables) {
    this.localVariableTypeTables = localVariableTypeTables;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int localVariableTypeTableLength = getLocalVariableTypeTables().length;
    dataOutputStream.writeShort(localVariableTypeTableLength);
    for (int i = 0; i < localVariableTypeTableLength; i++) {
      localVariableTypeTables[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getLocalVariableTypeTables().length; i < j; i++) {
      if (i == 0) {
        builder.append("(localVariableTypeTables = [ ");
      }
      builder.append(localVariableTypeTables[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
