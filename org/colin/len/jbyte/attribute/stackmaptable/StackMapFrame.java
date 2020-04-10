package org.colin.len.jbyte.attribute.stackmaptable;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.JByte;

public class StackMapFrame {

  private int frameType;
  private int offsetDelta;
  private int numberOfLocals;
  private VerificationTypeInfo locals[];
  private int numberOfStackItems;
  private VerificationTypeInfo stack[];

  public StackMapFrame(DataInputStream dataInputStream) throws IOException {
    //setFrameType(dataInputStream.readByte() & 0xff);
    setFrameType(dataInputStream.readUnsignedByte());
    if (frameType >= JByte.SAME_FRAME && frameType <= JByte.SAME_FRAME_MAX) {
      offsetDelta = frameType - JByte.SAME_FRAME;
    } else if (frameType >= JByte.SAME_LOCALS_1_STACK_ITEM_FRAME && frameType <= JByte.SAME_LOCALS_1_STACK_ITEM_FRAME_MAX) {
      offsetDelta = frameType - JByte.SAME_LOCALS_1_STACK_ITEM_FRAME;
      setNumberOfStackItems(1);
      setStack(new VerificationTypeInfo[numberOfStackItems]);
      for (int i = 0; i < numberOfStackItems; i++) {
        stack[i] = new VerificationTypeInfo(dataInputStream);
      }
    } else if (frameType == JByte.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED) {
      offsetDelta = dataInputStream.readShort();
      setNumberOfStackItems(1);
      setStack(new VerificationTypeInfo[numberOfStackItems]);
      for (int i = 0; i < numberOfStackItems; i++) {
        stack[i] = new VerificationTypeInfo(dataInputStream);
      }
    } else if (frameType >= JByte.CHOP_FRAME && frameType <= JByte.CHOP_FRAME_MAX) {
      offsetDelta = dataInputStream.readShort();
    } else if (frameType == JByte.SAME_FRAME_EXTENDED) {
      offsetDelta = dataInputStream.readShort();
    } else if (frameType >= JByte.APPEND_FRAME && frameType <= JByte.APPEND_FRAME_MAX) {
      offsetDelta = dataInputStream.readShort();
      setNumberOfLocals(frameType - 251);
      setLocals(new VerificationTypeInfo[numberOfLocals]);
      for (int i = 0; i < numberOfLocals; i++) {
        locals[i] = new VerificationTypeInfo(dataInputStream);
      }
    } else if (frameType == JByte.FULL_FRAME) {
      offsetDelta = dataInputStream.readShort();
      setNumberOfLocals(dataInputStream.readShort());
      setLocals(new VerificationTypeInfo[numberOfLocals]);
      for (int i = 0; i < numberOfLocals; i++) {
        locals[i] = new VerificationTypeInfo(dataInputStream);
      }
      setNumberOfStackItems(dataInputStream.readShort());
      setStack(new VerificationTypeInfo[numberOfStackItems]);
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

  public int getOffsetDelta() {
    return offsetDelta;
  }

  public void setOffsetDelta(int offsetDelta) {
    this.offsetDelta = offsetDelta;
  }

  public int getNumberOfLocals() {
    return numberOfLocals;
  }

  public void setNumberOfLocals(int numberOfLocals) {
    this.numberOfLocals = numberOfLocals;
  }

  public VerificationTypeInfo[] getLocals() {
    return locals;
  }

  public void setLocals(VerificationTypeInfo[] locals) {
    this.locals = locals;
  }

  public int getNumberOfStackItems() {
    return numberOfStackItems;
  }

  public void setNumberOfStackItems(int numberOfStackItems) {
    this.numberOfStackItems = numberOfStackItems;
  }

  public VerificationTypeInfo[] getStack() {
    return stack;
  }

  public void setStack(VerificationTypeInfo[] stack) {
    this.stack = stack;
  }

}
