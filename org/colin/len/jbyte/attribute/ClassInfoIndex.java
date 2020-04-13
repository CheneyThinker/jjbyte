package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClassInfoIndex extends ElementValue {

  private int classInfoIndex;

  public ClassInfoIndex(DataInputStream dataInputStream) throws IOException {
    classInfoIndex = dataInputStream.readUnsignedShort();
  }

  public int getClassInfoIndex() {
    return classInfoIndex;
  }

  public void setClassInfoIndex(int classInfoIndex) {
    this.classInfoIndex = classInfoIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(classInfoIndex);
  }

  public String toString() {
    return String.format("%s, classInfoIndex = %d)", super.toString(), classInfoIndex);
  }

}
