package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeStackMapTable extends Attribute {

  private StackMapFrame[] entries;

  public AttributeStackMapTable(DataInputStream dataInputStream) throws IOException {
    final int numberOfEntries = dataInputStream.readUnsignedShort();
    entries = new StackMapFrame[numberOfEntries];
    for (int i = 0; i < numberOfEntries; i++) {
      entries[i] = new StackMapFrame(dataInputStream);
    }
  }

  public StackMapFrame[] getEntries() {
    return entries == null ? new StackMapFrame[0] : entries;
  }

  public void setEntries(StackMapFrame[] entries) {
    this.entries = entries;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    final int numberOfEntries = getEntries().length;
    dataOutputStream.writeShort(numberOfEntries);
    for (int i = 0; i < numberOfEntries; i++) {
      entries[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    for (int i = 0, j = getEntries().length; i < j; i++) {
      if (i == 0) {
        builder.append("(entries = [ ");
      }
      builder.append(entries[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
