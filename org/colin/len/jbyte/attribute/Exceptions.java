package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class Exceptions extends Attribute {

  private int numberOfExceptions;
  private int exceptionIndexTable[];

  public Exceptions(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumberOfExceptions(dataInputStream.readUnsignedShort());
    setExceptionIndexTable(new int[numberOfExceptions]);
    for (int i = 0; i < numberOfExceptions; i++) {
      exceptionIndexTable[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int getNumberOfExceptions() {
    return numberOfExceptions;
  }

  public void setNumberOfExceptions(int numberOfExceptions) {
    this.numberOfExceptions = numberOfExceptions;
  }

  public int[] getExceptionIndexTable() {
    return exceptionIndexTable;
  }

  public void setExceptionIndexTable(int[] exceptionIndexTable) {
    this.exceptionIndexTable = exceptionIndexTable;
  }

}
