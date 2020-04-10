package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class AnnotationElementValue extends ElementValue {

  private Annotation annotation;

  public AnnotationElementValue(byte tag, DataInputStream dataInputStream) throws IOException {
    setTag(tag);
    setAnnotation(new Annotation(dataInputStream));
  }

  public Annotation getAnnotation() {
    return annotation;
  }

  public void setAnnotation(Annotation annotation) {
    this.annotation = annotation;
  }

}
