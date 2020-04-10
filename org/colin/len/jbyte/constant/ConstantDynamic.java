package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantDynamic extends Constant {

  private int bootstrapMethodAttrIndex;
  private int nameAndTypeIndex;

  public ConstantDynamic(byte tag, DataInputStream dataInputStream) throws IOException {
    super(tag);
    setBootstrapMethodAttrIndex(dataInputStream.readShort());
    setNameAndTypeIndex(dataInputStream.readShort());
  }

  public int getBootstrapMethodAttrIndex() {
    return bootstrapMethodAttrIndex;
  }

  public void setBootstrapMethodAttrIndex(int bootstrapMethodAttrIndex) {
    this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
  }

  public int getNameAndTypeIndex() {
    return nameAndTypeIndex;
  }

  public void setNameAndTypeIndex(int nameAndTypeIndex) {
    this.nameAndTypeIndex = nameAndTypeIndex;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("ConstantDynamic");
    builder.append("[").append(tag).append("]");
    builder.append("(bootstrapMethodAttrIndex = ").append(bootstrapMethodAttrIndex);
    builder.append(", nameAndTypeIndex = ").append(nameAndTypeIndex).append(")");
    return builder.toString();
  }

}
