package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class TypePath {

  private int pathLength;
  private Path path[];

  public TypePath(DataInputStream dataInputStream) throws IOException {
    setPathLength(dataInputStream.readUnsignedByte());
    setPath(new Path[pathLength]);
    for (int i = 0; i < pathLength; i++) {
      path[i] = new Path(dataInputStream);
    }
  }

  public int getPathLength() {
    return pathLength;
  }

  public void setPathLength(int pathLength) {
    this.pathLength = pathLength;
  }

  public Path[] getPath() {
    return path;
  }

  public void setPath(Path[] path) {
    this.path = path;
  }

}
