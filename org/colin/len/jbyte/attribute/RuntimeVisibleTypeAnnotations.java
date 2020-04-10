package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.annotation.TypeAnnotation;

public class RuntimeVisibleTypeAnnotations extends Attribute {

  private int numAnnotations;
  private TypeAnnotation annotations[];

  public RuntimeVisibleTypeAnnotations(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumAnnotations(dataInputStream.readUnsignedShort());
    setAnnotations(new TypeAnnotation[numAnnotations]);
    for (int i = 0; i < numAnnotations; i++) {
      annotations[i] = new TypeAnnotation(dataInputStream);
    }
  }

  public int getNumAnnotations() {
    return numAnnotations;
  }

  public void setNumAnnotations(int numAnnotations) {
    this.numAnnotations = numAnnotations;
  }

  public TypeAnnotation[] getAnnotations() {
    return annotations;
  }

  public void setAnnotations(TypeAnnotation[] annotations) {
    this.annotations = annotations;
  }

}
