package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.apache.commons.lang3.StringUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Link;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Ownership;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Use;

public class LinkBuilder extends BaseElementBuilder<Link, LinkBuilder> {

    public LinkBuilder artifact(String artifact) {
        item.setArtifact(artifact);
        return this;
    }

    public LinkBuilder href(String href) {
        item.setHref(href);
        return this;
    }

    public LinkBuilder media(String media) {
        item.setMedia(media);
        return this;
    }

    public LinkBuilder ownership(Ownership ownership) {
        item.setOwnership(ownership);
        return this;
    }

    public LinkBuilder rel(String rel) {
        item.setRel(rel);
        return this;
    }

    public LinkBuilder type(String type) {
        item.setType(type);
        return this;
    }

    public LinkBuilder use(Use use) {
        item.setUse(use);
        return this;
    }

    protected void validate() {
        if (StringUtils.isBlank(item.getHref())) {
            throw new SwidException("'link.href' is not set");
        }
        if (StringUtils.isBlank(item.getRel())) {
            throw new SwidException("'link.rel' is not set");
        }
    }

    @Override
    protected Link makeItem() {
        return new Link();
    }
}
