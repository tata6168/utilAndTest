package com.synthesize.test.mybatis.base.service;

import com.synthesize.test.mybatis.base.demo.BaseDemo;

public interface BaseService<T extends BaseDemo> {
    void baseInsert(T t);
    void baseUpdate(T t);
    void baseDelete(Long id);
}
