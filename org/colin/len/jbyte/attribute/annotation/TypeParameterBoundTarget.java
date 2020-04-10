package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class TypeParameterBoundTarget extends Target {

  private int typeParameterIndex;
  private int boundIndex;

  public TypeParameterBoundTarget(DataInputStream dataInputStream) throws IOException {
    setTypeParameterIndex(dataInputStream.readUnsignedByte());
    setBoundIndex(dataInputStream.readUnsignedByte());
  }

  public int getTypeParameterIndex() {
    return typeParameterIndex;
  }

  public void setTypeParameterIndex(int typeParameterIndex) {
    this.typeParameterIndex = typeParameterIndex;
  }

  public int getBoundIndex() {
    return boundIndex;
  }

  public void setBoundIndex(int boundIndex) {
    this.boundIndex = boundIndex;
  }

}
