package com.labs64.utils.swid.builder;

import org.junit.Test;

import java.math.BigInteger;

public class FileBuilderTest {

    @Test
    public void testBuilder() {
        FileBuilder builder = new FileBuilder();
        builder.lang("lang").size(new BigInteger("5")).build();
    }
}
