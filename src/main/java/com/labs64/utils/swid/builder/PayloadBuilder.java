package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.Process;
import org.iso.standards.iso._19770.__2._2014_dis.schema.*;

public class PayloadBuilder extends BaseElementBuilder<ResourceCollection, PayloadBuilder> {

    public PayloadBuilder directory(Directory directory) {
        item.getDirectoryOrFileOrProcess().add(directory);
        return this;
    }

    public PayloadBuilder file(File file) {
        item.getDirectoryOrFileOrProcess().add(file);
        return this;
    }

    public PayloadBuilder process(Process process) {
        item.getDirectoryOrFileOrProcess().add(process);
        return this;
    }

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
