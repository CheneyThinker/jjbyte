package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EnumConstValue extends ElementValue {

  private int typeNameIndex;
  private int constNameIndex;

  public EnumConstValue(DataInputStream dataInputStream) throws IOException {
    typeNameIndex = dataInputStream.readUnsignedShort();
    constNameIndex = dataInputStream.readUnsignedShort();
  }

  public int getTypeNameIndex() {
    return typeNameIndex;
  }

  public void setTypeNameIndex(int typeNameIndex) {
    this.typeNameIndex = typeNameIndex;
  }

  public int getConstNameIndex() {
    return constNameIndex;
  }

  public void setConstNameIndex(int constNameIndex) {
    this.constNameIndex = constNameIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(typeNameIndex);
    dataOutputStream.writeShort(constNameIndex);
  }

  public String toString() {
    return String.format("%s, typeNameIndex = %d, constNameIndex = %d)", super.toString(), typeNameIndex, constNameIndex);
  }

}
