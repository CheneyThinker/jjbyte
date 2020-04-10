package org.colin.len.jbyte.instruction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.exception.JByteException;
import org.colin.len.jbyte.fixed.Opcode;

public class JumpInstruction extends Instruction {

  private int padding;
  private int defaultOffset;
  private int[] matchs;
  private int[] jumpOffsets;

  public void adjust(DataInputStream dataInputStream, boolean wide) throws IOException {
    padding = (4 - ((baseAddress + 1) % 4)) % 4;
    dataInputStream.skipBytes(padding);
    defaultOffset = dataInputStream.readInt();
    int low = dataInputStream.readInt();
    int matchLength = low;
    if (getOpcode() == Opcode.TABLESWITCH) {
      int high = dataInputStream.readInt();
      matchLength = high - matchLength + 1;
    }
    matchs = new int[matchLength];
    jumpOffsets = new int[matchLength];
    if (getOpcode() == Opcode.TABLESWITCH) {
      for (int i = 0; i < matchLength; i++) {
        matchs[i] = low + i;
        jumpOffsets[i] = dataInputStream.readInt();
      }
      length = length + padding + (13 + 4 * matchLength);
    } else if (getOpcode() == Opcode.LOOKUPSWITCH) {
      for (int i = 0; i < matchLength; i++) {
        matchs[i] = dataInputStream.readInt();
        jumpOffsets[i] = dataInputStream.readInt();
      }
      length = length + padding + (9 + 4 * (matchLength * 2));
    }
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    for (int i = 0; i < padding; i++) {
      dataOutputStream.writeByte(0);
    }
    dataOutputStream.writeInt(defaultOffset);
    matchs = matchs == null ? new int[0] : matchs;
    int matchLength = matchs.length;
    switch (getOpcode()) {
    case Opcode.TABLESWITCH:
      int low = matchLength > 0 ? matchs[0] : 0;
      int high = matchLength > 0 ? matchs[matchLength - 1] : 0;
      if (low > high) {
        throw new JByteException(String.format("%s[low: %d > high: %d]", getName(), low, high));
      }
      dataOutputStream.writeInt(low);
      dataOutputStream.writeInt(high);
      for (int i = 0; i < matchLength; i++) {
        dataOutputStream.writeInt(jumpOffsets[i]);
      }
      break;
    case Opcode.LOOKUPSWITCH:
      dataOutputStream.writeInt(matchLength);
      for (int i = 0; i < matchLength; i++) {
        dataOutputStream.writeInt(matchs[i]);
        dataOutputStream.writeInt(jumpOffsets[i]);
      }
      break;
    }
  }

  public int getPadding() {
    return padding;
  }

  public void setPadding(int padding) {
    this.padding = padding;
  }

  public int getDefaultOffset() {
    return defaultOffset;
  }

  public void setDefaultOffset(int defaultOffset) {
    this.defaultOffset = defaultOffset;
  }

  public int[] getMatchs() {
    return matchs;
  }

  public void setMatchs(int[] matchs) {
    this.matchs = matchs;
  }

  public int[] getJumpOffsets() {
    return jumpOffsets;
  }

  public void setJumpOffsets(int[] jumpOffsets) {
    this.jumpOffsets = jumpOffsets;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    builder.append(" ").append(padding).append(" ").append(defaultOffset);
    builder.append(" (");
    matchs = matchs == null ? new int[0] : matchs;
    int matchLength = matchs.length;
    for (int i = 0; i < matchLength; i++) {
      builder.append(matchs[i]);
      builder.append("->");
      builder.append(jumpOffsets[i]);
      if (i < matchLength - 1) {
        builder.append(" ");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
