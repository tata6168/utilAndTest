package com.synthesize.test.mybatis.aloneUse.domain;

import com.synthesize.test.lucene.annotation.FieldCondition;
import lombok.ToString;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.TextField;
import org.apache.lucene.queries.function.valuesource.LongFieldSource;

import java.util.Date;
@ToString
public class Demo {
    @FieldCondition(type = LongPoint.class)
    Integer id;
    String name;
    Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
