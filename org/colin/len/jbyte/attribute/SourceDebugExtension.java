package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class SourceDebugExtension extends Attribute {

  private byte debugExtension[];

  public SourceDebugExtension(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setDebugExtension(new byte[attributeLength]);
    dataInputStream.readFully(debugExtension);
  }

  public byte[] getDebugExtension() {
    return debugExtension;
  }

  public void setDebugExtension(byte[] debugExtension) {
    this.debugExtension = debugExtension;
  }

}
