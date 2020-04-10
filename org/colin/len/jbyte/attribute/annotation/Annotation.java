package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class Annotation {

  private int typeIndex;
  private int numElementValuePairs;
  private ElementValuePairs elementValuePairs[];

  public Annotation(DataInputStream dataInputStream) throws IOException {
    setTypeIndex(dataInputStream.readUnsignedShort());
    setNumElementValuePairs(dataInputStream.readUnsignedShort());
    setElementValuePairs(new ElementValuePairs[numElementValuePairs]);
    for (int i = 0; i < numElementValuePairs; i++) {
      elementValuePairs[i] = new ElementValuePairs(dataInputStream);
    }
  }

  public int getTypeIndex() {
    return typeIndex;
  }

  public void setTypeIndex(int typeIndex) {
    this.typeIndex = typeIndex;
  }

  public int getNumElementValuePairs() {
    return numElementValuePairs;
  }

  public void setNumElementValuePairs(int numElementValuePairs) {
    this.numElementValuePairs = numElementValuePairs;
  }

  public ElementValuePairs[] getElementValuePairs() {
    return elementValuePairs;
  }

  public void setElementValuePairs(ElementValuePairs[] elementValuePairs) {
    this.elementValuePairs = elementValuePairs;
  }

}
