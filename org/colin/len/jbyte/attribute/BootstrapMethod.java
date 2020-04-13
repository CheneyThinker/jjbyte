package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BootstrapMethod {

  private int bootstrapMethodRef;
  private int[] bootstrapArguments;

  public BootstrapMethod(DataInputStream dataInputStream) throws IOException {
    bootstrapMethodRef = dataInputStream.readUnsignedShort();
    final int numBootstrapArguments = dataInputStream.readUnsignedShort();
    bootstrapArguments = new int[numBootstrapArguments];
    for (int i = 0; i < numBootstrapArguments; i++) {
      bootstrapArguments[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int getBootstrapMethodRef() {
    return bootstrapMethodRef;
  }

  public void setBootstrapMethodRef(int bootstrapMethodRef) {
    this.bootstrapMethodRef = bootstrapMethodRef;
  }

  public int[] getBootstrapArguments() {
    return bootstrapArguments == null ? new int[0] : bootstrapArguments;
  }

  public void setBootstrapArguments(int[] bootstrapArguments) {
    this.bootstrapArguments = bootstrapArguments;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(bootstrapMethodRef);
    final int numBootstrapArguments = getBootstrapArguments().length;
    dataOutputStream.writeShort(numBootstrapArguments);
    for (int i = 0; i < numBootstrapArguments; i++) {
      dataOutputStream.writeShort(bootstrapArguments[i]);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(bootstrapMethodRef = ").append(bootstrapMethodRef);
    for (int i = 0, j = getBootstrapArguments().length; i < j; i++) {
      if (i == 0) {
        builder.append(", bootstrapArguments = [ ");
      }
      builder.append(bootstrapArguments[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    return builder.toString();
  }

}
