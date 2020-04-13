package org.colin.len.jbyte.attribute;

import java.io.DataOutputStream;
import java.io.IOException;

public class ElementValue {

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
    return String.format("(tag = %d", tag);
  }

}
