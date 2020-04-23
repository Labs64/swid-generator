package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.BaseElement;

import javax.xml.namespace.QName;
import java.util.Map;

public abstract class BaseElementBuilder<T extends BaseElement, U extends BaseElementBuilder> {

    protected T item;

    public BaseElementBuilder() {
        this.item = makeItem();
    }

    public U lang(String lang) {
        item.setLang(lang);
        return (U)this;
    }

    public U otherAttributes(QName key, String value) {
        item.getOtherAttributes().put(key, value);
        return (U)this;
    }

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
