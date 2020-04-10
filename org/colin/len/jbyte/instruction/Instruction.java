package org.colin.len.jbyte.instruction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.Opcode;

public class Instruction {

  private short opcode = Opcode.UNDEFINED;
  protected int popped = Opcode.UNPREDICTABLE;
  protected int pushed = Opcode.UNPREDICTABLE;
  protected int length = 0;
  protected int baseAddress = 0;

  public short getOpcode() {
    return opcode;
  }

  public void setOpcode(short opcode) {
    this.opcode = opcode;
  }

  public String getName() {
    return Opcode.OPCODE_NAMES[opcode];
  }

  public int getPopped() {
    int popped = Opcode.POPPED_STACK[opcode];
    return popped == Opcode.UNDEFINED ? this.popped : popped;
  }

  public void setPopped(int popped) {
    this.popped = popped;
  }

  public int getPushed() {
    int pushed = Opcode.PUSHED_STACK[opcode];
    return pushed == Opcode.UNDEFINED ? this.pushed : pushed;
  }

  public void setPushed(int pushed) {
    this.pushed = pushed;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getBaseAddress() {
    return baseAddress;
  }

  public void setBaseAddress(int baseAddress) {
    this.baseAddress = baseAddress;
  }

  public void adjust(DataInputStream dataInputStream, boolean wide) throws IOException {
    length = length + 1;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeByte(opcode);
  }

  public String toString() {
    return String.format("%d: %s(%d)", baseAddress, Opcode.OPCODE_NAMES[opcode], length);
  }

}
