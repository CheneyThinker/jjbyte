package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class Deprecated extends Attribute {

  public Deprecated(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
  }

}
