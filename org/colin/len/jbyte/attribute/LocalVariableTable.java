package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LocalVariableTable {

  private int startPC;
  private int length;
  private int nameIndex;
  private int descriptorIndex;
  private int index;

  public LocalVariableTable(DataInputStream dataInputStream) throws IOException {
    startPC = dataInputStream.readUnsignedShort();
    length = dataInputStream.readUnsignedShort();
    nameIndex = dataInputStream.readUnsignedShort();
    descriptorIndex = dataInputStream.readUnsignedShort();
    index = dataInputStream.readUnsignedShort();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(startPC);
    dataOutputStream.writeShort(length);
    dataOutputStream.writeShort(nameIndex);
    dataOutputStream.writeShort(descriptorIndex);
    dataOutputStream.writeShort(index);
  }

  public String toString() {
    return String.format("(startPC = %d, length = %d, nameIndex = %d, descriptorIndex = %d, index = %d)", startPC, length, nameIndex, descriptorIndex, index);
  }

}
