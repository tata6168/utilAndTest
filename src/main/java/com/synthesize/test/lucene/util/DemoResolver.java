package com.synthesize.test.lucene.util;

import org.apache.lucene.document.Field;

public class DemoResolver {
    String fieldName;
    Class<? extends Field> type;
    Field.Store store;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Class<? extends Field> getType() {
        return type;
    }

    public void setType(Class<? extends Field> type) {
        this.type = type;
    }

    public Field.Store getStore() {
        return store;
    }

    public void setStore(Field.Store store) {
        this.store = store;
    }
}
