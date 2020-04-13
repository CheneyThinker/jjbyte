package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantDynamic extends Constant {

  private int bootstrapMethodAttrIndex;
  private int nameAndTypeIndex;

  public ConstantDynamic(DataInputStream dataInputStream) throws IOException {
    bootstrapMethodAttrIndex = dataInputStream.readUnsignedShort();
    nameAndTypeIndex = dataInputStream.readUnsignedShort();
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(bootstrapMethodAttrIndex);
    dataOutputStream.writeShort(nameAndTypeIndex);
  }

  public String toString() {
    return String.format("%s(bootstrapMethodAttrIndex = %d, nameAndTypeIndex = %d)", super.toString(), bootstrapMethodAttrIndex, nameAndTypeIndex);
  }

}
