package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.factory.ElementValueFactory;

public class ElementValuePairs {

  private int elementNameIndex;
  private ElementValue value;

  public ElementValuePairs(DataInputStream dataInputStream) throws IOException {
    elementNameIndex = dataInputStream.readUnsignedShort();
    value = ElementValueFactory.readElementValue(dataInputStream);
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

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(elementNameIndex);
    value.dump(dataOutputStream);
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(elementNameIndex = ").append(elementNameIndex);
    builder.append(", value = ").append(value).append(")");
    return builder.toString();
  }

}
