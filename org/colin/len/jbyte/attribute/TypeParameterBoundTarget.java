package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeParameterBoundTarget extends Target {

  private int typeParameterIndex;
  private int boundIndex;

  public TypeParameterBoundTarget(DataInputStream dataInputStream) throws IOException {
    typeParameterIndex = dataInputStream.readUnsignedByte();
    boundIndex = dataInputStream.readUnsignedByte();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeByte(typeParameterIndex);
    dataOutputStream.writeByte(boundIndex);
  }

  public String toString() {
    return String.format("(typeParameterIndex = %d, boundIndex = %d)", typeParameterIndex, boundIndex);
  }

}
