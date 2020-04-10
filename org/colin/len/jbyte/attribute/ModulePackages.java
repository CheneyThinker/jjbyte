package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class ModulePackages extends Attribute {

  private int packageCount;
  private int packageIndex[];

  public ModulePackages(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setPackageCount(dataInputStream.readUnsignedShort());
    setPackageIndex(new int[packageCount]);
    for (int i = 0; i < packageCount; i++) {
      packageIndex[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int getPackageCount() {
    return packageCount;
  }

  public void setPackageCount(int packageCount) {
    this.packageCount = packageCount;
  }

  public int[] getPackageIndex() {
    return packageIndex;
  }

  public void setPackageIndex(int[] packageIndex) {
    this.packageIndex = packageIndex;
  }

}
