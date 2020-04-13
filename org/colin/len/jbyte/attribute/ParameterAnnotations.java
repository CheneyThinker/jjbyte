package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ParameterAnnotations {

  private Annotation[] annotations;

  public ParameterAnnotations(DataInputStream dataInputStream) throws IOException {
    final int numAnnotations = dataInputStream.readUnsignedShort();
    annotations = new Annotation[numAnnotations];
    for (int i = 0; i < numAnnotations; i++) {
      annotations[i] = new Annotation(dataInputStream);
    }
  }

  public Annotation[] getAnnotations() {
    return annotations == null ? new Annotation[0] : annotations;
  }

  public void setAnnotations(Annotation[] annotations) {
    this.annotations = annotations;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    final int numAnnotations = getAnnotations().length;
    dataOutputStream.writeShort(numAnnotations);
    for (int i = 0; i < numAnnotations; i++) {
      annotations[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getAnnotations().length; i < j; i++) {
      if (i == 0) {
        builder.append("(annotations = [ ");
      }
      builder.append(annotations[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
