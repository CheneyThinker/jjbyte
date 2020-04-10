package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantMethodHandle extends Constant {

  private int referenceKind;
  private int referenceIndex;

  public ConstantMethodHandle(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setReferenceKind(dataInputStream.readUnsignedByte());
    setReferenceIndex(dataInputStream.readUnsignedShort());
  }

  public int getReferenceKind() {
    return referenceKind;
  }

  public void setReferenceKind(int referenceKind) {
    this.referenceKind = referenceKind;
  }

  public int getReferenceIndex() {
    return referenceIndex;
  }

  public void setReferenceIndex(int referenceIndex) {
    this.referenceIndex = referenceIndex;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantMethodHandle");
    builder.append("[").append(tag).append("]");
    builder.append("(referenceKind = ").append(referenceKind);
    builder.append(", referenceIndex = ").append(referenceIndex).append(")");
    return builder.toString();
  }

}
