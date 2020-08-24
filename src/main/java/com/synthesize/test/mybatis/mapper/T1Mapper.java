package com.synthesize.test.mybatis.mapper;

import com.synthesize.test.mybatis.base.mapper.BaseMapper;
import com.synthesize.test.mybatis.demo.T1;

public interface T1Mapper extends BaseMapper<T1> {
    void insert(T1 t1);
}
