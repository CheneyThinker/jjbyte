package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.annotation.Annotation;

public class RuntimeVisibleAnnotations extends Attribute {

  private int numAnnotations;
  private Annotation annotations[];

  public RuntimeVisibleAnnotations(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumAnnotations(dataInputStream.readUnsignedShort());
    setAnnotations(new Annotation[numAnnotations]);
    for (int i = 0; i < numAnnotations; i++) {
      annotations[i] = new Annotation(dataInputStream);
    }
  }

  public int getNumAnnotations() {
    return numAnnotations;
  }

  public void setNumAnnotations(int numAnnotations) {
    this.numAnnotations = numAnnotations;
  }

  public Annotation[] getAnnotations() {
    return annotations;
  }

  public void setAnnotations(Annotation[] annotations) {
    this.annotations = annotations;
  }

}
