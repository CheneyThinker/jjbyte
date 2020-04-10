package org.colin.len.jbyte.attribute.annotation;

import java.io.DataInputStream;
import java.io.IOException;

public class ElementValue {

  public static final byte STRING            = 's';
  public static final byte ENUM_CONSTANT     = 'e';
  public static final byte CLASS             = 'c';
  public static final byte ANNOTATION        = '@';
  public static final byte ARRAY             = '[';
  public static final byte PRIMITIVE_INT     = 'I';
  public static final byte PRIMITIVE_BYTE    = 'B';
  public static final byte PRIMITIVE_CHAR    = 'C';
  public static final byte PRIMITIVE_DOUBLE  = 'D';
  public static final byte PRIMITIVE_FLOAT   = 'F';
  public static final byte PRIMITIVE_LONG    = 'J';
  public static final byte PRIMITIVE_SHORT   = 'S';
  public static final byte PRIMITIVE_BOOLEAN = 'Z';

  private byte tag;

  public static ElementValue readElementValue(DataInputStream dataInputStream) throws IOException {
    byte tag = dataInputStream.readByte();
    switch (tag) {
    case PRIMITIVE_BYTE:
    case PRIMITIVE_CHAR:
    case PRIMITIVE_DOUBLE:
    case PRIMITIVE_FLOAT:
    case PRIMITIVE_INT:
    case PRIMITIVE_LONG:
    case PRIMITIVE_SHORT:
    case PRIMITIVE_BOOLEAN:
    case STRING:
      return new SimpleElementValue(tag, dataInputStream);
    case ENUM_CONSTANT:
      return new EnumElementValue(tag, dataInputStream);
    case CLASS:
      return new ClassElementValue(tag, dataInputStream);
    case ANNOTATION:
      return new AnnotationElementValue(tag, dataInputStream);
    case ARRAY:
      return new ArrayElementValue(tag, dataInputStream);
    }
    return null;
  }

  public byte getTag() {
    return tag;
  }

  public void setTag(byte tag) {
    this.tag = tag;
  }

}
