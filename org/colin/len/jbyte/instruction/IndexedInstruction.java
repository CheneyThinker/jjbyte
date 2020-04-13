package org.colin.len.jbyte.instruction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.Opcode;

public class IndexedInstruction extends Instruction {

  protected int index;//index of referenced variable

  public void adjust(DataInputStream dataInputStream, boolean wide) throws IOException {
    short opcode = getOpcode();
    if ((opcode == Opcode.BIPUSH) ||  //Constants
        (opcode == Opcode.NEWARRAY)   //References
       ) {
      length = length + 2;
      index = dataInputStream.readByte();
    } else if (opcode == Opcode.LDC) {//Constants
      length = length + 2;
      index = dataInputStream.readUnsignedByte();
    } else if (
               (opcode == Opcode.SIPUSH) ||                               //Constants
               (opcode >= Opcode.IFEQ    && opcode <= Opcode.IF_ACMPNE) ||//Comparisons
               (opcode == Opcode.GOTO    || opcode == Opcode.JSR) ||      //Control
               (opcode == Opcode.IFNULL  || opcode == Opcode.IFNONNULL)   //Extended
              ) {
      length = length + 3;
      index = dataInputStream.readShort();
    } else if (
               (opcode == Opcode.LDC_W      || opcode == Opcode.LDC2_W)       ||//Constants
               ((opcode >= Opcode.GETSTATIC && opcode <= Opcode.INVOKESTATIC) ||//References
                 opcode == Opcode.NEW       || opcode == Opcode.ANEWARRAY     ||//References
                 opcode == Opcode.CHECKCAST || opcode == Opcode.INSTANCEOF)     //References
              ) {
      length = length + 3;
      index = dataInputStream.readUnsignedShort();
    } else if (
               (opcode >= Opcode.ILOAD  && opcode <= Opcode.ALOAD)  ||//Loads
               (opcode >= Opcode.ISTORE && opcode <= Opcode.ASTORE) ||//Stores
               (opcode == Opcode.RET)                                 //Control
              ) {
      if (wide) {
        length = length + 4;
        index = dataInputStream.readUnsignedShort();
      } else {
        length = length + 2;
        index = dataInputStream.readUnsignedByte();
      }
    } else if (opcode == Opcode.INVOKEDYNAMIC) {//References
      length = length + 5;
      index = dataInputStream.readUnsignedShort();
      dataInputStream.skipBytes(2);//skip 0
    } else if ((opcode == Opcode.GOTO_W || opcode == Opcode.JSR_W)) {//Extended
      length = length + 5;
      index = dataInputStream.readInt();
    }
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    short opcode = getOpcode();
    if (
        (opcode == Opcode.BIPUSH || opcode == Opcode.LDC) ||//Constants
        (opcode == Opcode.NEWARRAY)                         //References
       ) {
      dataOutputStream.writeByte(opcode);
      dataOutputStream.writeByte(index);
    } else if (
               (opcode == Opcode.SIPUSH     || opcode == Opcode.LDC_W         ||//Constants
                opcode == Opcode.LDC2_W)                                      ||//Constants
               (opcode == Opcode.GOTO       || opcode == Opcode.JSR)          ||//Control
               (opcode >= Opcode.IFEQ       && opcode <= Opcode.IF_ACMPNE)    ||//Comparisons
               ((opcode >= Opcode.GETSTATIC && opcode <= Opcode.INVOKESTATIC) ||//References
                 opcode == Opcode.NEW       || opcode == Opcode.ANEWARRAY     ||//References
                 opcode == Opcode.CHECKCAST || opcode == Opcode.INSTANCEOF)   ||//References
               (opcode == Opcode.IFNULL     || opcode == Opcode.IFNONNULL)      //Extended
              ) {
      dataOutputStream.writeByte(opcode);
      dataOutputStream.writeShort(index);
    } else if (
               (opcode >= Opcode.ILOAD  && opcode <= Opcode.ALOAD)  ||//Loads
               (opcode >= Opcode.ISTORE && opcode <= Opcode.ASTORE) ||//Stores
               (opcode == Opcode.RET)                                 //Control
              ) {
      boolean wide = index > Opcode.MAX_BYTE;
      if (wide) {
        dataOutputStream.writeByte(Opcode.WIDE);
        dataOutputStream.writeByte(opcode);
        dataOutputStream.writeShort(index);
      } else {
        dataOutputStream.writeByte(opcode);
        dataOutputStream.writeByte(index);
      }
    } else if (opcode == Opcode.INVOKEDYNAMIC) {//References
      dataOutputStream.writeByte(opcode);
      dataOutputStream.writeShort(index);
      dataOutputStream.writeByte(0);
      dataOutputStream.writeByte(0);
    } else if ((opcode == Opcode.GOTO_W || opcode == Opcode.JSR_W)) {//Extended
      dataOutputStream.writeByte(opcode);
      dataOutputStream.writeInt(index);
    }
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String toString() {
    return String.format("%s %d", super.toString(), index);
  }

}
