package org.colin.len.jbyte.attribute.bootstrapmethods;

import java.io.DataInputStream;
import java.io.IOException;

public class BootstrapMethod {

  private int bootstrapMethodRef;
  private int numBootstrapArguments;
  private int bootstrapArguments[];

  public BootstrapMethod(DataInputStream dataInputStream) throws IOException {
    setBootstrapMethodRef(dataInputStream.readUnsignedShort());
    setNumBootstrapArguments(dataInputStream.readUnsignedShort());
    setBootstrapArguments(new int[numBootstrapArguments]);
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

  public int getNumBootstrapArguments() {
    return numBootstrapArguments;
  }

  public void setNumBootstrapArguments(int numBootstrapArguments) {
    this.numBootstrapArguments = numBootstrapArguments;
  }

  public int[] getBootstrapArguments() {
    return bootstrapArguments;
  }

  public void setBootstrapArguments(int[] bootstrapArguments) {
    this.bootstrapArguments = bootstrapArguments;
  }

}
