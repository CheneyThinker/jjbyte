package org.colin.len.jbyte;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.constant.Constant;
import org.colin.len.jbyte.constant.ConstantClass;
import org.colin.len.jbyte.constant.ConstantDouble;
import org.colin.len.jbyte.constant.ConstantDynamic;
import org.colin.len.jbyte.constant.ConstantFieldref;
import org.colin.len.jbyte.constant.ConstantFloat;
import org.colin.len.jbyte.constant.ConstantInteger;
import org.colin.len.jbyte.constant.ConstantInterfaceMethodref;
import org.colin.len.jbyte.constant.ConstantInvokeDynamic;
import org.colin.len.jbyte.constant.ConstantLong;
import org.colin.len.jbyte.constant.ConstantMethodHandle;
import org.colin.len.jbyte.constant.ConstantMethodType;
import org.colin.len.jbyte.constant.ConstantMethodref;
import org.colin.len.jbyte.constant.ConstantModule;
import org.colin.len.jbyte.constant.ConstantNameAndType;
import org.colin.len.jbyte.constant.ConstantPackage;
import org.colin.len.jbyte.constant.ConstantString;
import org.colin.len.jbyte.constant.ConstantUtf8;
import org.colin.len.jbyte.fixed.JByte;

public class ConstantPool {

  private Constant[] constants;

  public ConstantPool(DataInputStream dataInputStream) throws IOException {
    int constantPoolCount = dataInputStream.readUnsignedShort();
    constants = new Constant[constantPoolCount];
    byte tag;
    for (int i = 1; i < constantPoolCount; i++) {
      tag = (byte) dataInputStream.readUnsignedByte();
      switch (tag) {
      case JByte.CONSTANT_Class:
        constants[i] = new ConstantClass(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Fieldref:
        constants[i] = new ConstantFieldref(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Methodref:
        constants[i] = new ConstantMethodref(tag, dataInputStream);
        break;
      case JByte.CONSTANT_InterfaceMethodref:
        constants[i] = new ConstantInterfaceMethodref(tag, dataInputStream);
        break;
      case JByte.CONSTANT_String:
        constants[i] = new ConstantString(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Integer:
        constants[i] = new ConstantInteger(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Float:
        constants[i] = new ConstantFloat(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Long:
        constants[i] = new ConstantLong(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Double:
        constants[i] = new ConstantDouble(tag, dataInputStream);
        break;
      case JByte.CONSTANT_NameAndType:
        constants[i] = new ConstantNameAndType(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Utf8:
        constants[i] = new ConstantUtf8(tag, dataInputStream);
        break;
      case JByte.CONSTANT_MethodHandle:
        constants[i] = new ConstantMethodHandle(tag, dataInputStream);
        break;
      case JByte.CONSTANT_MethodType:
        constants[i] = new ConstantMethodType(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Dynamic:
        constants[i] = new ConstantDynamic(tag, dataInputStream);
        break;
      case JByte.CONSTANT_InvokeDynamic:
        constants[i] = new ConstantInvokeDynamic(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Module:
        constants[i] = new ConstantModule(tag, dataInputStream);
        break;
      case JByte.CONSTANT_Package:
        constants[i] = new ConstantPackage(tag, dataInputStream);
        break;
      }
      if (tag == JByte.CONSTANT_Double || tag == JByte.CONSTANT_Long) {
        i++;
      }
    }
  }

  public Constant[] getConstants() {
    return constants;
  }

  public Constant getConstant(int index) {
    return constants[index];
  }

  public String escape(String str) {
    char[] chars = str.toCharArray();
    StringBuilder builder = new StringBuilder();
    for (int i = 0, j = chars.length; i < j; i++) {
      switch (chars[i]) {
      case '\n':
        builder.append("\\n");
        break;
      case '\r':
        builder.append("\\r");
        break;
      case '\t':
        builder.append("\\t");
        break;
      case '\b':
        builder.append("\\b");
        break;
      case '\"':
        builder.append("\\\"");
        break;
      case '\'':
        builder.append("\\'");
      case '\\':
        builder.append("\\\\");
        break;
      default:
        builder.append(chars[i]);
        break;
      }
    }
    return builder.toString();
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    int space = String.valueOf(constants.length).length();
    for (int i = 1, j = constants.length; i < j; i++) {
      for (int k = String.valueOf(i).length(); k < space; k++) {
        builder.append(" ");
      }
      builder.append(i).append(")").append(constants[i]).append("\n");
    }
    return builder.toString();
  }

}
