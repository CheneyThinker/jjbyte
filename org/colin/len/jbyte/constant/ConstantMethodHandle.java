package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantMethodHandle extends Constant {

  private int referenceKind;
  private int referenceIndex;

  public ConstantMethodHandle(DataInputStream dataInputStream) throws IOException {
    referenceKind = dataInputStream.readUnsignedByte();
    referenceIndex = dataInputStream.readUnsignedShort();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeByte(referenceKind);
    dataOutputStream.writeShort(referenceIndex);
  }

  public String toString() {
    return String.format("%s(referenceKind = %d, referenceIndex = %d)", super.toString(), referenceKind, referenceIndex);
  }

}
