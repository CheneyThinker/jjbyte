package org.colin.len.jbyte.util;

import org.colin.len.jbyte.ConstantPool;
import org.colin.len.jbyte.constant.*;
import org.colin.len.jbyte.fixed.JByte;

public final class JByteUtils {

  public static String getUtf8(ConstantPool constantPool, int index) {
    Constant constant = constantPool.getConstant(index);
    if (constant instanceof ConstantClass) {
      return getUtf8(constantPool, ((ConstantClass) constant).getNameIndex());
    } else if (constant instanceof ConstantDouble) {
      return String.valueOf(((ConstantDouble) constant).getBytes());
    } else if (constant instanceof ConstantFloat) {
      return String.valueOf(((ConstantFloat) constant).getBytes());
    } else if (constant instanceof ConstantInteger) {
      return String.valueOf(((ConstantInteger) constant).getBytes());
    } else if (constant instanceof ConstantLong) {
      return String.valueOf(((ConstantLong) constant).getBytes());
    } else if (constant instanceof ConstantMethodType) {
      return getUtf8(constantPool, ((ConstantMethodType) constant).getDescriptorIndex());
    } else if (constant instanceof ConstantModule) {
      return getUtf8(constantPool, ((ConstantModule) constant).getNameIndex());
    } else if (constant instanceof ConstantPackage) {
      return getUtf8(constantPool, ((ConstantPackage) constant).getNameIndex());
    } else if (constant instanceof ConstantString) {
      return getUtf8(constantPool, ((ConstantString) constant).getStringIndex());
    } else if (constant instanceof ConstantUtf8) {
      return ((ConstantUtf8) constant).getBytes();
    }
    //ConstantDynamic ConstantFieldref ConstantInterfaceMethodref
    //ConstantInvokeDynamic ConstantMethodHandle ConstantMethodref
    //ConstantNameAndType
    return null;
  }

  public static String getAccess(int accessFlags) {
    StringBuilder builder = new StringBuilder();
    if ((accessFlags & JByte.ACC_PUBLIC) != 0) {
      builder.append("public ");
    }
    if ((accessFlags & JByte.ACC_PRIVATE) != 0) {
      builder.append("private ");
    }
    if ((accessFlags & JByte.ACC_PROTECTED) != 0) {
      builder.append("protected ");
    }
    if ((accessFlags & JByte.ACC_STATIC) != 0) {
      builder.append("static ");
    }
    if ((accessFlags & JByte.ACC_FINAL) != 0) {
      builder.append("final ");
    }
    if ((accessFlags & JByte.ACC_SYNCHRONIZED) != 0) {
      builder.append("synchronized ");
    }
    if ((accessFlags & JByte.ACC_VOLATILE) != 0) {
      builder.append("volatile ");
    }
    if ((accessFlags & JByte.ACC_TRANSIENT) != 0) {
      builder.append("transient ");
    }
    if ((accessFlags & JByte.ACC_NATIVE) != 0) {
      builder.append("native ");
    }
    if ((accessFlags & JByte.ACC_ABSTRACT) != 0) {
      builder.append("abstract ");
    }
    return builder.deleteCharAt(builder.length() - 1).toString();
  }

}
