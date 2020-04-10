package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.fixed.JByte;

public class TypeAnnotation {

  private int targetType;
  private Target targetInfo;
  private TypePath targetPath;
  private int typeIndex;
  private int numElementValuePairs;
  private ElementValuePairs elementValuePairs[];

  public TypeAnnotation(DataInputStream dataInputStream) throws IOException {
    setTargetType(dataInputStream.readUnsignedByte());
    if (targetType >= JByte.TYPE_PARAMETER_TARGET && targetType <= JByte.TYPE_PARAMETER_TARGET_MAX) {
      setTargetInfo(new TypeParameterTarget(dataInputStream));
    } else if (targetType == JByte.SUPERTYPE_TARGET) {
      setTargetInfo(new SuperTypeTarget(dataInputStream));
    } else if (targetType >= JByte.TYPE_PARAMETER_BOUND_TARGET && targetType <= JByte.TYPE_PARAMETER_BOUND_TARGET_MAX) {
      setTargetInfo(new TypeParameterBoundTarget(dataInputStream));
    } else if (targetType >= JByte.EMPTY_TARGET && targetType <= JByte.EMPTY_TARGET_MAX) {
      setTargetInfo(new Target());
    } else if (targetType == JByte.FORMAL_PARAMETER_TARGET) {
      setTargetInfo(new FormalParameterTarget(dataInputStream));
    } else if (targetType == JByte.THROWS_TARGET) {
      setTargetInfo(new ThrowsTarget(dataInputStream));
    } else if (targetType >= JByte.LOCALVAR_TARGET && targetType <= JByte.LOCALVAR_TARGET_MAX) {
      setTargetInfo(new LocalVarTarget(dataInputStream));
    } else if (targetType == JByte.CATCH_TARGET) {
      setTargetInfo(new CatchTarget(dataInputStream));
    } else if (targetType >= JByte.OFFSET_TARGET && targetType <= JByte.OFFSET_TARGET_MAX) {
      setTargetInfo(new OffsetTarget(dataInputStream));
    } else if (targetType >= JByte.TYPE_ARGUMENT_TARGET && targetType <= JByte.TYPE_ARGUMENT_TARGET_MAX) {
      setTargetInfo(new TypeArgumentTarget(dataInputStream));
    }
    setTargetPath(new TypePath(dataInputStream));
    setTypeIndex(dataInputStream.readUnsignedShort());
    setNumElementValuePairs(dataInputStream.readUnsignedShort());
    setElementValuePairs(new ElementValuePairs[numElementValuePairs]);
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

  public int getNumElementValuePairs() {
    return numElementValuePairs;
  }

  public void setNumElementValuePairs(int numElementValuePairs) {
    this.numElementValuePairs = numElementValuePairs;
  }

  public ElementValuePairs[] getElementValuePairs() {
    return elementValuePairs;
  }

  public void setElementValuePairs(ElementValuePairs[] elementValuePairs) {
    this.elementValuePairs = elementValuePairs;
  }

}
