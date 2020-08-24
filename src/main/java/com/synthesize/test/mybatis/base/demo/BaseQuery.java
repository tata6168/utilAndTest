package com.synthesize.test.mybatis.base.demo;

import lombok.Data;

@Data
public class BaseQuery {
    String keyWords;
    Long limit;
    Long start;
    BaseDemo baseDemo;
}
