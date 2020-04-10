package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.stackmaptable.StackMapFrame;

public class StackMapTable extends Attribute {

  private int numberOfEntries;
  private StackMapFrame entries[];

  public StackMapTable(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumberOfEntries(dataInputStream.readUnsignedShort());
    setEntries(new StackMapFrame[numberOfEntries]);
    for (int i = 0; i < numberOfEntries; i++) {
      entries[i] = new StackMapFrame(dataInputStream);
    }
  }

  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  public void setNumberOfEntries(int numberOfEntries) {
    this.numberOfEntries = numberOfEntries;
  }

  public StackMapFrame[] getEntries() {
    return entries;
  }

  public void setEntries(StackMapFrame[] entries) {
    this.entries = entries;
  }

}
