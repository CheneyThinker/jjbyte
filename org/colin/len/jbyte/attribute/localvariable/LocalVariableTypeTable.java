package org.colin.len.jbyte.attribute.localvariable;

import java.io.DataInputStream;
import java.io.IOException;

public class LocalVariableTypeTable {

  private int startPC;
  private int length;
  private int nameIndex;
  private int signatureIndex;
  private int index;

  public LocalVariableTypeTable(DataInputStream dataInputStream) throws IOException {
    setStartPC(dataInputStream.readUnsignedShort());
    setLength(dataInputStream.readUnsignedShort());
    setNameIndex(dataInputStream.readUnsignedShort());
    setSignatureIndex(dataInputStream.readUnsignedShort());
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

  public int getSignatureIndex() {
    return signatureIndex;
  }

  public void setSignatureIndex(int signatureIndex) {
    this.signatureIndex = signatureIndex;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

}
