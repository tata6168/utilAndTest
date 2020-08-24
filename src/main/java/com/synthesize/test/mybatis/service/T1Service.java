package com.synthesize.test.mybatis.service;

import com.synthesize.test.mybatis.base.service.BaseService;
import com.synthesize.test.mybatis.demo.T1;

public interface T1Service extends BaseService<T1> {
    T1 test(T1 t);
}
