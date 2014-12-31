package com.labs64.utils.swid.processor;

/**
 * This generator always returns <code>null</code> as element identifier.
 */
public class NullIdGenerator implements IdGenerator {

    @Override
    public String nextId() {
        return null;
    }

}
