package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.innerclasses.Classes;

public class InnerClasses extends Attribute {

  private int numberOfClasses;
  private Classes classes[];

  public InnerClasses(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumberOfClasses(dataInputStream.readUnsignedShort());
    setClasses(new Classes[numberOfClasses]);
    for (int i = 0; i < numberOfClasses; i++) {
      classes[i] = new Classes(dataInputStream);
    }
  }

  public int getNumberOfClasses() {
    return numberOfClasses;
  }

  public void setNumberOfClasses(int numberOfClasses) {
    this.numberOfClasses = numberOfClasses;
  }

  public Classes[] getClasses() {
    return classes;
  }

  public void setClasses(Classes[] classes) {
    this.classes = classes;
  }

}
