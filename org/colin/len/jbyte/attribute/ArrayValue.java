package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.factory.ElementValueFactory;

public class ArrayValue extends ElementValue {

  private ElementValue[] values;

  public ArrayValue(DataInputStream dataInputStream) throws IOException {
    final int numValues = dataInputStream.readUnsignedShort();
    values = new ElementValue[numValues];
    for (int i = 0; i < values.length; i++) {
      values[i] = ElementValueFactory.readElementValue(dataInputStream);
    }
  }

  public ElementValue[] getValues() {
    return values == null ? new ElementValue[0] : values;
  }

  public void setValues(ElementValue[] values) {
    this.values = values;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numValues = getValues().length;
    dataOutputStream.writeShort(numValues);
    for (int i = 0; i < numValues; i++) {
      values[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getValues().length; i < j; i++) {
      if (i == 0) {
        builder.append(", values = [ ");
      }
      builder.append(values[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
