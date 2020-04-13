package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class StackMapFrame {

  private int frameType;
  private int offsetDelta;
  private VerificationTypeInfo[] stack;
  private VerificationTypeInfo[] locals;

  public StackMapFrame(DataInputStream dataInputStream) throws IOException {
    frameType = dataInputStream.readUnsignedByte();
    if (frameType >= 0 && frameType <= 63) {
      offsetDelta = frameType;
    } else if (frameType >= 64 && frameType <= 127) {
      offsetDelta = frameType - 64;
      stack = new VerificationTypeInfo[1];
      stack[0] = new VerificationTypeInfo(dataInputStream);
    } else if (frameType == 247) {
      offsetDelta = dataInputStream.readShort();
      stack = new VerificationTypeInfo[1];
      stack[0] = new VerificationTypeInfo(dataInputStream);
    } else if (frameType >= 248 && frameType <= 250) {
      offsetDelta = dataInputStream.readShort();
    } else if (frameType == 251) {
      offsetDelta = dataInputStream.readShort();
    } else if (frameType >= 252 && frameType <= 254) {
      offsetDelta = dataInputStream.readShort();
      final int numberOfLocals = frameType - 251;
      locals = new VerificationTypeInfo[numberOfLocals];
      for (int i = 0; i < numberOfLocals; i++) {
        locals[i] = new VerificationTypeInfo(dataInputStream);
      }
    } else if (frameType == 255) {
      offsetDelta = dataInputStream.readShort();
      final int numberOfLocals = dataInputStream.readUnsignedShort();
      locals = new VerificationTypeInfo[numberOfLocals];
      for (int i = 0; i < numberOfLocals; i++) {
        locals[i] = new VerificationTypeInfo(dataInputStream);
      }
      final int numberOfStackItems = dataInputStream.readUnsignedShort();
      stack = new VerificationTypeInfo[numberOfStackItems];
      for (int i = 0; i < numberOfStackItems; i++) {
        stack[i] = new VerificationTypeInfo(dataInputStream);
      }
    }
  }

  public int getFrameType() {
    return frameType;
  }

  public void setFrameType(int frameType) {
    this.frameType = frameType;
  }

  public VerificationTypeInfo[] getStack() {
    return stack == null ? new VerificationTypeInfo[0] : stack;
  }

  public void setStack(VerificationTypeInfo[] stack) {
    this.stack = stack;
  }

  public int getOffsetDelta() {
    return offsetDelta;
  }

  public void setOffsetDelta(int offsetDelta) {
    this.offsetDelta = offsetDelta;
  }

  public VerificationTypeInfo[] getLocals() {
    return locals == null ? new VerificationTypeInfo[0] : locals;
  }

  public void setLocals(VerificationTypeInfo[] locals) {
    this.locals = locals;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.write(frameType);
    if (frameType >= 0 && frameType <= 63) {
    } else if (frameType >= 64 && frameType <= 127) {
      stack[0].dump(dataOutputStream);
    } else if (frameType == 247) {
      dataOutputStream.writeShort(offsetDelta);
      stack[0].dump(dataOutputStream);
    } else if (frameType >= 248 && frameType <= 250) {
      dataOutputStream.writeShort(offsetDelta);
    } else if (frameType == 251) {
      dataOutputStream.writeShort(offsetDelta);
    } else if (frameType >= 252 && frameType <= 254) {
      dataOutputStream.writeShort(offsetDelta);
      final int numberOfLocals = getLocals().length;
      setLocals(new VerificationTypeInfo[numberOfLocals]);
      for (int i = 0; i < numberOfLocals; i++) {
        locals[i].dump(dataOutputStream);
      }
    } else if (frameType == 255) {
      dataOutputStream.writeShort(offsetDelta);
      final int numberOfLocals = getLocals().length;
      dataOutputStream.writeShort(numberOfLocals);
      for (int i = 0; i < numberOfLocals; i++) {
        locals[i].dump(dataOutputStream);
      }
      final int numberOfStackItems = getStack().length;
      dataOutputStream.writeShort(numberOfStackItems);
      for (int i = 0; i < numberOfStackItems; i++) {
        stack[i].dump(dataOutputStream);
      }
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(frameType = ").append(frameType);
    if (frameType >= 64 && frameType <= 127) {
      builder.append(", stacks = [ ").append(stack[0]).append(" ])");
      return builder.toString();
    } else if (frameType == 247) {
      builder.append(", offsetDelta = ").append(offsetDelta).append(", stacks = [ ");
      builder.append(stack[0]).append(" ])");
      return builder.toString();
    } else if (frameType >= 248 && frameType <= 251) {
      builder.append(", offsetDelta = ").append(offsetDelta).append(")");
      return builder.toString();
    } else if (frameType >= 252 && frameType <= 254) {
      builder.append(", offsetDelta = ").append(offsetDelta);
      for (int i = 0, j = getLocals().length; i < j; i++) {
        if (i == 0) {
          builder.append(", locals = [ ");
        }
        builder.append(locals[i]).append(" ");
        if (i == j - 1) {
          builder.append("]");
        }
      }
      builder.append(")");
      return builder.toString();
    } else if (frameType == 255) {
      builder.append(", offsetDelta = ").append(offsetDelta);
      for (int i = 0, j = getLocals().length; i < j; i++) {
        if (i == 0) {
          builder.append(", locals = [ ");
        }
        builder.append(locals[i]).append(" ");
        if (i == j - 1) {
          builder.append("]");
        }
      }
      for (int i = 0, j = getStack().length; i < j; i++) {
        if (i == 0) {
          builder.append(", stacks = [ ");
        }
        builder.append(stack[i]).append(" ");
        if (i == j - 1) {
          builder.append("]");
        }
      }
      builder.append(")");
      return builder.toString();
    }
    return builder.toString();
  }

}
