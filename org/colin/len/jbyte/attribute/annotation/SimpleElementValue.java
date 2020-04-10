package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class SimpleElementValue extends ElementValue {

  private int constValueIndex;

  public SimpleElementValue(byte tag, DataInputStream dataInputStream) throws IOException {
    setTag(tag);
    setConstValueIndex(dataInputStream.readUnsignedShort());
  }

  public int getConstValueIndex() {
    return constValueIndex;
  }

  public void setConstValueIndex(int constValueIndex) {
    this.constValueIndex = constValueIndex;
  }

}
