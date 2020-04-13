package org.colin.len.jbyte.attribute;

import java.io.*;

import org.colin.len.jbyte.Attribute;

public class AttributeMethodParameters extends Attribute {

  private Parameters parameters[];

  public AttributeMethodParameters(DataInputStream dataInputStream) throws IOException {
    final int parametersCount = dataInputStream.readUnsignedByte();
    parameters = new Parameters[parametersCount];
    for (int i = 0; i < parametersCount; i++) {
      parameters[i] = new Parameters(dataInputStream);
    }
  }

  public Parameters[] getParameters() {
    return parameters == null ? new Parameters[0] : parameters;
  }

  public void setParameters(Parameters[] parameters) {
    this.parameters = parameters;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int parametersCount = getParameters().length;
    dataOutputStream.writeShort(parametersCount);
    for (int i = 0; i < parametersCount; i++) {
      parameters[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getParameters().length; i < j; i++) {
      if (i == 0) {
        builder.append("(parameters = [ ");
      }
      builder.append(parameters[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
