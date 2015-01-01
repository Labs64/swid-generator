package com.labs64.utils.swid.support;

import org.apache.commons.lang3.StringUtils;

/**
 * This generator always returns next sequence number as element identifier.
 */
public class SequentialIdGenerator implements IdGenerator {

    private long initialValue = 0;
    private long offset = 1;
    private String prefix;
    private String suffix;

    /**
     * <p>
     * Default ID generator constructor.
     * </p>
     * <p>
     * This constructor uses following default values:
     * </p>
     * <code>initialValue</code> = 0<br/>
     * <code>offset</code> = 1<br/>
     * <code>prefix</code> = null<br/>
     * <code>suffix</code> = null
     */
    public SequentialIdGenerator() {
    }

    /**
     * 
     * @param initialValue
     *            initial value
     * @param offset
     *            offset
     * @param prefix
     *            identifier prefix
     * @param suffix
     *            identifier suffix
     */
    public SequentialIdGenerator(final long initialValue, final long offset, final String prefix, final String suffix) {
        this.initialValue = initialValue;
        this.offset = offset;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public String nextId() {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(prefix)) {
            sb.append(prefix);
            sb.append("_");
        }
        initialValue = initialValue + offset;
        sb.append(initialValue);
        if (StringUtils.isNotBlank(suffix)) {
            sb.append("_");
            sb.append(suffix);
        }
        return sb.toString();
    }

}
