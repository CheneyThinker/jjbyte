package org.colin.len.jbyte.constant;

import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.JByte;

public abstract class Constant {

  private int tag;

  public int getTag() {
    return tag;
  }

  public void setTag(int tag) {
    this.tag = tag;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeByte(tag);
  }

  public String toString() {
    return String.format("%s[%d]", JByte.CONSTANT_NAMES[tag], tag);
  }

}
