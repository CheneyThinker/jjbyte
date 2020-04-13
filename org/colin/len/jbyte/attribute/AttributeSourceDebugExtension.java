package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.util.JByteUtils;

public class AttributeSourceDebugExtension extends Attribute {

  private byte[] debugExtension;

  public AttributeSourceDebugExtension(DataInputStream dataInputStream, int attributeLength) throws IOException {
    debugExtension = new byte[attributeLength];
    dataInputStream.readFully(debugExtension);
  }

  public byte[] getDebugExtension() {
    return debugExtension == null ? new byte[0] : debugExtension;
  }

  public void setDebugExtension(byte[] debugExtension) {
    this.debugExtension = debugExtension;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.write(debugExtension);
  }

  public String toString() {
    return String.format("%s(debugExtension = %s)", super.toString(), JByteUtils.toHexString(debugExtension));
  }

}
