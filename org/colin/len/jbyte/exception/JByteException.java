package org.colin.len.jbyte.exception;

public class JByteException extends RuntimeException {

  private static final long serialVersionUID = -2854855342831435846L;

  public JByteException() {
    super();
  }

  public JByteException(String message) {
    super(message);
  }

  public JByteException(Throwable cause) {
    super(cause);
  }

  public JByteException(String message, Throwable cause) {
    super(message, cause);
  }

}
