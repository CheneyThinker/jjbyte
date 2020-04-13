package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantFloat extends Constant {

  private float bytes;

  public ConstantFloat(DataInputStream dataInputStream) throws IOException {
    bytes = dataInputStream.readFloat();
  }

  public float getBytes() {
    return bytes;
  }

  public void setBytes(float bytes) {
    this.bytes = bytes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeFloat(bytes);
  }

  public String toString() {
    return String.format("%s(%s)", super.toString(), String.valueOf(bytes));
  }

}
