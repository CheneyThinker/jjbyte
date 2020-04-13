package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstValueIndex extends ElementValue {

  private int constValueIndex;

  public ConstValueIndex(DataInputStream dataInputStream) throws IOException {
    constValueIndex = dataInputStream.readUnsignedShort();
  }

  public int getConstValueIndex() {
    return constValueIndex;
  }

  public void setConstValueIndex(int constValueIndex) {
    this.constValueIndex = constValueIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(constValueIndex);
  }

  public String toString() {
    return String.format("%s, constValueIndex = %d)", super.toString(), constValueIndex);
  }

}
