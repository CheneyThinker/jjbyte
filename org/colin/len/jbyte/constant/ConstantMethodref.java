package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantMethodref extends Constant {

  private int classIndex;
  private int nameAndTypeIndex;

  public ConstantMethodref(DataInputStream dataInputStream) throws IOException {
    classIndex = dataInputStream.readUnsignedShort();
    nameAndTypeIndex = dataInputStream.readUnsignedShort();
  }

  public int getClassIndex() {
    return classIndex;
  }

  public void setClassIndex(int classIndex) {
    this.classIndex = classIndex;
  }

  public int getNameAndTypeIndex() {
    return nameAndTypeIndex;
  }

  public void setNameAndTypeIndex(int nameAndTypeIndex) {
    this.nameAndTypeIndex = nameAndTypeIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(classIndex);
    dataOutputStream.writeShort(nameAndTypeIndex);
  }

  public String toString() {
    return String.format("%s(classIndex = %d, nameAndTypeIndex = %d)", super.toString(), classIndex, nameAndTypeIndex);
  }

}
