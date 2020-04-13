package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeNestHost extends Attribute {

  private int hostClassIndex;

  public AttributeNestHost(DataInputStream dataInputStream) throws IOException {
    hostClassIndex = dataInputStream.readUnsignedShort();
  }

  public int getHostClassIndex() {
    return hostClassIndex;
  }

  public void setHostClassIndex(int hostClassIndex) {
    this.hostClassIndex = hostClassIndex;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(hostClassIndex);
  }

  public String toString() {
    return String.format("%s(hostClassIndex = %d)", super.toString(), hostClassIndex);
  }

}
