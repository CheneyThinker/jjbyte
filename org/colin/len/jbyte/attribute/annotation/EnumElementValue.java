package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class EnumElementValue extends ElementValue {

  private int typeNameIndex;
  private int constNameIndex;

  public EnumElementValue(byte tag, DataInputStream dataInputStream) throws IOException {
    setTag(tag);
    setTypeNameIndex(dataInputStream.readUnsignedShort());
    setConstNameIndex(dataInputStream.readUnsignedShort());
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

}
