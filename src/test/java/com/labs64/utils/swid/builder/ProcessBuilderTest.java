package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Process;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProcessBuilderTest {

    @Test(expected = SwidException.class)
    public void testBuilderIncomplete() {
        ProcessBuilder builder = new ProcessBuilder();
        builder.lang("lang").build();
    }

    @Test
    public void testBuilder() {
        ProcessBuilder builder = new ProcessBuilder();
        Process process = builder.name("FileName").lang("lang").build();
        assertEquals("FileName", process.getName());
    }
}
