package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.factory.TargetFactory;

public class TypeAnnotation {

  private int targetType;
  private Target targetInfo;
  private TypePath targetPath;
  private int typeIndex;
  private ElementValuePairs[] elementValuePairs;

  public TypeAnnotation(DataInputStream dataInputStream) throws IOException {
    targetType = dataInputStream.readUnsignedByte();
    targetInfo = TargetFactory.readTarget(targetType, dataInputStream);
    targetPath = new TypePath(dataInputStream);
    typeIndex = dataInputStream.readUnsignedShort();
    final int numElementValuePairs = dataInputStream.readUnsignedShort();
    elementValuePairs = new ElementValuePairs[numElementValuePairs];
    for (int i = 0; i < numElementValuePairs; i++) {
      elementValuePairs[i] = new ElementValuePairs(dataInputStream);
    }
  }

  public int getTargetType() {
    return targetType;
  }

  public void setTargetType(int targetType) {
    this.targetType = targetType;
  }

  public Target getTargetInfo() {
    return targetInfo;
  }

  public void setTargetInfo(Target targetInfo) {
    this.targetInfo = targetInfo;
  }

  public TypePath getTargetPath() {
    return targetPath;
  }

  public void setTargetPath(TypePath targetPath) {
    this.targetPath = targetPath;
  }

  public int getTypeIndex() {
    return typeIndex;
  }

  public void setTypeIndex(int typeIndex) {
    this.typeIndex = typeIndex;
  }

  public ElementValuePairs[] getElementValuePairs() {
    return elementValuePairs == null ? new ElementValuePairs[0] : elementValuePairs;
  }

  public void setElementValuePairs(ElementValuePairs[] elementValuePairs) {
    this.elementValuePairs = elementValuePairs;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    dataOutputStream.writeByte(targetType);
    targetInfo.dump(dataOutputStream);
    targetPath.dump(dataOutputStream);
    dataOutputStream.writeShort(typeIndex);
    final int numElementValuePairs = getElementValuePairs().length;
    dataOutputStream.writeShort(numElementValuePairs);
    for (int i = 0; i < numElementValuePairs; i++) {
      elementValuePairs[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("(targetType = ").append(targetType);
    builder.append(", targetInfo = ").append(targetInfo);
    builder.append(", targetPath = ").append(targetPath);
    builder.append(", typeIndex = ").append(typeIndex);
    for (int i = 0, j = getElementValuePairs().length; i < j; i++) {
      if (i == 0) {
        builder.append(", elementValuePairs = [ ");
      }
      builder.append(elementValuePairs[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
