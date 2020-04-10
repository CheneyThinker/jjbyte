package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class ModuleMainClass extends Attribute {

  private int mainClassIndex;

  public ModuleMainClass(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setMainClassIndex(dataInputStream.readUnsignedShort());
  }

  public int getMainClassIndex() {
    return mainClassIndex;
  }

  public void setMainClassIndex(int mainClassIndex) {
    this.mainClassIndex = mainClassIndex;
  }

}
