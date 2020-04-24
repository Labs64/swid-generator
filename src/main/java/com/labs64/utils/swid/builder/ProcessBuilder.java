package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.apache.commons.lang3.StringUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Process;

import java.math.BigInteger;

public class ProcessBuilder extends BaseElementBuilder<Process, ProcessBuilder> {

    /**
     * Sets the value of the name property.
     *
     * @param name
     *     allowed object is
     *     {@link String }
     * @return reference to this object
     */
    public ProcessBuilder name(String name) {
        item.setName(name);
        return this;
    }
    /**
     * Sets the value of the pid property.
     *
     * @param pid
     *     allowed object is
     *     {@link BigInteger }
     * @return reference to this object
     */
    public ProcessBuilder pid(BigInteger pid) {
        item.setPid(pid);
        return this;
    }

    @Override
    protected void validate() {
        if (StringUtils.isBlank(item.getName())) {
            throw new SwidException("'process.name' is not set");
        }
    }

    @Override
    protected Process makeItem() {
        return new Process();
    }
}
