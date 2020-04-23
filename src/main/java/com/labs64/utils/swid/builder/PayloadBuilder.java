package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.Process;
import org.iso.standards.iso._19770.__2._2014_dis.schema.*;

public class PayloadBuilder extends BaseElementBuilder<ResourceCollection, PayloadBuilder> {

    /**
     * adds a {@link Directory} object.
     *
     * @param directory
     * @return reference to this object
     */
    public PayloadBuilder directory(Directory directory) {
        item.getDirectoryOrFileOrProcess().add(directory);
        return this;
    }

    /**
     * adds a {@link File} object.
     *
     * @param file
     * @return reference to this object
     */
    public PayloadBuilder file(File file) {
        item.getDirectoryOrFileOrProcess().add(file);
        return this;
    }

    /**
     * adds a {@link Process} object.
     *
     * @param process
     * @return reference to this object
     */
    public PayloadBuilder process(Process process) {
        item.getDirectoryOrFileOrProcess().add(process);
        return this;
    }

    /**
     * adds a {@link Resource} object.
     *
     * @param resource
     * @return reference to this object
     */
    public PayloadBuilder resource(Resource resource) {
        item.getDirectoryOrFileOrProcess().add(resource);
        return this;
    }

    @Override
    protected void validate() {
        // Do nothing
    }

    @Override
    protected ResourceCollection makeItem() {
        return new ResourceCollection();
    }
}
