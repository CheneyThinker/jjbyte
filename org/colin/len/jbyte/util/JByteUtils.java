package org.colin.len.jbyte.util;

public final class JByteUtils {

  public static final void hex(byte b) {
    System.err.printf("%02x\n", b);
  }

  public static final void hex(short s) {
    System.err.printf("%04x\n", s);
  }

  public static final void hex(int i) {
    System.err.printf("%08x\n", i);
  }

  public static final String toHexString(byte[] bytes) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0, j = bytes.length; i < j; i++) {
      builder.append(String.format("%02x", bytes[i]));
      if (i < j - 1) {
        builder.append(" ");
      }
    }
    return builder.toString();
  }

  public static final String escape(String str) {
    char[] chars = str.toCharArray();
    StringBuilder builder = new StringBuilder();
    for (int i = 0, j = chars.length; i < j; i++) {
      switch (chars[i]) {
      case '\n':
        builder.append("\\n");
        break;
      case '\r':
        builder.append("\\r");
        break;
      case '\t':
        builder.append("\\t");
        break;
      case '\b':
        builder.append("\\b");
        break;
      case '\"':
        builder.append("\\\"");
        break;
      case '\'':
        builder.append("\\'");
      case '\\':
        builder.append("\\\\");
        break;
      default:
        builder.append(chars[i]);
        break;
      }
    }
    return builder.toString();
  }

}
