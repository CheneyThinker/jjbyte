package org.colin.len.jbyte.attribute;

import java.io.*;

import org.colin.len.jbyte.Attribute;

public class AttributeModulePackages extends Attribute {

  private int[] packageIndex;

  public AttributeModulePackages(DataInputStream dataInputStream) throws IOException {
    final int packageCount = dataInputStream.readUnsignedShort();
    packageIndex = new int[packageCount];
    for (int i = 0; i < packageCount; i++) {
      packageIndex[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int[] getPackageIndex() {
    return packageIndex == null ? new int[0] : packageIndex;
  }

  public void setPackageIndex(int[] packageIndex) {
    this.packageIndex = packageIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int packageCount = getPackageIndex().length;
    dataOutputStream.writeShort(packageCount);
    for (int i = 0; i < packageCount; i++) {
      dataOutputStream.writeShort(packageIndex[i]);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getPackageIndex().length; i < j; i++) {
      if (i == 0) {
        builder.append("(packageIndex = [ ");
      }
      builder.append(packageIndex[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
