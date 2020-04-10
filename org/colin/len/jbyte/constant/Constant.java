package org.colin.len.jbyte.constant;

public abstract class Constant {

  protected byte tag;

  public Constant(byte tag) {
    this.tag = tag;
  }

  public byte getTag() {
    return tag;
  }

  public void setTag(byte tag) {
    this.tag = tag;
  }

}
