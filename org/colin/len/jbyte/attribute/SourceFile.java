package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class SourceFile extends Attribute {

  private int sourcefileIndex;

  public SourceFile(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setSourcefileIndex(dataInputStream.readUnsignedShort());
  }

  public int getSourcefileIndex() {
    return sourcefileIndex;
  }

  public void setSourcefileIndex(int sourcefileIndex) {
    this.sourcefileIndex = sourcefileIndex;
  }

}
