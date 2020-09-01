package com.synthesize.test.lucene.annotation;

import org.apache.lucene.document.Field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldCondition {
    Field.Store store() default Field.Store.NO;
    Class<? extends Field> type();
}
