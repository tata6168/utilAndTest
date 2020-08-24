package com.synthesize.test.mybatis.base.mapper;

import com.synthesize.test.mybatis.base.demo.BaseDemo;

public interface BaseMapper<T extends BaseDemo> {
    void baseInsert(T t);
    void baseUpdate(T t);
    void baseDelete(Long id);
}
