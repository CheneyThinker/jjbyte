package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.methodparameters.Parameters;

public class MethodParameters extends Attribute {

  private int parametersCount;
  private Parameters parameters[];

  public MethodParameters(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setParametersCount(dataInputStream.readUnsignedByte());
    setParameters(new Parameters[parametersCount]);
    for (int i = 0; i < parametersCount; i++) {
      parameters[i] = new Parameters(dataInputStream);
    }
  }

  public int getParametersCount() {
    return parametersCount;
  }

  public void setParametersCount(int parametersCount) {
    this.parametersCount = parametersCount;
  }

  public Parameters[] getParameters() {
    return parameters;
  }

  public void setParameters(Parameters[] parameters) {
    this.parameters = parameters;
  }

}
