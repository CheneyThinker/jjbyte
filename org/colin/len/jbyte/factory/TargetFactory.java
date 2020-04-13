package org.colin.len.jbyte.factory;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.attribute.*;

public class TargetFactory {

  public static Target readTarget(int targetType, DataInputStream dataInputStream) throws IOException {
    Target target = null;
    if (targetType >= 0x00 && targetType <= 0x01) {//type_parameter_target
      target = new TypeParameterTarget(dataInputStream);
    } else if (targetType == 0x10) {//supertype_target
      target = new SuperTypeTarget(dataInputStream);
    } else if (targetType >= 0x11 && targetType <= 0x12) {//type_parameter_bound_target
      target = new TypeParameterBoundTarget(dataInputStream);
    } else if (targetType >= 0x13 && targetType <= 0x15) {//empty_target
      target = new Target();
    } else if (targetType == 0x16) {//formal_parameter_target
      target = new FormalParameterTarget(dataInputStream);
    } else if (targetType == 0x17) {//throws_target
      target = new ThrowsTarget(dataInputStream);
    } else if (targetType >= 0x40 && targetType <= 0x41) {//localvar_target
      target = new LocalvarTarget(dataInputStream);
    } else if (targetType == 0x42) {//catch_target
      target = new CatchTarget(dataInputStream);
    } else if (targetType >= 0x43 && targetType <= 0x46) {//offset_target
      target = new OffsetTarget(dataInputStream);
    } else if (targetType >= 0x47 && targetType <= 0x4B) {//type_argument_target
      target = new TypeArgumentTarget(dataInputStream);
    }
    return target;
  }

}
