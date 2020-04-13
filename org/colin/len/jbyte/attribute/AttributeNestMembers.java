package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeNestMembers extends Attribute {

  private int[] classes;

  public AttributeNestMembers(DataInputStream dataInputStream) throws IOException {
    final int numberOfClasses = dataInputStream.readUnsignedShort();
    classes = new int[numberOfClasses];
    for (int i = 0; i < numberOfClasses; i++) {
      classes[i] = dataInputStream.readUnsignedShort();
    }
  }

  public int[] getClasses() {
    return classes == null ? new int[0] : classes;
  }

  public void setClasses(int[] classes) {
    this.classes = classes;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numberOfClasses = getClasses().length;
    dataOutputStream.writeShort(numberOfClasses);
    for (int i = 0; i < numberOfClasses; i++) {
      dataOutputStream.writeShort(classes[i]);
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
