package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class FormalParameterTarget extends Target {

  private int formalParameterIndex;

  public FormalParameterTarget(DataInputStream dataInputStream) throws IOException {
    setFormalParameterIndex(dataInputStream.readUnsignedByte());
  }

  public int getFormalParameterIndex() {
    return formalParameterIndex;
  }

  public void setFormalParameterIndex(int formalParameterIndex) {
    this.formalParameterIndex = formalParameterIndex;
  }

}
