package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class ElementValuePairs {

  private int elementNameIndex;
  private ElementValue value;

  public ElementValuePairs(DataInputStream dataInputStream) throws IOException {
    setElementNameIndex(dataInputStream.readUnsignedShort());
    setValue(ElementValue.readElementValue(dataInputStream));
  }

  public int getElementNameIndex() {
    return elementNameIndex;
  }

  public void setElementNameIndex(int elementNameIndex) {
    this.elementNameIndex = elementNameIndex;
  }

  public ElementValue getValue() {
    return value;
  }

  public void setValue(ElementValue value) {
    this.value = value;
  }

}
