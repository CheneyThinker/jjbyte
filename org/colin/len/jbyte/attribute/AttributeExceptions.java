package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeExceptions extends Attribute {

  private int[] exceptionIndexTable;

  public AttributeExceptions(DataInputStream dataInputStream) throws IOException {
    final int numberOfExceptions = dataInputStream.readUnsignedShort();
    exceptionIndexTable = new int[numberOfExceptions];
    for (int i = 0; i < numberOfExceptions; i++) {
      exceptionIndexTable[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int[] getExceptionIndexTable() {
    return exceptionIndexTable == null ? new int[0] : exceptionIndexTable;
  }

  public void setExceptionIndexTable(int[] exceptionIndexTable) {
    this.exceptionIndexTable = exceptionIndexTable;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numberOfExceptions = getExceptionIndexTable().length;
    dataOutputStream.writeShort(numberOfExceptions);
    for (int i = 0; i < numberOfExceptions; i++) {
      dataOutputStream.writeShort(exceptionIndexTable[i]);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getExceptionIndexTable().length; i < j; i++) {
      if (i == 0) {
        builder.append("(exceptionIndexTable = [ ");
      }
      builder.append(exceptionIndexTable[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
