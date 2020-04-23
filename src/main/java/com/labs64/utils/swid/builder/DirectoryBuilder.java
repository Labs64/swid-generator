package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.Directory;
import org.iso.standards.iso._19770.__2._2014_dis.schema.FilesystemItem;

public class DirectoryBuilder extends FilesystemItemBuilder<Directory, DirectoryBuilder> {

    public DirectoryBuilder directoryOrFile(FilesystemItem directoryOrFile) {
        item.getDirectoryOrFile().add(directoryOrFile);
        return this;
    }

    @Override
    protected Directory makeItem() {
        return new Directory();
    }
}
