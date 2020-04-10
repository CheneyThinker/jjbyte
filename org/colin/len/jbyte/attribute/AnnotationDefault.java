package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.annotation.ElementValue;

public class AnnotationDefault extends Attribute {

  private ElementValue defaultValue;

  public AnnotationDefault(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setDefaultValue(ElementValue.readElementValue(dataInputStream));
  }

  public ElementValue getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(ElementValue defaultValue) {
    this.defaultValue = defaultValue;
  }

}
