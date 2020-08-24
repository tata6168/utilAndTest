package com.synthesize.test.mybatis.demo;

import com.synthesize.test.mybatis.base.demo.BaseDemo;
import lombok.ToString;

import java.util.Date;
@ToString
public class T1 extends BaseDemo {
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
