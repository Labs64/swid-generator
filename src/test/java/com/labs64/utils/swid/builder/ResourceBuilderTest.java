package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Resource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourceBuilderTest {

    @Test(expected = SwidException.class)
    public void testBuilderIncomplete() {
        ResourceBuilder builder = new ResourceBuilder();
        builder.lang("lang").build();
    }

    @Test
    public void testBuilder() {
        ResourceBuilder builder = new ResourceBuilder();
        Resource resource = builder.type("type").lang("lang").build();
        assertEquals("type", resource.getType());
    }
}
