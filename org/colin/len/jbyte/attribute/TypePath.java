package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypePath {

  private Path[] paths;

  public TypePath(DataInputStream dataInputStream) throws IOException {
    final int pathLength = dataInputStream.readUnsignedByte();
    paths = new Path[pathLength];
    for (int i = 0; i < pathLength; i++) {
      paths[i] = new Path(dataInputStream);
    }
  }

  public Path[] getPaths() {
    return paths == null ? new Path[0] : paths;
  }

  public void setPaths(Path[] paths) {
    this.paths = paths;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    final int pathLength = getPaths().length;
    dataOutputStream.writeByte(pathLength);
    for (int i = 0; i < pathLength; i++) {
      paths[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0, j = getPaths().length; i < j; i++) {
      if (i == 0) {
        builder.append("(paths = [ ");
      }
      builder.append(paths[i]).append(" ");
      if (i == j - 1) {
        builder.append("])");
      }
    }
    return builder.toString();
  }

}
