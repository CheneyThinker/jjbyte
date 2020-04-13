package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeConstantValue extends Attribute {

  private int constantValueIndex;

  public AttributeConstantValue(DataInputStream dataInputStream) throws IOException {
    constantValueIndex = dataInputStream.readUnsignedShort();
  }

  public int getConstantValueIndex() {
    return constantValueIndex;
  }

  public void setConstantValueIndex(int constantValueIndex) {
    this.constantValueIndex = constantValueIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(constantValueIndex);
  }

  public String toString() {
    return String.format("%s(constantValueIndex = %d)", super.toString(), constantValueIndex);
  }

}
