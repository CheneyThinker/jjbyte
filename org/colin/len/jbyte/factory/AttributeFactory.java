package org.colin.len.jbyte.factory;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.ConstantPool;
import org.colin.len.jbyte.attribute.*;
import org.colin.len.jbyte.exception.JByteException;

public final class AttributeFactory {

  public static Attribute readAttribute(DataInputStream dataInputStream, ConstantPool constantPool) throws IOException {
    final int attributeNameIndex = dataInputStream.readUnsignedShort();
    final int attributeLength = dataInputStream.readInt();
    String attributeName = constantPool.getUtf8(attributeNameIndex);
    Attribute attribute = null;
    switch (attributeName) {
      case "ConstantValue":
        attribute = new AttributeConstantValue(dataInputStream);
        break;
      case "Code":
        attribute = new AttributeCode(dataInputStream, constantPool);
        break;
      case "StackMapTable":
        attribute = new AttributeStackMapTable(dataInputStream);
        break;
      case "Exceptions":
        attribute = new AttributeExceptions(dataInputStream);
        break;
      case "InnerClasses":
        attribute = new AttributeInnerClasses(dataInputStream);
        break;
      case "EnclosingMethod":
        attribute = new AttributeEnclosingMethod(dataInputStream);
        break;
      case "Synthetic":
        attribute = new AttributeSynthetic();
        break;
      case "Signature":
        attribute = new AttributeSignature(dataInputStream);
        break;
      case "SourceFile":
        attribute = new AttributeSourceFile(dataInputStream);
        break;
      case "SourceDebugExtension":
        attribute = new AttributeSourceDebugExtension(dataInputStream, attributeLength);
        break;
      case "LineNumberTable":
        attribute = new AttributeLineNumberTable(dataInputStream);
        break;
      case "LocalVariableTable":
        attribute = new AttributeLocalVariableTable(dataInputStream);
        break;
      case "LocalVariableTypeTable":
        attribute = new AttributeLocalVariableTypeTable(dataInputStream);
        break;
      case "Deprecated":
        attribute = new AttributeDeprecated();
        break;
      case "RuntimeVisibleAnnotations":
        attribute = new AttributeRuntimeAnnotations(dataInputStream, true);
        break;
      case "RuntimeInvisibleAnnotations":
        attribute = new AttributeRuntimeAnnotations(dataInputStream, false);
        break;
      case "RuntimeVisibleParameterAnnotations":
        attribute = new AttributeRuntimeParameterAnnotations(dataInputStream, true);
        break;
      case "RuntimeInvisibleParameterAnnotations":
        attribute = new AttributeRuntimeParameterAnnotations(dataInputStream, false);
        break;
      case "RuntimeVisibleTypeAnnotations":
        attribute = new AttributeRuntimeTypeAnnotations(dataInputStream, true);
        break;
      case "RuntimeInvisibleTypeAnnotations":
        attribute = new AttributeRuntimeTypeAnnotations(dataInputStream, false);
        break;
      case "AnnotationDefault":
        attribute = new AttributeAnnotationDefault(dataInputStream);
        break;
      case "BootstrapMethods":
        attribute = new AttributeBootstrapMethods(dataInputStream);
        break;
      case "MethodParameters":
        attribute = new AttributeMethodParameters(dataInputStream);
        break;
      case "Module":
        attribute = new AttributeModule(dataInputStream);
        break;
      case "ModulePackages":
        attribute = new AttributeModulePackages(dataInputStream);
        break;
      case "ModuleMainClass":
        attribute = new AttributeModuleMainClass(dataInputStream);
        break;
      case "NestHost":
        attribute = new AttributeNestHost(dataInputStream);
        break;
      case "NestMembers":
        attribute = new AttributeNestMembers(dataInputStream);
        break;
      default:
        throw new JByteException();
    }
    attribute.setAttributeNameIndex(attributeNameIndex);
    attribute.setAttributeLength(attributeLength);
    attribute.setConstantPool(constantPool);
    return attribute;
  }

}
