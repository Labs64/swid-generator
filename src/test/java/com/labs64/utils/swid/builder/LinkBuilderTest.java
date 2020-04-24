package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Link;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkBuilderTest {

    @Test(expected = SwidException.class)
    public void testBuilderIncomplete() {
        LinkBuilder builder = new LinkBuilder();
        builder.lang("lang").build();
    }

    @Test(expected = SwidException.class)
    public void testBuilderStillIncomplete() {
        LinkBuilder builder = new LinkBuilder();
        Link link = builder.lang("lang").rel("supplemental").build();
    }

    @Test
    public void testBuilder() {
        LinkBuilder builder = new LinkBuilder();
        Link link = builder.lang("lang").rel("supplemental").href("href").build();
        assertEquals("supplemental", link.getRel());
        assertEquals("href", link.getHref());
    }
}
