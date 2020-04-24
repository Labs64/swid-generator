package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.apache.commons.lang3.StringUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.File;

import java.math.BigInteger;

public class FileBuilder extends FilesystemItemBuilder<File, FileBuilder> {

    /**
     * Sets the value of the name property.
     *
     * @param name
     *     allowed object is
     *     {@link String }
     *
     */
    public FileBuilder name(String name) {
        this.item.setName(name);
        return this;
    }

    /**
     * Sets the value of the size property.
     *
     * @param size
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public FileBuilder size(BigInteger size) {
        this.item.setSize(size);
        return this;
    }

    /**
     * Sets the value of the version property.
     *
     * @param version
     *     allowed object is
     *     {@link String }
     *
     */
    public FileBuilder version(String version) {
        this.item.setVersion(version);
        return this;
    }

    @Override
    protected void validate() {
        if (StringUtils.isBlank(item.getName())) {
            throw new SwidException("'file.name' is not set");
        }
    }

    @Override
    protected File makeItem() {
        return new File();
    }
}
