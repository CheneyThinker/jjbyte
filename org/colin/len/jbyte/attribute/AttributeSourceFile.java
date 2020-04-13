package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeSourceFile extends Attribute {

  private int sourceFileIndex;

  public AttributeSourceFile(DataInputStream dataInputStream) throws IOException {
    sourceFileIndex = dataInputStream.readUnsignedShort();
  }

  public int getSourceFileIndex() {
    return sourceFileIndex;
  }

  public void setSourceFileIndex(int sourceFileIndex) {
    this.sourceFileIndex = sourceFileIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(sourceFileIndex);
  }

  public String toString() {
    return String.format("%s(sourceFileIndex = %d)", super.toString(), sourceFileIndex);
  }

}
