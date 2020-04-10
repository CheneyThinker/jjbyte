package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.annotation.ParameterAnnotations;

public class RuntimeInvisibleParameterAnnotations extends Attribute {

  private int numParameters;
  private ParameterAnnotations parameterAnnotations[];

  public RuntimeInvisibleParameterAnnotations(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setNumParameters(dataInputStream.readUnsignedByte());
    setParameterAnnotations(new ParameterAnnotations[numParameters]);
    for (int i = 0; i < numParameters; i++) {
      parameterAnnotations[i] = new ParameterAnnotations(dataInputStream);
    }
  }

  public int getNumParameters() {
    return numParameters;
  }

  public void setNumParameters(int numParameters) {
    this.numParameters = numParameters;
  }

  public ParameterAnnotations[] getParameterAnnotations() {
    return parameterAnnotations;
  }

  public void setParameterAnnotations(ParameterAnnotations[] parameterAnnotations) {
    this.parameterAnnotations = parameterAnnotations;
  }

}
