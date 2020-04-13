package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Classes {

  private int innerClassInfoIndex;
  private int outerClassInfoIndex;
  private int innerNameIndex;
  private int innerClassAccessFlags;

  public Classes(DataInputStream dataInputStream) throws IOException {
    innerClassInfoIndex = dataInputStream.readUnsignedShort();
    outerClassInfoIndex = dataInputStream.readUnsignedShort();
    innerNameIndex = dataInputStream.readUnsignedShort();
    innerClassAccessFlags = dataInputStream.readUnsignedShort();
  }

  public int getInnerClassInfoIndex() {
    return innerClassInfoIndex;
  }

  public void setInnerClassInfoIndex(int innerClassInfoIndex) {
    this.innerClassInfoIndex = innerClassInfoIndex;
  }

  public int getOuterClassInfoIndex() {
    return outerClassInfoIndex;
  }

  public void setOuterClassInfoIndex(int outerClassInfoIndex) {
    this.outerClassInfoIndex = outerClassInfoIndex;
  }

  public int getInnerNameIndex() {
    return innerNameIndex;
  }

  public void setInnerNameIndex(int innerNameIndex) {
    this.innerNameIndex = innerNameIndex;
  }

  public int getInnerClassAccessFlags() {
    return innerClassAccessFlags;
  }

  public void setInnerClassAccessFlags(int innerClassAccessFlags) {
    this.innerClassAccessFlags = innerClassAccessFlags;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(innerClassInfoIndex);
    dataOutputStream.writeShort(outerClassInfoIndex);
    dataOutputStream.writeShort(innerNameIndex);
    dataOutputStream.writeShort(innerClassAccessFlags);
  }

  public String toString() {
    return String.format("(innerClassInfoIndex = %d, outerClassInfoIndex = %d, innerNameIndex = %d, innerClassAccessFlags = %d)", innerClassInfoIndex, outerClassInfoIndex, innerNameIndex, innerClassAccessFlags);
  }

}
