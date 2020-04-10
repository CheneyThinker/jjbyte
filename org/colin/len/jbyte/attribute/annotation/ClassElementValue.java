package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassElementValue extends ElementValue {

  private int classInfoIndex;

  public ClassElementValue(byte tag, DataInputStream dataInputStream) throws IOException {
    setTag(tag);
    setClassInfoIndex(dataInputStream.readUnsignedShort());
  }

  public int getClassInfoIndex() {
    return classInfoIndex;
  }

  public void setClassInfoIndex(int classInfoIndex) {
    this.classInfoIndex = classInfoIndex;
  }

}
