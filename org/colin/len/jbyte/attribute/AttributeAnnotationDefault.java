package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.factory.ElementValueFactory;

public class AttributeAnnotationDefault extends Attribute {

  private ElementValue defaultValue;

  public AttributeAnnotationDefault(DataInputStream dataInputStream) throws IOException {
    defaultValue = ElementValueFactory.readElementValue(dataInputStream);
  }

  public ElementValue getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(ElementValue defaultValue) {
    this.defaultValue = defaultValue;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    defaultValue.dump(dataOutputStream);
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    builder.append("(defaultValue = ").append(defaultValue).append(")");
    return builder.toString();
  }

}
