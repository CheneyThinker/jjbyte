package org.colin.len.jbyte.instruction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.Opcode;

public class IndexedValueInstruction extends Instruction {

  private int index;
  private int value;

  public void adjust(DataInputStream dataInputStream, boolean wide) throws IOException {
    switch (getOpcode()) {
    case Opcode.MULTIANEWARRAY:
      length = length + 4;
      index = dataInputStream.readUnsignedShort();
      value = dataInputStream.readByte();//dimensions
      break;
    case Opcode.IINC:
      if (wide) {
        length = length + 6;
        index = dataInputStream.readUnsignedShort();
        value = dataInputStream.readShort();//increment
      } else {
        length = length + 3;
        index = dataInputStream.readUnsignedByte();
        value = dataInputStream.readByte();//increment
      }
      break;
    case Opcode.INVOKEINTERFACE:
      length = length + 5;
      index = dataInputStream.readUnsignedShort();
      value = dataInputStream.readUnsignedByte();//count
      dataInputStream.skipBytes(1);//skip 0
      break;
    }
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    short opcode = getOpcode();
    switch (opcode) {
    case Opcode.MULTIANEWARRAY:
      dataOutputStream.writeByte(opcode);
      dataOutputStream.writeShort(index);
      dataOutputStream.writeByte(value);//dimensions
      break;
    case Opcode.IINC:
      boolean wide = index > Opcode.MAX_BYTE || (value > 0 ? value > Byte.MAX_VALUE : value < Byte.MIN_VALUE);
      if (wide) {
        dataOutputStream.writeByte(Opcode.WIDE);
        dataOutputStream.writeByte(opcode);
        dataOutputStream.writeShort(index);
        dataOutputStream.writeShort(value);//increment
      } else {
        dataOutputStream.writeByte(opcode);
        dataOutputStream.writeByte(index);
        dataOutputStream.writeByte(value);//increment
      }
      break;
    case Opcode.INVOKEINTERFACE:
      dataOutputStream.writeByte(opcode);
      dataOutputStream.writeShort(index);
      dataOutputStream.writeByte(value);//count
      dataOutputStream.writeByte(0);
      break;
    }
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String toString() {
    return String.format("%s %d %d", super.toString(), index, value);
  }

}
