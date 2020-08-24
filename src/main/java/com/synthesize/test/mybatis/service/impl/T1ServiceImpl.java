package com.synthesize.test.mybatis.service.impl;

import com.synthesize.test.mybatis.base.service.impl.BaseServiceImpl;
import com.synthesize.test.mybatis.demo.T1;
import com.synthesize.test.mybatis.mapper.T1Mapper;
import com.synthesize.test.mybatis.service.T1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class T1ServiceImpl extends BaseServiceImpl<T1> implements T1Service {
    @Autowired
    T1Mapper t1Mapper;
    @Override
    public T1 test(T1 t) {
        return null;
    }
}
