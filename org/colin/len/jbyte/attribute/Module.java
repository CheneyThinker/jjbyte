package org.colin.len.jbyte.attribute;

import java.io.DataInputStream;
import java.io.IOException;

import org.colin.len.jbyte.Attribute;
import org.colin.len.jbyte.attribute.module.Exports;
import org.colin.len.jbyte.attribute.module.Opens;
import org.colin.len.jbyte.attribute.module.Provides;
import org.colin.len.jbyte.attribute.module.Requires;

public class Module extends Attribute {

  private int moduleNameIndex;
  private int moduleFlags;
  private int moduleVersionIndex;
  private int requiresCount;
  private Requires requires[];
  private int exportsCount;
  private Exports exports[];
  private int opensCount;
  private Opens opens[];
  private int usesCount;
  private int usesIndex[];
  private int providesCount;
  private Provides provides[];

  public Module(int attributeNameIndex, int attributeLength, DataInputStream dataInputStream) throws IOException {
    setAttributeNameIndex(attributeNameIndex);
    setAttributeLength(attributeLength);
    setModuleNameIndex(dataInputStream.readUnsignedShort());
    setModuleFlags(dataInputStream.readUnsignedShort());
    setModuleVersionIndex(dataInputStream.readUnsignedShort());
    setRequiresCount(dataInputStream.readUnsignedShort());
    setRequires(new Requires[requiresCount]);
    for (int i = 0; i < requiresCount; i++) {
      requires[i] = new Requires(dataInputStream);
    }
    setExportsCount(dataInputStream.readUnsignedShort());
    setExports(new Exports[exportsCount]);
    for (int i = 0; i < exportsCount; i++) {
      exports[i] = new Exports(dataInputStream);
    }
    setOpensCount(dataInputStream.readUnsignedShort());
    setOpens(new Opens[opensCount]);
    for (int i = 0; i < opensCount; i++) {
      opens[i] = new Opens(dataInputStream);
    }
    setUsesCount(dataInputStream.readUnsignedShort());
    setUsesIndex(new int[usesCount]);
    for (int i = 0; i < usesCount; i++) {
      usesIndex[i] = dataInputStream.readUnsignedShort();
    }
    setProvidesCount(dataInputStream.readUnsignedShort());
    setProvides(new Provides[providesCount]);
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

  public int getRequiresCount() {
    return requiresCount;
  }

  public void setRequiresCount(int requiresCount) {
    this.requiresCount = requiresCount;
  }

  public Requires[] getRequires() {
    return requires;
  }

  public void setRequires(Requires[] requires) {
    this.requires = requires;
  }

  public int getExportsCount() {
    return exportsCount;
  }

  public void setExportsCount(int exportsCount) {
    this.exportsCount = exportsCount;
  }

  public Exports[] getExports() {
    return exports;
  }

  public void setExports(Exports[] exports) {
    this.exports = exports;
  }

  public int getOpensCount() {
    return opensCount;
  }

  public void setOpensCount(int opensCount) {
    this.opensCount = opensCount;
  }

  public Opens[] getOpens() {
    return opens;
  }

  public void setOpens(Opens[] opens) {
    this.opens = opens;
  }

  public int getUsesCount() {
    return usesCount;
  }

  public void setUsesCount(int usesCount) {
    this.usesCount = usesCount;
  }

  public int[] getUsesIndex() {
    return usesIndex;
  }

  public void setUsesIndex(int[] usesIndex) {
    this.usesIndex = usesIndex;
  }

  public int getProvidesCount() {
    return providesCount;
  }

  public void setProvidesCount(int providesCount) {
    this.providesCount = providesCount;
  }

  public Provides[] getProvides() {
    return provides;
  }

  public void setProvides(Provides[] provides) {
    this.provides = provides;
  }

}
