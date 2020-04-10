package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class Signature extends Attribute {

  private int signatureIndex;

  public Signature(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setSignatureIndex(dataInputStream.readUnsignedShort());
  }

  public int getSignatureIndex() {
    return signatureIndex;
  }

  public void setSignatureIndex(int signatureIndex) {
    this.signatureIndex = signatureIndex;
  }

}
