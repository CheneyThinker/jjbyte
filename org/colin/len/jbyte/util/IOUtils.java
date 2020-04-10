package org.colin.len.jbyte.util;

import java.io.Closeable;
import java.io.IOException;

public final class IOUtils {

  public static void closeQuietly(Closeable closeable) {
    try {
      if (closeable != null) {
        closeable.close();
      }
    } catch (IOException e) {
    }
  }

}
