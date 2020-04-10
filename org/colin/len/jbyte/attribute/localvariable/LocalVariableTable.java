package org.colin.len.jbyte.attribute.localvariable;

import java.io.DataInputStream;
import java.io.IOException;

public class LocalVariableTable {

  private int startPC;
  private int length;
  private int nameIndex;
  private int descriptorIndex;
  private int index;

  public LocalVariableTable(DataInputStream dataInputStream) throws IOException {
    setStartPC(dataInputStream.readUnsignedShort());
    setLength(dataInputStream.readUnsignedShort());
    setNameIndex(dataInputStream.readUnsignedShort());
    setDescriptorIndex(dataInputStream.readUnsignedShort());
    setIndex(dataInputStream.readUnsignedShort());
  }

  public int getStartPC() {
    return startPC;
  }

  public void setStartPC(int startPC) {
    this.startPC = startPC;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getNameIndex() {
    return nameIndex;
  }

  public void setNameIndex(int nameIndex) {
    this.nameIndex = nameIndex;
  }

  public int getDescriptorIndex() {
    return descriptorIndex;
  }

  public void setDescriptorIndex(int descriptorIndex) {
    this.descriptorIndex = descriptorIndex;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

}
