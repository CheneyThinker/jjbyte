package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.ConstantPool;
import org.colin.len.jbyte.factory.AttributeFactory;
import org.colin.len.jbyte.util.JByteUtils;

public class AttributeCode extends Attribute {

  private int maxStack;
  private int maxLocals;
  private byte[] code;
  private ExceptionTable[] exceptionTables;
  private Attribute[] attributes;

  public AttributeCode(DataInputStream dataInputStream, ConstantPool constantPool) throws IOException {
    maxStack = dataInputStream.readUnsignedShort();
    maxLocals = dataInputStream.readUnsignedShort();
    final int codeLength = dataInputStream.readInt();
    code = new byte[codeLength];
    dataInputStream.readFully(code);
    final int exceptionTableLength = dataInputStream.readUnsignedShort();
    exceptionTables = new ExceptionTable[exceptionTableLength];
    for (int i = 0; i < exceptionTableLength; i++) {
      exceptionTables[i] = new ExceptionTable(dataInputStream);
    }
    final int attributesCount = dataInputStream.readUnsignedShort();
    attributes = new Attribute[attributesCount];
    for (int i = 0; i < attributesCount; i++) {
      attributes[i] = AttributeFactory.readAttribute(dataInputStream, constantPool);
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

  public byte[] getCode() {
    return code == null ? new byte[0] : code;
  }

  public void setCode(byte[] code) {
    this.code = code;
  }

  public ExceptionTable[] getExceptionTables() {
    return exceptionTables == null ? new ExceptionTable[0] : exceptionTables;
  }

  public void setExceptionTables(ExceptionTable[] exceptionTables) {
    this.exceptionTables = exceptionTables;
  }

  public Attribute[] getAttributes() {
    return attributes == null ? new Attribute[0] : attributes;
  }

  public void setAttributes(Attribute[] attributes) {
    this.attributes = attributes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(maxStack);
    dataOutputStream.writeShort(maxLocals);
    final int codeLength = getCode().length;
    dataOutputStream.writeInt(codeLength);
    dataOutputStream.write(getCode());
    final int exceptionTableLength = getExceptionTables().length;
    dataOutputStream.writeShort(exceptionTableLength);
    for (int i = 0; i < exceptionTableLength; i++) {
      exceptionTables[i].dump(dataOutputStream);
    }
    final int attributesCount = getAttributes().length;
    dataOutputStream.writeShort(attributesCount);
    for (int i = 0; i < attributesCount; i++) {
      attributes[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    builder.append("(maxStack = ").append(maxStack);
    builder.append(", maxLocals = ").append(maxLocals);
    builder.append(", code = [").append(JByteUtils.toHexString(getCode())).append("]");
    for (int i = 0, j = getExceptionTables().length; i < j; i++) {
      if (i == 0) {
        builder.append(", exceptionTables = [ ");
      }
      builder.append(exceptionTables[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    for (int i = 0, j = getAttributes().length; i < j; i++) {
      if (i == 0) {
        builder.append(", attributes = [ ");
      }
      builder.append(attributes[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
