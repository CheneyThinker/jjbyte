package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeRuntimeTypeAnnotations extends Attribute {

  private boolean visible;
  private TypeAnnotation[] annotations;

  public AttributeRuntimeTypeAnnotations(DataInputStream dataInputStream, boolean visible) throws IOException {
    this.visible = visible;
    final int numAnnotations = dataInputStream.readUnsignedShort();
    annotations = new TypeAnnotation[numAnnotations];
    for (int i = 0; i < numAnnotations; i++) {
      annotations[i] = new TypeAnnotation(dataInputStream);
    }
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public TypeAnnotation[] getAnnotations() {
    return annotations == null ? new TypeAnnotation[0] : annotations;
  }

  public void setAnnotations(TypeAnnotation[] annotations) {
    this.annotations = annotations;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numAnnotations = getAnnotations().length;
    dataOutputStream.writeShort(numAnnotations);
    for (int i = 0; i < numAnnotations; i++) {
      annotations[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    builder.append("(visible = ").append(visible);
    for (int i = 0, j = getAnnotations().length; i < j; i++) {
      if (i == 0) {
        builder.append(", annotations = [ ");
      }
      builder.append(annotations[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
