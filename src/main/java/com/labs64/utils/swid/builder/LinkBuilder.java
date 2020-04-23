package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.apache.commons.lang3.StringUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Link;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Ownership;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Use;

public class LinkBuilder extends BaseElementBuilder<Link, LinkBuilder> {

    /**
     * Sets the value of the artifact property.
     *
     * @param artifact
     *     allowed object is
     *     {@link String }
     *
     */
    public LinkBuilder artifact(String artifact) {
        item.setArtifact(artifact);
        return this;
    }

    /**
     * Sets the value of the href property.
     *
     * @param href
     *     allowed object is
     *     {@link String }
     *
     */
    public LinkBuilder href(String href) {
        item.setHref(href);
        return this;
    }

    /**
     * Sets the value of the media property.
     *
     * @param media
     *     allowed object is
     *     {@link String }
     *
     */
    public LinkBuilder media(String media) {
        item.setMedia(media);
        return this;
    }

    /**
     * Sets the value of the ownership property.
     *
     * @param ownership
     *     allowed object is
     *     {@link Ownership }
     *
     */
    public LinkBuilder ownership(Ownership ownership) {
        item.setOwnership(ownership);
        return this;
    }

    /**
     * Sets the value of the rel property.
     *
     * @param rel
     *     allowed object is
     *     {@link String }
     *
     */
    public LinkBuilder rel(String rel) {
        item.setRel(rel);
        return this;
    }

    /**
     * Sets the value of the type property.
     *
     * @param type
     *     allowed object is
     *     {@link String }
     *
     */
    public LinkBuilder type(String type) {
        item.setType(type);
        return this;
    }

    /**
     * Sets the value of the use property.
     *
     * @param use
     *     allowed object is
     *     {@link Use }
     *
     */
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
