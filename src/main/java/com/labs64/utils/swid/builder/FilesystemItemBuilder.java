package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.FilesystemItem;

public abstract class FilesystemItemBuilder<T extends FilesystemItem, U extends FilesystemItemBuilder> extends BaseElementBuilder<T,U> {

    /**
     * Sets the value of the key property.
     *
     * @param key
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public U key(Boolean key) {
        item.setKey(key);
        return (U)this;
    }

    /**
     * Sets the value of the location property.
     *
     * @param location
     *     allowed object is
     *     {@link String }
     *
     */
    public U location(String location) {
        item.setLocation(location);
        return (U)this;
    }

    /**
     * Sets the value of the root property.
     *
     * @param root
     *     allowed object is
     *     {@link String }
     *
     */
    public U root(String root) {
        item.setRoot(root);
        return (U)this;
    }

    @Override
    protected void validate() {
        // Do nothing
    }
}
