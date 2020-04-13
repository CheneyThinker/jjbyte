package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;

public class AttributeModule extends Attribute {

  private int moduleNameIndex;
  private int moduleFlags;
  private int moduleVersionIndex;
  private Requires requires[];
  private Exports exports[];
  private Opens opens[];
  private int usesIndex[];
  private Provides provides[];

  public AttributeModule(DataInputStream dataInputStream) throws IOException {
    moduleNameIndex = dataInputStream.readUnsignedShort();
    moduleFlags = dataInputStream.readUnsignedShort();
    moduleVersionIndex = dataInputStream.readUnsignedShort();
    final int requiresCount = dataInputStream.readUnsignedShort();
    requires = new Requires[requiresCount];
    for (int i = 0; i < requiresCount; i++) {
      requires[i] = new Requires(dataInputStream);
    }
    final int exportsCount = dataInputStream.readUnsignedShort();
    exports = new Exports[exportsCount];
    for (int i = 0; i < exportsCount; i++) {
      exports[i] = new Exports(dataInputStream);
    }
    final int opensCount = dataInputStream.readUnsignedShort();
    opens = new Opens[opensCount];
    for (int i = 0; i < opensCount; i++) {
      opens[i] = new Opens(dataInputStream);
    }
    final int usesCount = dataInputStream.readUnsignedShort();
    usesIndex = new int[usesCount];
    for (int i = 0; i < usesCount; i++) {
      usesIndex[i] = dataInputStream.readUnsignedShort();
    }
    final int providesCount = dataInputStream.readUnsignedShort();
    provides = new Provides[providesCount];
    for (int i = 0; i < providesCount; i++) {
      provides[i] = new Provides(dataInputStream);
    }
  }

  public int getModuleNameIndex() {
    return moduleNameIndex;
  }

  public void setModuleNameIndex(int moduleNameIndex) {
    this.moduleNameIndex = moduleNameIndex;
  }

  public int getModuleFlags() {
    return moduleFlags;
  }

  public void setModuleFlags(int moduleFlags) {
    this.moduleFlags = moduleFlags;
  }

  public int getModuleVersionIndex() {
    return moduleVersionIndex;
  }

  public void setModuleVersionIndex(int moduleVersionIndex) {
    this.moduleVersionIndex = moduleVersionIndex;
  }

  public Requires[] getRequires() {
    return requires == null ? new Requires[0] : requires;
  }

  public void setRequires(Requires[] requires) {
    this.requires = requires;
  }

  public Exports[] getExports() {
    return exports == null ? new Exports[0] : exports;
  }

  public void setExports(Exports[] exports) {
    this.exports = exports;
  }

  public Opens[] getOpens() {
    return opens == null ? new Opens[0] : opens;
  }

  public void setOpens(Opens[] opens) {
    this.opens = opens;
  }

  public int[] getUsesIndex() {
    return usesIndex == null ? new int[0] : usesIndex;
  }

  public void setUsesIndex(int[] usesIndex) {
    this.usesIndex = usesIndex;
  }

  public Provides[] getProvides() {
    return provides == null ? new Provides[0] : provides;
  }

  public void setProvides(Provides[] provides) {
    this.provides = provides;
  }

  public void dump(DataOutputStream dataOutputStream) throws IOException {
    super.dump(dataOutputStream);
    dataOutputStream.writeShort(moduleNameIndex);
    dataOutputStream.writeShort(moduleFlags);
    dataOutputStream.writeShort(moduleVersionIndex);
    final int requiresCount = getRequires().length;
    dataOutputStream.writeShort(requiresCount);
    for (int i = 0; i < requiresCount; i++) {
      requires[i].dump(dataOutputStream);
    }
    final int exportsCount = getExports().length;
    dataOutputStream.writeShort(exportsCount);
    for (int i = 0; i < exportsCount; i++) {
      exports[i].dump(dataOutputStream);
    }
    final int opensCount = getOpens().length;
    dataOutputStream.writeShort(opensCount);
    for (int i = 0; i < opensCount; i++) {
      opens[i].dump(dataOutputStream);
    }
    final int usesCount = getUsesIndex().length;
    dataOutputStream.writeShort(usesCount);
    for (int i = 0; i < usesCount; i++) {
      dataOutputStream.writeShort(usesIndex[i]);
    }
    final int providesCount = getProvides().length;
    dataOutputStream.writeShort(providesCount);
    for (int i = 0; i < providesCount; i++) {
      provides[i].dump(dataOutputStream);
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(super.toString());
    builder.append("(moduleNameIndex = ").append(moduleNameIndex);
    builder.append(", moduleFlags = ").append(moduleFlags);
    builder.append(", moduleVersionIndex = ").append(moduleVersionIndex);
    for (int i = 0, j = getRequires().length; i < j; i++) {
      if (i == 0) {
        builder.append(", requires = [ ");
      }
      builder.append(requires[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    for (int i = 0, j = getExports().length; i < j; i++) {
      if (i == 0) {
        builder.append(", exports = [ ");
      }
      builder.append(exports[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    for (int i = 0, j = getOpens().length; i < j; i++) {
      if (i == 0) {
        builder.append(", opens = [ ");
      }
      builder.append(opens[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    for (int i = 0, j = getUsesIndex().length; i < j; i++) {
      if (i == 0) {
        builder.append(", usesIndex = [ ");
      }
      builder.append(usesIndex[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    for (int i = 0, j = getProvides().length; i < j; i++) {
      if (i == 0) {
        builder.append(", provides = [ ");
      }
      builder.append(provides[i]).append(" ");
      if (i == j - 1) {
        builder.append("]");
      }
    }
    builder.append(")");
    return builder.toString();
  }

}
