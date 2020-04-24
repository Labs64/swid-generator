package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.SoftwareMeta;

public class SoftwareMetaBuilder extends BaseElementBuilder<SoftwareMeta, SoftwareMetaBuilder> {

    public SoftwareMetaBuilder activationStatus(String val) {
        item.setActivationStatus(val);
        return this;
    }

    public SoftwareMetaBuilder channelType(String val) {
        item.setChannelType(val);
        return this;
    }

    public SoftwareMetaBuilder colloquialVersion(String val) {
        item.setColloquialVersion(val);
        return this;
    }

    public SoftwareMetaBuilder description(String val) {
        item.setDescription(val);
        return this;
    }

    public SoftwareMetaBuilder edition(String val) {
        item.setEdition(val);
        return this;
    }

    public SoftwareMetaBuilder entitlementDataRequired(Boolean val) {
        item.setEntitlementDataRequired(val);
        return this;
    }

    public SoftwareMetaBuilder entitlementKey(String val) {
        item.setEntitlementKey(val);
        return this;
    }

    public SoftwareMetaBuilder generator(String val) {
        item.setGenerator(val);
        return this;
    }

    public SoftwareMetaBuilder persistentId(String val) {
        item.setPersistentId(val);
        return this;
    }

    public SoftwareMetaBuilder product(String val) {
        item.setProduct(val);
        return this;
    }

    public SoftwareMetaBuilder productFamily(String val) {
        item.setProductFamily(val);
        return this;
    }

    public SoftwareMetaBuilder revision(String val) {
        item.setRevision(val);
        return this;
    }

    public SoftwareMetaBuilder summary(String val) {
        item.setSummary(val);
        return this;
    }

    public SoftwareMetaBuilder unspscCode(String val) {
        item.setUnspscCode(val);
        return this;
    }

    public SoftwareMetaBuilder unspscVersion(String val) {
        item.setUnspscVersion(val);
        return this;
    }

    @Override
    protected void validate() {
        // Do nothing
    }

    @Override
    protected SoftwareMeta makeItem() {
        return new SoftwareMeta();
    }
}
