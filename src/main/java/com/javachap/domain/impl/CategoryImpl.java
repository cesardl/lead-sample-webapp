package com.javachap.domain.impl;

import com.javachap.domain.Category;

public class CategoryImpl extends DomainImpl implements Category {

    private static final long serialVersionUID = -5669471219556818159L;

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryImpl[" +
                "description = " + description +
                " name = " + name +
                "]";
    }
}
