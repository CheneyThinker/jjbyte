package org.colin.len.jbyte;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.constant.*;
import org.colin.len.jbyte.fixed.JByte;

public class ConstantPool {

  private Constant[] constants;

  public ConstantPool(DataInputStream dataInputStream) throws IOException {
    final int constantPoolCount = dataInputStream.readUnsignedShort();
    constants = new Constant[constantPoolCount];
    for (int i = 1; i < constantPoolCount; i++) {
      int tag = dataInputStream.readUnsignedByte();
      switch (tag) {
        case JByte.CONSTANT_Class:
          constants[i] = new ConstantClass(dataInputStream);
          break;
        case JByte.CONSTANT_Fieldref:
          constants[i] = new ConstantFieldref(dataInputStream);
          break;
        case JByte.CONSTANT_Methodref:
          constants[i] = new ConstantMethodref(dataInputStream);
          break;
        case JByte.CONSTANT_InterfaceMethodref:
          constants[i] = new ConstantInterfaceMethodref(dataInputStream);
          break;
        case JByte.CONSTANT_String:
          constants[i] = new ConstantString(dataInputStream);
          break;
        case JByte.CONSTANT_Integer:
          constants[i] = new ConstantInteger(dataInputStream);
          break;
        case JByte.CONSTANT_Float:
          constants[i] = new ConstantFloat(dataInputStream);
          break;
        case JByte.CONSTANT_Long:
          constants[i] = new ConstantLong(dataInputStream);
          break;
        case JByte.CONSTANT_Double:
          constants[i] = new ConstantDouble(dataInputStream);
          break;
        case JByte.CONSTANT_NameAndType:
          constants[i] = new ConstantNameAndType(dataInputStream);
          break;
        case JByte.CONSTANT_Utf8:
          constants[i] = new ConstantUtf8(dataInputStream);
          break;
        case JByte.CONSTANT_MethodHandle:
          constants[i] = new ConstantMethodHandle(dataInputStream);
          break;
        case JByte.CONSTANT_MethodType:
          constants[i] = new ConstantMethodType(dataInputStream);
          break;
        case JByte.CONSTANT_Dynamic:
          constants[i] = new ConstantDynamic(dataInputStream);
          break;
        case JByte.CONSTANT_InvokeDynamic:
          constants[i] = new ConstantInvokeDynamic(dataInputStream);
          break;
        case JByte.CONSTANT_Module:
          constants[i] = new ConstantModule(dataInputStream);
          break;
        case JByte.CONSTANT_Package:
          constants[i] = new ConstantPackage(dataInputStream);
          break;
      }
      constants[i].setTag(tag);
      if (tag == JByte.CONSTANT_Long || tag == JByte.CONSTANT_Double) {
        i++;
      }
    }
  }

  public Constant[] getConstants() {
    return constants == null ? new Constant[0] : constants;
  }

  public void setConstants(Constant[] constants) {
    this.constants = constants;
  }

  /**
   * nameIndex<br/>
   * descriptorIndex<br/>
   * stringIndex<br/>
   * interfaceIndex<br/>
   * @param index
   * @return
   */
  public String getUtf8(int index) {
    return ((ConstantUtf8) constants[index]).getBytes();
  }

  public ConstantClass getConstantClass(int classIndex) {
    return (ConstantClass) constants[classIndex];
  }

  public ConstantNameAndType getConstantNameAndType(int nameAndTypeIndex) {
    return (ConstantNameAndType) constants[nameAndTypeIndex];
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    final int constantPoolCount = getConstants().length;
    dataOutputStream.writeShort(constantPoolCount);
    for (int i = 1; i < constantPoolCount; i++) {
      if (constants[i] != null) {
        constants[i].dump(dataOutputStream);
      }
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    final int j = getConstants().length;
    final int length = String.valueOf(j).length();
    int tag;
    for (int i = 1; i < j; i++) {
      tag = constants[i].getTag();
      for (int k = String.valueOf(i).length(); k < length; k++) {
        builder.append(" ");
      }
      builder.append(i).append(")").append(constants[i]);
      if (i < j - 1) {
        builder.append("\n");
      }
      if (tag == JByte.CONSTANT_Long || tag == JByte.CONSTANT_Double) {
        i++;
      }
    }
    return builder.toString();
  }

}
