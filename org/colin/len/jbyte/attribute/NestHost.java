package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class NestHost extends Attribute {

  private int hostClassIndex;

  public NestHost(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setHostClassIndex(dataInputStream.readUnsignedShort());
  }

  public int getHostClassIndex() {
    return hostClassIndex;
  }

  public void setHostClassIndex(int hostClassIndex) {
    this.hostClassIndex = hostClassIndex;
  }

}
