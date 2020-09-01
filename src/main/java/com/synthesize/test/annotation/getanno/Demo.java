package com.synthesize.test.annotation.getanno;

import com.synthesize.test.lucene.annotation.FieldCondition;
import org.apache.lucene.document.Field;

public class Demo {
//    @FieldCondition(type = Field.class)

    String name;

    public static void main(String[] args) {
        for (java.lang.reflect.Field f : Demo.class.getDeclaredFields()) {
            FieldCondition fd = f.getDeclaredAnnotation(FieldCondition.class);
            System.out.println(fd);
        }
    }
}
