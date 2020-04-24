package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.BaseElement;

import javax.xml.namespace.QName;
import java.util.Map;

public abstract class BaseElementBuilder<T extends BaseElement, U extends BaseElementBuilder> {

    protected T item;

    public BaseElementBuilder() {
        this.item = makeItem();
    }

    /**
     * Sets the value of the lang property.
     *
     * @param lang
     *     allowed object is
     *     {@link String }
     *
     */
    public U lang(String lang) {
        item.setLang(lang);
        return (U)this;
    }

    /**
     * Attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     * </p>
     *
     * @param key the name of the attribute {@link QName}
     * @param value the String value of the attribute
     * @return a reference to this object.
     */
    public U otherAttributes(QName key, String value) {
        item.getOtherAttributes().put(key, value);
        return (U)this;
    }

    /**
     * Attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     * </p>
     *
     * @param otherAttributes a map containing key/value pairs of attributes to be added to the tag.
     * @return a reference to this object.
     */
    public U otherAttributes(Map<QName, String> otherAttributes) {
        if (otherAttributes != null) {
            item.getOtherAttributes().putAll(otherAttributes);
        }
        return (U)this;
    }

    public T build() {
        validate();
        return item;
    }

    protected abstract void validate();
    protected abstract T makeItem();
}
