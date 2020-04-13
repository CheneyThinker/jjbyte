package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeModuleMainClass extends Attribute {

  private int mainClassIndex;

  public AttributeModuleMainClass(DataInputStream dataInputStream) throws IOException {
    mainClassIndex = dataInputStream.readUnsignedShort();
  }

  public int getMainClassIndex() {
    return mainClassIndex;
  }

  public void setMainClassIndex(int mainClassIndex) {
    this.mainClassIndex = mainClassIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(mainClassIndex);
  }

  public String toString() {
    return String.format("%s(mainClassIndex = %d)", super.toString(), mainClassIndex);
  }

}
