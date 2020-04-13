package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ExceptionTable {

  private int startPC;
  private int endPC;
  private int handlerPC;
  private int catchType;

  public ExceptionTable(DataInputStream dataInputStream) throws IOException {
    startPC = dataInputStream.readUnsignedShort();
    endPC = dataInputStream.readUnsignedShort();
    handlerPC = dataInputStream.readUnsignedShort();
    catchType = dataInputStream.readUnsignedShort();
  }

  public int getStartPC() {
    return startPC;
  }

  public void setStartPC(int startPC) {
    this.startPC = startPC;
  }

  public int getEndPC() {
    return endPC;
  }

  public void setEndPC(int endPC) {
    this.endPC = endPC;
  }

  public int getHandlerPC() {
    return handlerPC;
  }

  public void setHandlerPC(int handlerPC) {
    this.handlerPC = handlerPC;
  }

  public int getCatchType() {
    return catchType;
  }

  public void setCatchType(int catchType) {
    this.catchType = catchType;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeShort(startPC);
    dataOutputStream.writeShort(endPC);
    dataOutputStream.writeShort(handlerPC);
    dataOutputStream.writeShort(catchType);
  }

  public String toString() {
    return String.format("(startPC = %d, endPC = %d, handlerPC = %d, catchType = %d)", startPC, endPC, handlerPC, catchType);
  }

}
