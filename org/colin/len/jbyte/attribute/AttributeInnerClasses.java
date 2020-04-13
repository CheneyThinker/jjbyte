package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeInnerClasses extends Attribute {

  private Classes[] classes;

  public AttributeInnerClasses(DataInputStream dataInputStream) throws IOException {
    final int numberOfClasses = dataInputStream.readUnsignedShort();
    classes = new Classes[numberOfClasses];
    for (int i = 0; i < numberOfClasses; i++) {
      classes[i] = new Classes(dataInputStream);
    }
  }

  public Classes[] getClasses() {
    return classes == null ? new Classes[0] : classes;
  }

  public void setClasses(Classes[] classes) {
    this.classes = classes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numberOfClasses = getClasses().length;
    dataOutputStream.writeShort(numberOfClasses);
    for (int i = 0; i < numberOfClasses; i++) {
      classes[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getClasses().length; i < j; i++) {
      if (i == 0) {
        builder.append("(classes = [ ");
      }
      builder.append(classes[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
