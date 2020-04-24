package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.iso.standards.iso._19770.__2._2014_dis.schema.File;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FileBuilderTest {

    @Test(expected = SwidException.class)
    public void testBuilderIncomplete() {
        FileBuilder builder = new FileBuilder();
        builder.lang("lang").size(new BigInteger("5")).build();
    }

    @Test
    public void testBuilder() {
        FileBuilder builder = new FileBuilder();
        File file = builder.lang("lang").name("FileName").size(new BigInteger("5")).build();
        assertEquals("FileName", file.getName());
    }
}
