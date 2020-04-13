package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeParameterTarget extends Target {

  private int typeParameterIndex;

  public TypeParameterTarget(DataInputStream dataInputStream) throws IOException {
    typeParameterIndex = dataInputStream.readUnsignedByte();
  }

  public int getTypeParameterIndex() {
    return typeParameterIndex;
  }

  public void setTypeParameterIndex(int typeParameterIndex) {
    this.typeParameterIndex = typeParameterIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeByte(typeParameterIndex);
  }

  public String toString() {
    return String.format("(typeParameterIndex = %d)", typeParameterIndex);
  }

}
