package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Annotation {

  private int typeIndex;
  private ElementValuePairs[] elementValuePairs;

  public Annotation(DataInputStream dataInputStream) throws IOException {
    typeIndex = dataInputStream.readUnsignedShort();
    final int numElementValuePairs = dataInputStream.readUnsignedShort();
    elementValuePairs = new ElementValuePairs[numElementValuePairs];
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

  public ElementValuePairs[] getElementValuePairs() {
    return elementValuePairs == null ? new ElementValuePairs[0] : elementValuePairs;
  }

  public void setElementValuePairs(ElementValuePairs[] elementValuePairs) {
    this.elementValuePairs = elementValuePairs;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(typeIndex);
    final int numElementValuePairs = getElementValuePairs().length;
    dataOutputStream.writeShort(numElementValuePairs);
    for (int i = 0; i < numElementValuePairs; i++) {
      elementValuePairs[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(typeIndex = ").append(typeIndex);
    for (int i = 0, j = getElementValuePairs().length; i < j; i++) {
      if (i == 0) {
        builder.append(", elementValuePairs = [ ");
      }
      builder.append(elementValuePairs[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
