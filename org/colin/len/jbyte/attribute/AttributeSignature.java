package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeSignature extends Attribute {

  private int signatureIndex;

  public AttributeSignature(DataInputStream dataInputStream) throws IOException {
    signatureIndex = dataInputStream.readUnsignedShort();
  }

  public int getSignatureIndex() {
    return signatureIndex;
  }

  public void setSignatureIndex(int signatureIndex) {
    this.signatureIndex = signatureIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(signatureIndex);
  }

  public String toString() {
    return String.format("%s(signatureIndex = %d)", super.toString(), signatureIndex);
  }

}
