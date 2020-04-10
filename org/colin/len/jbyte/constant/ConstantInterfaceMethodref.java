package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantInterfaceMethodref extends Constant {

  private int classIndex;
  private int nameAndTypeIndex;

  public ConstantInterfaceMethodref(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setClassIndex(dataInputStream.readUnsignedShort());
    setNameAndTypeIndex(dataInputStream.readUnsignedShort());
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

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantInterfaceMethodref");
    builder.append("[").append(tag).append("]");
    builder.append("(classIndex = ").append(classIndex);
    builder.append(", nameAndTypeIndex = ").append(nameAndTypeIndex).append(")");
    return builder.toString();
  }

}
