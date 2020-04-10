package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class ArrayElementValue extends ElementValue {

  private int numValues;
  private ElementValue values[];

  public ArrayElementValue(byte tag, DataInputStream dataInputStream) throws IOException {
    setTag(tag);
    setNumValues(dataInputStream.readUnsignedShort());
    setValues(new ElementValue[numValues]);
    for (int i = 0; i < numValues; i++) {
      values[i] = ElementValue.readElementValue(dataInputStream);
    }
  }

  public int getNumValues() {
    return numValues;
  }

  public void setNumValues(int numValues) {
    this.numValues = numValues;
  }

  public ElementValue[] getValues() {
    return values;
  }

  public void setValues(ElementValue[] values) {
    this.values = values;
  }

}
