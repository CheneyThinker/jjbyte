package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SuperTypeTarget extends Target {

  private int superTypeIndex;

  public SuperTypeTarget(DataInputStream dataInputStream) throws IOException {
    superTypeIndex = dataInputStream.readUnsignedShort();
  }

  public int getSuperTypeIndex() {
    return superTypeIndex;
  }

  public void setSuperTypeIndex(int superTypeIndex) {
    this.superTypeIndex = superTypeIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(superTypeIndex);
  }

  public String toString() {
    return String.format("(superTypeIndex = %d)", superTypeIndex);
  }

}
