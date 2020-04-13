package org.colin.len.jbyte.constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantUtf8 extends Constant {

  private String bytes;

  public ConstantUtf8(DataInputStream dataInputStream) throws IOException {
    bytes = dataInputStream.readUTF();
  }

  public String getBytes() {
    return bytes;
  }

  public void setBytes(String bytes) {
    this.bytes = bytes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeUTF(bytes);
  }

  public String toString() {
    return String.format("%s(\"%s\")", super.toString(), bytes);
  }

}
