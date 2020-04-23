package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.File;

import java.math.BigInteger;

public class FileBuilder extends FilesystemItemBuilder<File, FileBuilder> {

    public FileBuilder name(String name) {
        this.item.setName(name);
        return this;
    }

    public FileBuilder size(BigInteger size) {
        this.item.setSize(size);
        return this;
    }

    public FileBuilder version(String version) {
        this.item.setVersion(version);
        return this;
    }

    @Override
    protected File makeItem() {
        return new File();
    }
}
