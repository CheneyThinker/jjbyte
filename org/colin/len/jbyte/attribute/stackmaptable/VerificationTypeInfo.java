package org.colin.len.jbyte.attribute.stackmaptable;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.JByte;

public class VerificationTypeInfo {

  private int tag;
  private int cpoolIndex;
  private int offset;

  public VerificationTypeInfo(DataInputStream dataInputStream) throws IOException {
    setTag(dataInputStream.readUnsignedByte());
    if (tag == JByte.ITEM_Object) {
      setCpoolIndex(dataInputStream.readShort());
    } else if (tag == JByte.ITEM_Uninitialized) {
      setOffset(dataInputStream.readShort());
    }
  }

  public int getTag() {
    return tag;
  }

  public void setTag(int tag) {
    this.tag = tag;
  }


  public int getCpoolIndex() {
    return cpoolIndex;
  }


  public void setCpoolIndex(int cpoolIndex) {
    this.cpoolIndex = cpoolIndex;
  }


  public int getOffset() {
    return offset;
  }


  public void setOffset(int offset) {
    this.offset = offset;
  }

}
