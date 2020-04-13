package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantDouble extends Constant {

  private double bytes;

  public ConstantDouble(DataInputStream dataInputStream) throws IOException {
    bytes = dataInputStream.readDouble();
  }

  public double getBytes() {
    return bytes;
  }

  public void setBytes(double bytes) {
    this.bytes = bytes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeDouble(bytes);
  }

  public String toString() {
    return String.format("%s(%s)", super.toString(), String.valueOf(bytes));
  }

}
