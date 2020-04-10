package org.colin.len.jbyte.fixed;

public interface JByte {

  public static final int MAGIC                        = 0xCAFEBABE;

  public static final byte CONSTANT_Utf8               = 1;
  public static final byte CONSTANT_Integer            = 3;
  public static final byte CONSTANT_Float              = 4;
  public static final byte CONSTANT_Long               = 5;
  public static final byte CONSTANT_Double             = 6;
  public static final byte CONSTANT_Class              = 7;
  public static final byte CONSTANT_String             = 8;
  public static final byte CONSTANT_Fieldref           = 9;
  public static final byte CONSTANT_Methodref          = 10;
  public static final byte CONSTANT_InterfaceMethodref = 11;
  public static final byte CONSTANT_NameAndType        = 12;
  public static final byte CONSTANT_MethodHandle       = 15;
  public static final byte CONSTANT_MethodType         = 16;
  public static final byte CONSTANT_Dynamic            = 17;
  public static final byte CONSTANT_InvokeDynamic      = 18;
  public static final byte CONSTANT_Module             = 19;
  public static final byte CONSTANT_Package            = 20;

  public static final int ACC_PUBLIC       = 0x0001;
  public static final int ACC_PRIVATE      = 0x0002;
  public static final int ACC_PROTECTED    = 0x0004;
  public static final int ACC_STATIC       = 0x0008;
  public static final int ACC_FINAL        = 0x0010;
  public static final int ACC_OPEN         = 0x0020;
  public static final int ACC_SUPER        = 0x0020;
  public static final int ACC_SYNCHRONIZED = 0x0020;
  public static final int ACC_TRANSITIVE   = 0x0020;
  public static final int ACC_BRIDGE       = 0x0040;
  public static final int ACC_STATIC_PHASE = 0x0040;
  public static final int ACC_VOLATILE     = 0x0040;
  public static final int ACC_TRANSIENT    = 0x0080;
  public static final int ACC_VARARGS      = 0x0080;
  public static final int ACC_NATIVE       = 0x0100;
  public static final int ACC_INTERFACE    = 0x0200;
  public static final int ACC_ABSTRACT     = 0x0400;
  public static final int ACC_STRICT       = 0x0800;
  public static final int ACC_SYNTHETIC    = 0x1000;
  public static final int ACC_ANNOTATION   = 0x2000;
  public static final int ACC_ENUM         = 0x4000;
  public static final int ACC_MANDATED     = 0x8000;
  public static final int ACC_MODULE       = 0x8000;

  public static final byte ATTR_UNKNOWN                                 = -1;
  public static final byte ATTR_CONSTANT_VALUE                          = 0;
  public static final byte ATTR_CODE                                    = 1;
  public static final byte ATTR_STACK_MAP_TABLE                         = 2;
  public static final byte ATTR_EXCEPTIONS                              = 3;
  public static final byte ATTR_INNER_CLASSES                           = 4;
  public static final byte ATTR_ENCLOSING_METHOD                        = 5;
  public static final byte ATTR_SYNTHETIC                               = 6;
  public static final byte ATTR_SIGNATURE                               = 7;
  public static final byte ATTR_SOURCE_FILE                             = 8;
  public static final byte ATTR_SOURCE_DEBUG_EXTENSION                  = 9;
  public static final byte ATTR_LINE_NUMBER_TABLE                       = 10;
  public static final byte ATTR_LOCAL_VARIABLE_TABLE                    = 11;
  public static final byte ATTR_LOCAL_VARIABLE_TYPE_TABLE               = 12;
  public static final byte ATTR_DEPRECATED                              = 13;
  public static final byte ATTR_RUNTIME_VISIBLE_ANNOTATIONS             = 14;
  public static final byte ATTR_RUNTIME_INVISIBLE_ANNOTATIONS           = 15;
  public static final byte ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS   = 16;
  public static final byte ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = 17;
  public static final byte ATTR_RUNTIME_VISIBLE_TYPE_ANNOTATIONS        = 18;
  public static final byte ATTR_RUNTIME_INVISIBLE_TYPE_ANNOTATIONS      = 19;
  public static final byte ATTR_ANNOTATION_DEFAULT                      = 20;
  public static final byte ATTR_BOOTSTRAP_METHODS                       = 21;
  public static final byte ATTR_METHOD_PARAMETERS                       = 22;
  public static final byte ATTR_MODULE                                  = 23;
  public static final byte ATTR_MODULE_PACKAGES                         = 24;
  public static final byte ATTR_MODULE_MAIN_CLASS                       = 25;
  public static final byte ATTR_NEST_HOST                               = 26;
  public static final byte ATTR_NEST_MEMBERS                            = 27;

  public static final byte ATTR_PMG                                     = 9;
  public static final byte ATTR_STACK_MAP                               = 11;
  public static final byte KNOWN_ATTRIBUTES                             = 27;

  public static final String[] ATTRIBUTE_NAMES = {
      "ConstantValue", "Code", "StackMapTable", "Exceptions", "InnerClasses", "EnclosingMethod", "Synthetic", "Signature",
      "SourceFile", "SourceDebugExtension", "LineNumberTable", "LocalVariableTable", "LocalVariableTypeTable", "Deprecated",
      "RuntimeVisibleAnnotations", "RuntimeInvisibleAnnotations", "RuntimeVisibleParameterAnnotations",
      "RuntimeInvisibleParameterAnnotations", "RuntimeVisibleTypeAnnotations", "RuntimeInvisibleTypeAnnotations",
      "AnnotationDefault", "BootstrapMethods", "MethodParameters", "Module", "ModulePackages", "ModuleMainClass", "NestHost",
      "NestMembers"
    };

  public static final int SAME_FRAME = 0;
  public static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
  public static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
  public static final int CHOP_FRAME = 248;
  public static final int SAME_FRAME_EXTENDED = 251;
  public static final int APPEND_FRAME = 252;
  public static final int FULL_FRAME = 255;

  public static final int SAME_FRAME_MAX = 63;
  public static final int SAME_LOCALS_1_STACK_ITEM_FRAME_MAX = 127;
  public static final int CHOP_FRAME_MAX = 250;
  public static final int APPEND_FRAME_MAX = 254;

  public static final int TYPE_PARAMETER_TARGET = 0x00;
  public static final int SUPERTYPE_TARGET = 0x10;
  public static final int TYPE_PARAMETER_BOUND_TARGET = 0x11;
  public static final int EMPTY_TARGET = 0x13;
  public static final int FORMAL_PARAMETER_TARGET = 0x16;
  public static final int THROWS_TARGET = 0x17;
  public static final int LOCALVAR_TARGET = 0x40;
  public static final int CATCH_TARGET = 0x42;
  public static final int OFFSET_TARGET = 0x43;
  public static final int TYPE_ARGUMENT_TARGET = 0x47;

  public static final int TYPE_PARAMETER_TARGET_MAX = 0x01;
  public static final int TYPE_PARAMETER_BOUND_TARGET_MAX = 0x12;
  public static final int EMPTY_TARGET_MAX = 0x15;
  public static final int LOCALVAR_TARGET_MAX = 0x41;
  public static final int OFFSET_TARGET_MAX = 0x46;
  public static final int TYPE_ARGUMENT_TARGET_MAX = 0x4B;

  public static final int ITEM_Top = 0;
  public static final int ITEM_Integer = 1;
  public static final int ITEM_Float = 2;
  public static final int ITEM_Double = 3;
  public static final int ITEM_Long = 4;
  public static final int ITEM_Null = 5;
  public static final int ITEM_UninitializedThis = 6;
  public static final int ITEM_Object = 7;
  public static final int ITEM_Uninitialized = 8;

}
