package com.synthesize.test.lucene.demo;

import com.synthesize.test.lucene.annotation.FieldCondition;
import lombok.Data;
import lombok.ToString;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.StringField;

@Data
@ToString
public class Demo {
    @FieldCondition(type = LongPoint.class)
    Long id;
    @FieldCondition(type = StringField.class)
    String name;
    long[] l  = new long[10];
    public Demo(Long id, String name, long...l) {
        this.id = id;
        this.name = name;
        this.l = l;
    }

    public Demo() {
    }
}
