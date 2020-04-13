package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class VerificationTypeInfo {

  private int tag;
  private int value;

  public VerificationTypeInfo(DataInputStream dataInputStream) throws IOException {
    tag = dataInputStream.readUnsignedByte();
    switch (tag) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        break;
      case 7:
      case 8:
        value = dataInputStream.readUnsignedShort();
        break;
    }
  }

  public int getTag() {
    return tag;
  }

  public void setTag(int tag) {
    this.tag = tag;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeByte(tag);
    if (tag == 7 || tag == 8) {
      dataOutputStream.writeShort(value);
    }
  }

  public String toString() {
    if (tag == 7) {
      return String.format("(tag = %d, cpoolIndex = %d)", tag, value);
    } else if (tag == 8) {
      return String.format("(tag = %d, offset = %d)", tag, value);
    } else {
      return String.format("(tag = %d)", tag);
    }
  }

}
