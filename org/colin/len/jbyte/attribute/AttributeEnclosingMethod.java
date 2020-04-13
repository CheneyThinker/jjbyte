package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeEnclosingMethod extends Attribute {

  private int classIndex;
  private int methodIndex;

  public AttributeEnclosingMethod(DataInputStream dataInputStream) throws IOException {
    classIndex = dataInputStream.readUnsignedShort();
    methodIndex = dataInputStream.readUnsignedShort();
  }

  public int getClassIndex() {
    return classIndex;
  }

  public void setClassIndex(int classIndex) {
    this.classIndex = classIndex;
  }

  public int getMethodIndex() {
    return methodIndex;
  }

  public void setMethodIndex(int methodIndex) {
    this.methodIndex = methodIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(classIndex);
    dataOutputStream.writeShort(methodIndex);
  }

  public String toString() {
    return String.format("%s(classIndex = %d, methodIndex = %d)", super.toString(), classIndex, methodIndex);
  }

}
