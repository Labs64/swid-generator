package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Entity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityBuilderTest {

    @Test(expected = SwidException.class)
    public void testBuilderIncomplete() {
        EntityBuilder builder = new EntityBuilder();
        builder.lang("lang").build();
    }

    @Test(expected = SwidException.class)
    public void testBuilderStillIncomplete() {
        EntityBuilder builder = new EntityBuilder();
        Entity entity = builder.lang("lang").name("EntityName").build();
    }

    @Test
    public void testBuilder() {
        EntityBuilder builder = new EntityBuilder();
        Entity entity = builder.lang("lang").name("EntityName").role("softwareCreator").build();
        assertEquals("EntityName", entity.getName());
        assertEquals("softwareCreator", entity.getRole().get(0));
    }
}
