package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.ConstantPool;
import org.colin.len.jbyte.attribute.code.ExceptionTable;

public class Code extends Attribute {

  private int maxStack;
  private int maxLocals;
  private int codeLength;
  private byte code[];
  private int exceptionTableLength;
  private ExceptionTable exceptionTable[];
  private int attributesCount;
  private Attribute attributes[];

  public Code(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream, ConstantPool constantPool) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setMaxStack(dataInputStream.readUnsignedShort());
    setMaxLocals(dataInputStream.readUnsignedShort());
    setCodeLength(dataInputStream.readInt());
    setCode(new byte[codeLength]);
    dataInputStream.readFully(code);
    setExceptionTableLength(dataInputStream.readUnsignedShort());
    setExceptionTable(new ExceptionTable[exceptionTableLength]);
    for (int i = 0; i < exceptionTableLength; i++) {
      exceptionTable[i] = new ExceptionTable(dataInputStream);
    }
    setAttributesCount(dataInputStream.readUnsignedShort());
    setAttributes(new Attribute[attributesCount]);
    for (int i = 0; i < attributesCount; i++) {
      attributes[i] = Attribute.readAttribute(dataInputStream, constantPool);
    }
  }

  public int getMaxStack() {
    return maxStack;
  }

  public void setMaxStack(int maxStack) {
    this.maxStack = maxStack;
  }

  public int getMaxLocals() {
    return maxLocals;
  }

  public void setMaxLocals(int maxLocals) {
    this.maxLocals = maxLocals;
  }

  public int getCodeLength() {
    return codeLength;
  }

  public void setCodeLength(int codeLength) {
    this.codeLength = codeLength;
  }

  public byte[] getCode() {
    return code;
  }

  public void setCode(byte[] code) {
    this.code = code;
  }

  public int getExceptionTableLength() {
    return exceptionTableLength;
  }

  public void setExceptionTableLength(int exceptionTableLength) {
    this.exceptionTableLength = exceptionTableLength;
  }

  public ExceptionTable[] getExceptionTable() {
    return exceptionTable;
  }

  public void setExceptionTable(ExceptionTable[] exceptionTable) {
    this.exceptionTable = exceptionTable;
  }

  public int getAttributesCount() {
    return attributesCount;
  }

  public void setAttributesCount(int attributesCount) {
    this.attributesCount = attributesCount;
  }

  public Attribute[] getAttributes() {
    return attributes;
  }

  public void setAttributes(Attribute[] attributes) {
    this.attributes = attributes;
  }

}
