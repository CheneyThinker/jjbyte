package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FormalParameterTarget extends Target {

  private int formalParameterIndex;

  public FormalParameterTarget(DataInputStream dataInputStream) throws IOException {
    formalParameterIndex = dataInputStream.readUnsignedByte();
  }

  public int getFormalParameterIndex() {
    return formalParameterIndex;
  }

  public void setFormalParameterIndex(int formalParameterIndex) {
    this.formalParameterIndex = formalParameterIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeByte(formalParameterIndex);
  }

  public String toString() {
    return String.format("(formalParameterIndex = %d)", formalParameterIndex);
  }

}
