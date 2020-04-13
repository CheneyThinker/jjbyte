package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeRuntimeParameterAnnotations extends Attribute {

  private boolean visible;
  private ParameterAnnotations[] annotations;

  public AttributeRuntimeParameterAnnotations(DataInputStream dataInputStream, boolean visible) throws IOException {
    this.visible = visible;
    final int numParameters = dataInputStream.readUnsignedByte();
    annotations = new ParameterAnnotations[numParameters];
    for (int i = 0; i < numParameters; i++) {
      annotations[i] = new ParameterAnnotations(dataInputStream);
    }
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public ParameterAnnotations[] getAnnotations() {
    return annotations == null ? new ParameterAnnotations[0] : annotations;
  }

  public void setAnnotations(ParameterAnnotations[] annotations) {
    this.annotations = annotations;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numParameters = getAnnotations().length;
    dataOutputStream.writeByte(numParameters);
    for (int i = 0; i < numParameters; i++) {
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
