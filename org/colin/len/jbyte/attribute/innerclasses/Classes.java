package org.colin.len.jbyte.attribute.innerclasses;

import java.io.DataInputStream;
import java.io.IOException;

public class Classes {

  private int innerClassInfoIndex;
  private int outerClassInfoIndex;
  private int innerNameIndex;
  private int innerClassAccessFlags;

  public Classes(DataInputStream dataInputStream) throws IOException {
    setInnerClassInfoIndex(dataInputStream.readUnsignedShort());
    setOuterClassInfoIndex(dataInputStream.readUnsignedShort());
    setInnerNameIndex(dataInputStream.readUnsignedShort());
    setInnerClassAccessFlags(dataInputStream.readUnsignedShort());
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

}
