package com.labs64.utils.swid.builder;

import com.labs64.utils.swid.exception.SwidException;
import org.apache.commons.lang3.StringUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Entity;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Meta;

import java.util.List;

public class EntityBuilder extends BaseElementBuilder<Entity, EntityBuilder> {

    public EntityBuilder meta(Meta meta) {
        item.getMeta().add(meta);
        return this;
    }

    public EntityBuilder meta(List<Meta> meta) {
        if (meta != null) {
            item.getMeta().addAll(meta);
        }
        return this;
    }

    public EntityBuilder name(String name) {
        item.setName(name);
        return this;
    }

    public EntityBuilder regid(String regid) {
        item.setRegid(regid);
        return this;
    }

    public EntityBuilder role(String role) {
        item.getRole().add(role);
        return this;
    }

    public EntityBuilder role(List<String> role) {
        if (role != null) {
            item.getRole().addAll(role);
        }
        return this;
    }

    public EntityBuilder thumbprint(String thumbprint) {
        item.setThumbprint(thumbprint);
        return this;
    }

    @Override
    protected void validate() {
        if (StringUtils.isBlank(item.getName())) {
            throw new SwidException("'item.name' is not set");
        }
        if (item.getRole().isEmpty()) {
            throw new SwidException("'item.role' is not set");
        }
    }

    @Override
    protected Entity makeItem() {
        return new Entity();
    }
}
