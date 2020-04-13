package org.colin.len.jbyte.factory;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.attribute.*;
import org.colin.len.jbyte.exception.JByteException;

public class ElementValueFactory {

  public static ElementValue readElementValue(DataInputStream dataInputStream) throws IOException {
    final int tag = dataInputStream.readUnsignedByte();
    ElementValue elementValue = null;
    switch (tag) {
      case 'B':
      case 'C':
      case 'D':
      case 'F':
      case 'I':
      case 'J':
      case 'S':
      case 'Z':
      case 's':
        elementValue = new ConstValueIndex(dataInputStream);
        break;
      case 'e':
        elementValue = new EnumConstValue(dataInputStream);
        break;
      case 'c':
        elementValue = new ClassInfoIndex(dataInputStream);
        break;
      case '@':
        elementValue = new AnnotationValue(dataInputStream);
        break;
      case '[':
        elementValue = new ArrayValue(dataInputStream);
        break;
      default:
        throw new JByteException();
    }
    elementValue.setTag(tag);
    return elementValue;
  }

}
