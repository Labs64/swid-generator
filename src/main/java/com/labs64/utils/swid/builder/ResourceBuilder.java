package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.apache.commons.lang3.StringUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Resource;

public class ResourceBuilder extends BaseElementBuilder<Resource, ResourceBuilder> {

    /**
     * Sets the value of the type property.
     *
     * @param type
     *     allowed object is
     *     {@link String }
     * @return reference to this object
     */
    public ResourceBuilder type(String type) {
        item.setType(type);
        return this;
    }

    @Override
    protected void validate() {
        if (StringUtils.isBlank(item.getType())) {
            throw new SwidException("'resource.type' is not set");
        }
    }

    @Override
    protected Resource makeItem() {
        return new Resource();
    }
}
