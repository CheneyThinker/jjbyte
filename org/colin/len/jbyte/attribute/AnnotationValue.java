package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AnnotationValue extends ElementValue {

  private Annotation annotation;

  public AnnotationValue(DataInputStream dataInputStream) throws IOException {
    annotation = new Annotation(dataInputStream);
  }

  public Annotation getAnnotation() {
    return annotation;
  }

  public void setAnnotation(Annotation annotation) {
    this.annotation = annotation;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    annotation.dump(dataOutputStream);
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    builder.append(", annotation = ").append(annotation).append(")");
    return builder.toString();
  }

}
