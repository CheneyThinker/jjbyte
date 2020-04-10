package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class EnclosingMethod extends Attribute {

  private int classIndex;
  private int methodIndex;

  public EnclosingMethod(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setClassIndex(dataInputStream.readUnsignedShort());
    setMethodIndex(dataInputStream.readUnsignedShort());
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

}
