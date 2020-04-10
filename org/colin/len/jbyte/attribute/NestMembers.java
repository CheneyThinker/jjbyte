package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class NestMembers extends Attribute {

  private int numberOfClasses;
  private int classes[];

  public NestMembers(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumberOfClasses(dataInputStream.readUnsignedShort());
    setClasses(new int[numberOfClasses]);
    for (int i = 0; i < numberOfClasses; i++) {
      classes[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int getNumberOfClasses() {
    return numberOfClasses;
  }

  public void setNumberOfClasses(int numberOfClasses) {
    this.numberOfClasses = numberOfClasses;
  }

  public int[] getClasses() {
    return classes;
  }

  public void setClasses(int[] classes) {
    this.classes = classes;
  }

}
