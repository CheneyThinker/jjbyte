package org.colin.len.jbyte.fixed;

public interface JByte {

  public static final int MAGIC                        = 0xcafebabe;
  public static final String ILLEGAL_CONSTANT          = "<illegal constant>";
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

  public static final String[] CONSTANT_NAMES = {
      ILLEGAL_CONSTANT, "Utf8", ILLEGAL_CONSTANT, "Integer", "Float", "Long", "Double", "Class", "String",
      "Fieldref", "Methodref", "InterfaceMethodref", "NameAndType", ILLEGAL_CONSTANT, ILLEGAL_CONSTANT,
      "MethodHandle", "MethodType", "Dynamic", "InvokeDynamic", "Module", "Package" };

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

}
