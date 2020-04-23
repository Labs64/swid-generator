package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.Directory;
import org.iso.standards.iso._19770.__2._2014_dis.schema.File;
import org.iso.standards.iso._19770.__2._2014_dis.schema.FilesystemItem;

public class DirectoryBuilder extends FilesystemItemBuilder<Directory, DirectoryBuilder> {

    /**
     * <p>
     * adds a {@link Directory} or {@link File} object.
     * </p>
     *
     * @param directoryOrFile
     * @return reference to this object
     */
    public DirectoryBuilder directoryOrFile(FilesystemItem directoryOrFile) {
        item.getDirectoryOrFile().add(directoryOrFile);
        return this;
    }

    @Override
    protected Directory makeItem() {
        return new Directory();
    }
}
