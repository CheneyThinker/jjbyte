package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.bootstrapmethods.BootstrapMethod;

public class BootstrapMethods extends Attribute {

  private int numBootstrapMethods;
  private BootstrapMethod bootstrapMethods[];

  public BootstrapMethods(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumBootstrapMethods(dataInputStream.readUnsignedShort());
    setBootstrapMethods(new BootstrapMethod[numBootstrapMethods]);
    for (int i = 0; i < numBootstrapMethods; i++) {
      bootstrapMethods[i] = new BootstrapMethod(dataInputStream);
    }
  }

  public int getNumBootstrapMethods() {
    return numBootstrapMethods;
  }

  public void setNumBootstrapMethods(int numBootstrapMethods) {
    this.numBootstrapMethods = numBootstrapMethods;
  }

  public BootstrapMethod[] getBootstrapMethods() {
    return bootstrapMethods;
  }

  public void setBootstrapMethods(BootstrapMethod[] bootstrapMethods) {
    this.bootstrapMethods = bootstrapMethods;
  }

}
