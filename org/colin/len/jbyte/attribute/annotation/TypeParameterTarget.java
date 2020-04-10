package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class TypeParameterTarget extends Target {

  private int typeParameterIndex;

  public TypeParameterTarget(DataInputStream dataInputStream) throws IOException {
    setTypeParameterIndex(dataInputStream.readUnsignedByte());
  }

  public int getTypeParameterIndex() {
    return typeParameterIndex;
  }

  public void setTypeParameterIndex(int typeParameterIndex) {
    this.typeParameterIndex = typeParameterIndex;
  }

}
