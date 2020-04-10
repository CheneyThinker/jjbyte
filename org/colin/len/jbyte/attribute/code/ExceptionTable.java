package org.colin.len.jbyte.attribute.code;

import java.io.DataInputStream;
import java.io.IOException;

public class ExceptionTable {

  private int startPC;
  private int endPC;
  private int handlerPC;
  private int catchType;

  public ExceptionTable(DataInputStream dataInputStream) throws IOException {
    setStartPC(dataInputStream.readUnsignedShort());
    setEndPC(dataInputStream.readUnsignedShort());
    setHandlerPC(dataInputStream.readUnsignedShort());
    setCatchType(dataInputStream.readUnsignedShort());
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

}
