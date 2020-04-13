package org.colin.len.jbyte.factory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.colin.len.jbyte.exception.JByteException;
import org.colin.len.jbyte.fixed.Opcode;
import org.colin.len.jbyte.instruction.IndexedInstruction;
import org.colin.len.jbyte.instruction.IndexedValueInstruction;
import org.colin.len.jbyte.instruction.Instruction;
import org.colin.len.jbyte.instruction.JumpInstruction;
import org.colin.len.jbyte.util.IOUtils;

public final class InstructionFactory {

  public static final Instruction[] getInstructions(byte[] code) {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(code);
    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
    List<Instruction> instructions = new ArrayList<>();
    try {
      boolean wide;
      short opcode;
      int baseAddress = 0;
      Instruction instruction = null;
      while (dataInputStream.available() > 0) {
        wide = false;
        opcode = (short) dataInputStream.readUnsignedByte();
        if (opcode == Opcode.WIDE) {
          wide = true;
          opcode = (short) dataInputStream.readUnsignedByte();
        }
        instruction = getInstruction(opcode);
        instruction.setOpcode(opcode);
        instruction.setBaseAddress(baseAddress);
        instruction.adjust(dataInputStream, wide);
        baseAddress = baseAddress + instruction.getLength();
        instructions.add(instruction);
      }
    } catch (IOException e) {
    } finally {
      IOUtils.closeQuietly(dataInputStream);
      IOUtils.closeQuietly(byteArrayInputStream);
    }
    return instructions.toArray(new Instruction[instructions.size()]);
  }

  public static final Instruction getInstruction(short opcode) {
    if (
        (opcode >= Opcode.NOP          && opcode <= Opcode.DCONST_1)   ||//Constants
        (opcode >= Opcode.ILOAD_0      && opcode <= Opcode.SALOAD)     ||//Loads
        (opcode >= Opcode.ISTORE_0     && opcode <= Opcode.SASTORE)    ||//Stores
        (opcode >= Opcode.POP          && opcode <= Opcode.SWAP)       ||//Stack
        (opcode >= Opcode.IADD         && opcode <= Opcode.LXOR)       ||//Math
        (opcode >= Opcode.I2L          && opcode <= Opcode.I2S)        ||//Conversions
        (opcode >= Opcode.LCMP         && opcode <= Opcode.DCMPG)      ||//Comparisons
        (opcode >= Opcode.IRETURN      && opcode <= Opcode.RETURN)     ||//Control
        (opcode == Opcode.ARRAYLENGTH  || opcode == Opcode.ATHROW      ||//References
         opcode == Opcode.MONITORENTER || opcode == Opcode.MONITOREXIT)||//References
        (opcode >= Opcode.BREAKPOINT   && opcode <= Opcode.IMPDEP2)      //Reserved
       ) {
      return new Instruction();
    } else if (
               (opcode == Opcode.TABLESWITCH || opcode == Opcode.LOOKUPSWITCH) //Control
              ) {
      return new JumpInstruction();
    } else if (
               (opcode >= Opcode.BIPUSH         && opcode <= Opcode.LDC2_W)       ||//Constants
               (opcode >= Opcode.ILOAD          && opcode <= Opcode.ALOAD)        ||//Loads
               (opcode >= Opcode.ISTORE         && opcode <= Opcode.ASTORE)       ||//Stores
               (opcode >= Opcode.IFEQ           && opcode <= Opcode.IF_ACMPNE)    ||//Comparisons
               (opcode >= Opcode.GOTO           && opcode <= Opcode.RET)          ||//Control
               ((opcode >= Opcode.GETSTATIC     && opcode <= Opcode.INVOKESTATIC) ||//References
                 opcode == Opcode.NEW           || opcode == Opcode.ANEWARRAY     ||//References
                 opcode == Opcode.CHECKCAST     || opcode == Opcode.INSTANCEOF    ||//References
                 opcode == Opcode.INVOKEDYNAMIC || opcode == Opcode.NEWARRAY)     ||//References
               (opcode >= Opcode.IFNULL         && opcode <= Opcode.JSR_W)          //Extended
              ) {
      return new IndexedInstruction();
    } else if (
               (opcode == Opcode.IINC)            ||//Math
               (opcode == Opcode.INVOKEINTERFACE) ||//References
               (opcode == Opcode.MULTIANEWARRAY)    //Extended
              ) {
      return new IndexedValueInstruction();
    }
    throw new JByteException(Opcode.ILLEGAL_OPCODE.concat("(").concat(String.valueOf(opcode)).concat(")"));
  }

}
