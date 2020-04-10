package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class ParameterAnnotations {

  private int numAnnotations;
  private Annotation annotations[];

  public ParameterAnnotations(DataInputStream dataInputStream) throws IOException {
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
