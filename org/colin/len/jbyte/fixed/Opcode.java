package org.colin.len.jbyte.fixed;

public interface Opcode {

  public static final String ILLEGAL_OPCODE = "<illegal opcode>";
  public static final String ILLEGAL_TYPE   = "<illegal type>";
  public static final int   UNDEFINED       = -1;
  public static final int   UNPREDICTABLE   = -2;
  public static final int   RESERVED        = -3;
  public static final int   MAX_BYTE        = 255;
  public static final int   MAX_SHORT       = 65535;

  //Constants
  public static final short NOP             = 0x00;
  public static final short ACONST_NULL     = 0x01;
  public static final short ICONST_M1       = 0x02;
  public static final short ICONST_0        = 0x03;
  public static final short ICONST_1        = 0x04;
  public static final short ICONST_2        = 0x05;
  public static final short ICONST_3        = 0x06;
  public static final short ICONST_4        = 0x07;
  public static final short ICONST_5        = 0x08;
  public static final short LCONST_0        = 0x09;
  public static final short LCONST_1        = 0x0a;
  public static final short FCONST_0        = 0x0b;
  public static final short FCONST_1        = 0x0c;
  public static final short FCONST_2        = 0x0d;
  public static final short DCONST_0        = 0x0e;
  public static final short DCONST_1        = 0x0f;
  public static final short BIPUSH          = 0x10;
  public static final short SIPUSH          = 0x11;
  public static final short LDC             = 0x12;
  public static final short LDC_W           = 0x13;
  public static final short LDC2_W          = 0x14;
  //Loads
  public static final short ILOAD           = 0x15;
  public static final short LLOAD           = 0x16;
  public static final short FLOAD           = 0x17;
  public static final short DLOAD           = 0x18;
  public static final short ALOAD           = 0x19;
  public static final short ILOAD_0         = 0x1a;
  public static final short ILOAD_1         = 0x1b;
  public static final short ILOAD_2         = 0x1c;
  public static final short ILOAD_3         = 0x1d;
  public static final short LLOAD_0         = 0x1e;
  public static final short LLOAD_1         = 0x1f;
  public static final short LLOAD_2         = 0x20;
  public static final short LLOAD_3         = 0x21;
  public static final short FLOAD_0         = 0x22;
  public static final short FLOAD_1         = 0x23;
  public static final short FLOAD_2         = 0x24;
  public static final short FLOAD_3         = 0x25;
  public static final short DLOAD_0         = 0x26;
  public static final short DLOAD_1         = 0x27;
  public static final short DLOAD_2         = 0x28;
  public static final short DLOAD_3         = 0x29;
  public static final short ALOAD_0         = 0x2a;
  public static final short ALOAD_1         = 0x2b;
  public static final short ALOAD_2         = 0x2c;
  public static final short ALOAD_3         = 0x2d;
  public static final short IALOAD          = 0x2e;
  public static final short LALOAD          = 0x2f;
  public static final short FALOAD          = 0x30;
  public static final short DALOAD          = 0x31;
  public static final short AALOAD          = 0x32;
  public static final short BALOAD          = 0x33;
  public static final short CALOAD          = 0x34;
  public static final short SALOAD          = 0x35;
  //Stores
  public static final short ISTORE          = 0x36;
  public static final short LSTORE          = 0x37;
  public static final short FSTORE          = 0x38;
  public static final short DSTORE          = 0x39;
  public static final short ASTORE          = 0x3a;
  public static final short ISTORE_0        = 0x3b;
  public static final short ISTORE_1        = 0x3c;
  public static final short ISTORE_2        = 0x3d;
  public static final short ISTORE_3        = 0x3e;
  public static final short LSTORE_0        = 0x3f;
  public static final short LSTORE_1        = 0x40;
  public static final short LSTORE_2        = 0x41;
  public static final short LSTORE_3        = 0x42;
  public static final short FSTORE_0        = 0x43;
  public static final short FSTORE_1        = 0x44;
  public static final short FSTORE_2        = 0x45;
  public static final short FSTORE_3        = 0x46;
  public static final short DSTORE_0        = 0x47;
  public static final short DSTORE_1        = 0x48;
  public static final short DSTORE_2        = 0x49;
  public static final short DSTORE_3        = 0x4a;
  public static final short ASTORE_0        = 0x4b;
  public static final short ASTORE_1        = 0x4c;
  public static final short ASTORE_2        = 0x4d;
  public static final short ASTORE_3        = 0x4e;
  public static final short IASTORE         = 0x4f;
  public static final short LASTORE         = 0x50;
  public static final short FASTORE         = 0x51;
  public static final short DASTORE         = 0x52;
  public static final short AASTORE         = 0x53;
  public static final short BASTORE         = 0x54;
  public static final short CASTORE         = 0x55;
  public static final short SASTORE         = 0x56;
  //Stack
  public static final short POP             = 0x57;
  public static final short POP2            = 0x58;
  public static final short DUP             = 0x59;
  public static final short DUP_X1          = 0x5a;
  public static final short DUP_X2          = 0x5b;
  public static final short DUP2            = 0x5c;
  public static final short DUP2_X1         = 0x5d;
  public static final short DUP2_X2         = 0x5e;
  public static final short SWAP            = 0x5f;
  //Math
  public static final short IADD            = 0x60;
  public static final short LADD            = 0x61;
  public static final short FADD            = 0x62;
  public static final short DADD            = 0x63;
  public static final short ISUB            = 0x64;
  public static final short LSUB            = 0x65;
  public static final short FSUB            = 0x66;
  public static final short DSUB            = 0x67;
  public static final short IMUL            = 0x68;
  public static final short LMUL            = 0x69;
  public static final short FMUL            = 0x6a;
  public static final short DMUL            = 0x6b;
  public static final short IDIV            = 0x6c;
  public static final short LDIV            = 0x6d;
  public static final short FDIV            = 0x6e;
  public static final short DDIV            = 0x6f;
  public static final short IREM            = 0x70;
  public static final short LREM            = 0x71;
  public static final short FREM            = 0x72;
  public static final short DREM            = 0x73;
  public static final short INEG            = 0x74;
  public static final short LNEG            = 0x75;
  public static final short FNEG            = 0x76;
  public static final short DNEG            = 0x77;
  public static final short ISHL            = 0x78;
  public static final short LSHL            = 0x79;
  public static final short ISHR            = 0x7a;
  public static final short LSHR            = 0x7b;
  public static final short IUSHR           = 0x7c;
  public static final short LUSHR           = 0x7d;
  public static final short IAND            = 0x7e;
  public static final short LAND            = 0x7f;
  public static final short IOR             = 0x80;
  public static final short LOR             = 0x81;
  public static final short IXOR            = 0x82;
  public static final short LXOR            = 0x83;
  public static final short IINC            = 0x84;
  //Conversions
  public static final short I2L             = 0x85;
  public static final short I2F             = 0x86;
  public static final short I2D             = 0x87;
  public static final short L2I             = 0x88;
  public static final short L2F             = 0x89;
  public static final short L2D             = 0x8a;
  public static final short F2I             = 0x8b;
  public static final short F2L             = 0x8c;
  public static final short F2D             = 0x8d;
  public static final short D2I             = 0x8e;
  public static final short D2L             = 0x8f;
  public static final short D2F             = 0x90;
  public static final short I2B             = 0x91;
  public static final short I2C             = 0x92;
  public static final short I2S             = 0x93;
  //Comparisons
  public static final short LCMP            = 0x94;
  public static final short FCMPL           = 0x95;
  public static final short FCMPG           = 0x96;
  public static final short DCMPL           = 0x97;
  public static final short DCMPG           = 0x98;
  public static final short IFEQ            = 0x99;
  public static final short IFNE            = 0x9a;
  public static final short IFLT            = 0x9b;
  public static final short IFGE            = 0x9c;
  public static final short IFGT            = 0x9d;
  public static final short IFLE            = 0x9e;
  public static final short IF_ICMPEQ       = 0x9f;
  public static final short IF_ICMPNE       = 0xa0;
  public static final short IF_ICMPLT       = 0xa1;
  public static final short IF_ICMPGE       = 0xa2;
  public static final short IF_ICMPGT       = 0xa3;
  public static final short IF_ICMPLE       = 0xa4;
  public static final short IF_ACMPEQ       = 0xa5;
  public static final short IF_ACMPNE       = 0xa6;
  //Control
  public static final short GOTO            = 0xa7;
  public static final short JSR             = 0xa8;
  public static final short RET             = 0xa9;
  public static final short TABLESWITCH     = 0xaa;
  public static final short LOOKUPSWITCH    = 0xab;
  public static final short IRETURN         = 0xac;
  public static final short LRETURN         = 0xad;
  public static final short FRETURN         = 0xae;
  public static final short DRETURN         = 0xaf;
  public static final short ARETURN         = 0xb0;
  public static final short RETURN          = 0xb1;
  //References
  public static final short GETSTATIC       = 0xb2;
  public static final short PUTSTATIC       = 0xb3;
  public static final short GETFIELD        = 0xb4;
  public static final short PUTFIELD        = 0xb5;
  public static final short INVOKEVIRTUAL   = 0xb6;
  public static final short INVOKESPECIAL   = 0xb7;
  public static final short INVOKESTATIC    = 0xb8;
  public static final short INVOKEINTERFACE = 0xb9;
  public static final short INVOKEDYNAMIC   = 0xba;
  public static final short NEW             = 0xbb;
  public static final short NEWARRAY        = 0xbc;
  public static final short ANEWARRAY       = 0xbd;
  public static final short ARRAYLENGTH     = 0xbe;
  public static final short ATHROW          = 0xbf;
  public static final short CHECKCAST       = 0xc0;
  public static final short INSTANCEOF      = 0xc1;
  public static final short MONITORENTER    = 0xc2;
  public static final short MONITOREXIT     = 0xc3;
  //Extended
  public static final short WIDE            = 0xc4;
  public static final short MULTIANEWARRAY  = 0xc5;
  public static final short IFNULL          = 0xc6;
  public static final short IFNONNULL       = 0xc7;
  public static final short GOTO_W          = 0xc8;
  public static final short JSR_W           = 0xc9;
  //Reserved
  public static final short BREAKPOINT      = 0xca;
  public static final short IMPDEP1         = 0xfe;
  public static final short IMPDEP2         = 0xff;

  public static final String[] OPCODE_NAMES = {
                                               "nop",            "aconst_null",    "iconst_m1",      "iconst_0",       "iconst_1",
                                               "iconst_2",       "iconst_3",       "iconst_4",       "iconst_5",       "lconst_0",
                                               "lconst_1",       "fconst_0",       "fconst_1",       "fconst_2",       "dconst_0",
                                               "dconst_1",       "bipush",         "sipush",         "ldc",            "ldc_w",
                                               "ldc2_w",         "iload",          "lload",          "fload",          "dload",
                                               "aload",          "iload_0",        "iload_1",        "iload_2",        "iload_3",
                                               "lload_0",        "lload_1",        "lload_2",        "lload_3",        "fload_0",
                                               "fload_1",        "fload_2",        "fload_3",        "dload_0",        "dload_1",
                                               "dload_2",        "dload_3",        "aload_0",        "aload_1",        "aload_2",
                                               "aload_3",        "iaload",         "laload",         "faload",         "daload",
                                               "aaload",         "baload",         "caload",         "saload",         "istore",
                                               "lstore",         "fstore",         "dstore",         "astore",         "istore_0",
                                               "istore_1",       "istore_2",       "istore_3",       "lstore_0",       "lstore_1",
                                               "lstore_2",       "lstore_3",       "fstore_0",       "fstore_1",       "fstore_2",
                                               "fstore_3",       "dstore_0",       "dstore_1",       "dstore_2",       "dstore_3",
                                               "astore_0",       "astore_1",       "astore_2",       "astore_3",       "iastore",
                                               "lastore",        "fastore",        "dastore",        "aastore",        "bastore",
                                               "castore",        "sastore",        "pop",            "pop2",           "dup",
                                               "dup_x1",         "dup_x2",         "dup2",           "dup2_x1",        "dup2_x2",
                                               "swap",           "iadd",           "ladd",           "fadd",           "dadd",
                                               "isub",           "lsub",           "fsub",           "dsub",           "imul",
                                               "lmul",           "fmul",           "dmul",           "idiv",           "ldiv",
                                               "fdiv",           "ddiv",           "irem",           "lrem",           "frem",
                                               "drem",           "ineg",           "lneg",           "fneg",           "dneg",
                                               "ishl",           "lshl",           "ishr",           "lshr",           "iushr",
                                               "lushr",          "iand",           "land",           "ior",            "lor",
                                               "ixor",           "lxor",           "iinc",           "i2l",            "i2f",
                                               "i2d",            "l2i",            "l2f",            "l2d",            "f2i",
                                               "f2l",            "f2d",            "d2i",            "d2l",            "d2f",
                                               "i2b",            "i2c",            "i2s",            "lcmp",           "fcmpl",
                                               "fcmpg",          "dcmpl",          "dcmpg",          "ifeq",           "ifne",
                                               "iflt",           "ifge",           "ifgt",           "ifle",           "if_icmpeq",
                                               "if_icmpne",      "if_icmplt",      "if_icmpge",      "if_icmpgt",      "if_icmple",
                                               "if_acmpeq",      "if_acmpne",      "goto",           "jsr",            "ret",
                                               "tableswitch",    "lookupswitch",   "ireturn",        "lreturn",        "freturn",
                                               "dreturn",        "areturn",        "return",         "getstatic",      "putstatic",
                                               "getfield",       "putfield",       "invokevirtual",  "invokespecial",  "invokestatic",
                                               "invokeinterface","invokedynamic",  "new",            "newarray",       "anewarray",
                                               "arraylength",    "athrow",         "checkcast",      "instanceof",     "monitorenter",
                                               "monitorexit",    "wide",           "multianewarray", "ifnull",         "ifnonnull",
                                               "goto_w",         "jsr_w",          "breakpoint",     ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,
                                               ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   ILLEGAL_OPCODE,   "impdep1",
                                               "impdep2"
                                              };

  public static final int[]    POPPED_STACK = {
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             2,             2,             2,             2,
                                               2,             2,             2,             2,             1,
                                               2,             1,             2,             1,             1,
                                               1,             1,             1,             2,             2,
                                               2,             2,             1,             1,             1,
                                               1,             2,             2,             2,             2,
                                               1,             1,             1,             1,             3,
                                               4,             3,             4,             3,             3,
                                               3,             3,             1,             2,             1,
                                               2,             3,             2,             3,             4,
                                               2,             2,             4,             2,             4,
                                               2,             4,             2,             4,             2,
                                               4,             2,             4,             2,             4,
                                               2,             4,             2,             4,             2,
                                               4,             1,             2,             1,             2,
                                               2,             3,             2,             3,             2,
                                               3,             2,             4,             2,             4,
                                               2,             4,             0,             1,             1,
                                               1,             2,             2,             2,             1,
                                               1,             1,             2,             2,             2,
                                               1,             1,             1,             4,             2,
                                               2,             4,             4,             1,             1,
                                               1,             1,             1,             1,             2,
                                               2,             2,             2,             2,             2,
                                               2,             2,             0,             0,             0,
                                               1,             1,             1,             2,             1,
                                               2,             1,             0,             0,             UNPREDICTABLE,
                                               1,             UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE,
                                               UNPREDICTABLE, UNPREDICTABLE, 0,             1,             1,
                                               1,             1,             1,             1,             1,
                                               1,             0,             UNPREDICTABLE, 1,             1,
                                               0,             0,             0,             UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNPREDICTABLE,
                                               UNPREDICTABLE
                                              };

  public static final int[]    PUSHED_STACK = {
                                               0,             1,             1,             1,             1,
                                               1,             1,             1,             1,             2,
                                               2,             1,             1,             1,             2,
                                               2,             1,             1,             1,             1,
                                               2,             1,             2,             1,             2,
                                               1,             1,             1,             1,             1,
                                               2,             2,             2,             2,             1,
                                               1,             1,             1,             2,             2,
                                               2,             2,             1,             1,             1,
                                               1,             1,             2,             1,             2,
                                               1,             1,             1,             1,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             2,
                                               3,             4,             4,             5,             6,
                                               2,             1,             2,             1,             2,
                                               1,             2,             1,             2,             1,
                                               2,             1,             2,             1,             2,
                                               1,             2,             1,             2,             1,
                                               2,             1,             2,             1,             2,
                                               1,             2,             1,             2,             1,
                                               2,             1,             2,             1,             2,
                                               1,             2,             0,             2,             1,
                                               2,             1,             1,             2,             1,
                                               2,             2,             1,             2,             1,
                                               1,             1,             1,             1,             1,
                                               1,             1,             1,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             1,             0,
                                               0,             0,             0,             0,             0,
                                               0,             0,             0,             UNPREDICTABLE, 0,
                                               UNPREDICTABLE, 0,             UNPREDICTABLE, UNPREDICTABLE, UNPREDICTABLE,
                                               UNPREDICTABLE, UNPREDICTABLE, 1,             1,             1,
                                               1,             1,             1,             1,             0,
                                               0,             0,             1,             0,             0,
                                               0,             1,             0,             UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,
                                               UNDEFINED,     UNDEFINED,     UNDEFINED,     UNDEFINED,     UNPREDICTABLE,
                                               UNPREDICTABLE
                                              };

  public static final byte T_BOOLEAN        = 4;
  public static final byte T_CHAR           = 5;
  public static final byte T_FLOAT          = 6;
  public static final byte T_DOUBLE         = 7;
  public static final byte T_BYTE           = 8;
  public static final byte T_SHORT          = 9;
  public static final byte T_INT            = 10;
  public static final byte T_LONG           = 11;
  public static final byte T_VOID           = 12;//Non-standard
  public static final byte T_ARRAY          = 13;
  public static final byte T_OBJECT         = 14;
  public static final byte T_REFERENCE      = 14;//Deprecated
  public static final byte T_UNKNOWN        = 15;
  public static final byte T_ADDRESS        = 16;

  public static final String[] TYPE_NAMES   = {
                                               ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE,
                                               "boolean",    "char",       "float",      "double",
                                               "byte",       "short",      "int",        "long",
                                               "void",       "array",      "object",     "unknown",
                                               "address"
                                              };

}
