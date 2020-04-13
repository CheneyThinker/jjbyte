package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeBootstrapMethods extends Attribute {

  private BootstrapMethod[] bootstrapMethods;

  public AttributeBootstrapMethods(DataInputStream dataInputStream) throws IOException {
    final int numBootstrapMethods = dataInputStream.readUnsignedShort();
    bootstrapMethods = new BootstrapMethod[numBootstrapMethods];
    for (int i = 0; i < numBootstrapMethods; i++) {
      bootstrapMethods[i] = new BootstrapMethod(dataInputStream);
    }
  }

  public BootstrapMethod[] getBootstrapMethods() {
    return bootstrapMethods == null ? new BootstrapMethod[0] : bootstrapMethods;
  }

  public void setBootstrapMethods(BootstrapMethod[] bootstrapMethods) {
    this.bootstrapMethods = bootstrapMethods;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numBootstrapMethods = getBootstrapMethods().length;
    dataOutputStream.writeShort(numBootstrapMethods);
    for (int i = 0; i < numBootstrapMethods; i++) {
      bootstrapMethods[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getBootstrapMethods().length; i < j; i++) {
      if (i == 0) {
        builder.append("(bootstrapMethods = [ ");
      }
      builder.append(bootstrapMethods[i]).append(" ");
      if (i == j) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
