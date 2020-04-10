package org.colin.len.jbyte;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.attribute.AnnotationDefault;
import org.colin.len.jbyte.attribute.BootstrapMethods;
import org.colin.len.jbyte.attribute.Code;
import org.colin.len.jbyte.attribute.ConstantValue;
import org.colin.len.jbyte.attribute.Deprecated;
import org.colin.len.jbyte.attribute.EnclosingMethod;
import org.colin.len.jbyte.attribute.Exceptions;
import org.colin.len.jbyte.attribute.InnerClasses;
import org.colin.len.jbyte.attribute.LineNumberTables;
import org.colin.len.jbyte.attribute.LocalVariableTables;
import org.colin.len.jbyte.attribute.LocalVariableTypeTables;
import org.colin.len.jbyte.attribute.MethodParameters;
import org.colin.len.jbyte.attribute.Module;
import org.colin.len.jbyte.attribute.ModuleMainClass;
import org.colin.len.jbyte.attribute.ModulePackages;
import org.colin.len.jbyte.attribute.NestHost;
import org.colin.len.jbyte.attribute.NestMembers;
import org.colin.len.jbyte.attribute.RuntimeInvisibleAnnotations;
import org.colin.len.jbyte.attribute.RuntimeInvisibleParameterAnnotations;
import org.colin.len.jbyte.attribute.RuntimeInvisibleTypeAnnotations;
import org.colin.len.jbyte.attribute.RuntimeVisibleAnnotations;
import org.colin.len.jbyte.attribute.RuntimeVisibleParameterAnnotations;
import org.colin.len.jbyte.attribute.RuntimeVisibleTypeAnnotations;
import org.colin.len.jbyte.attribute.Signature;
import org.colin.len.jbyte.attribute.SourceDebugExtension;
import org.colin.len.jbyte.attribute.SourceFile;
import org.colin.len.jbyte.attribute.StackMapTable;
import org.colin.len.jbyte.attribute.Synthetic;
import org.colin.len.jbyte.fixed.JByte;
import org.colin.len.jbyte.util.JByteUtils;

public class Attribute {

  private int attributeNameIndex;
  private int attributeLength;

  public static Attribute readAttribute(DataInputStream dataInputStream, ConstantPool constantPool) throws IOException {
    int attributeNameIndex = dataInputStream.readUnsignedShort();
    int attributeLength = dataInputStream.readInt();
    String name = JByteUtils.getUtf8(constantPool, attributeNameIndex);
    byte tag = JByte.ATTR_UNKNOWN;
    for (byte i = 0; i < JByte.KNOWN_ATTRIBUTES; i++) {
      if (name.equals(JByte.ATTRIBUTE_NAMES[i])) {
        tag = i;
        break;
      }
    }
    switch (tag) {
    case JByte.ATTR_CONSTANT_VALUE:
      return new ConstantValue(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_CODE:
      return new Code(attributeNameIndex, attributeLength, dataInputStream, constantPool);
    case JByte.ATTR_STACK_MAP_TABLE:
      return new StackMapTable(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_EXCEPTIONS:
      return new Exceptions(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_INNER_CLASSES:
      return new InnerClasses(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_ENCLOSING_METHOD:
      return new EnclosingMethod(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_SYNTHETIC:
      return new Synthetic(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_SIGNATURE:
      return new Signature(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_SOURCE_FILE:
      return new SourceFile(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_SOURCE_DEBUG_EXTENSION:
      return new SourceDebugExtension(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_LINE_NUMBER_TABLE:
      return new LineNumberTables(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_LOCAL_VARIABLE_TABLE:
      return new LocalVariableTables(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_LOCAL_VARIABLE_TYPE_TABLE:
      return new LocalVariableTypeTables(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_DEPRECATED:
      return new Deprecated(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_RUNTIME_VISIBLE_ANNOTATIONS:
      return new RuntimeVisibleAnnotations(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_RUNTIME_INVISIBLE_ANNOTATIONS:
      return new RuntimeInvisibleAnnotations(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS:
      return new RuntimeVisibleParameterAnnotations(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS:
      return new RuntimeInvisibleParameterAnnotations(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_RUNTIME_VISIBLE_TYPE_ANNOTATIONS:
      return new RuntimeVisibleTypeAnnotations(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_RUNTIME_INVISIBLE_TYPE_ANNOTATIONS:
      return new RuntimeInvisibleTypeAnnotations(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_ANNOTATION_DEFAULT:
      return new AnnotationDefault(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_BOOTSTRAP_METHODS:
      return new BootstrapMethods(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_METHOD_PARAMETERS:
      return new MethodParameters(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_MODULE:
      return new Module(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_MODULE_PACKAGES:
      return new ModulePackages(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_MODULE_MAIN_CLASS:
      return new ModuleMainClass(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_NEST_HOST:
      return new NestHost(attributeNameIndex, attributeLength, dataInputStream);
    case JByte.ATTR_NEST_MEMBERS:
      return new NestMembers(attributeNameIndex, attributeLength, dataInputStream);
    }
    return null;
  }

  public int getAttributeNameIndex() {
    return attributeNameIndex;
  }

  public void setAttributeNameIndex(int attributeNameIndex) {
    this.attributeNameIndex = attributeNameIndex;
  }

  public int getAttributeLength() {
    return attributeLength;
  }

  public void setAttributeLength(int attributeLength) {
    this.attributeLength = attributeLength;
  }

}
