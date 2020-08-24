package com.synthesize.test.mybatis.base.service.impl;

import com.synthesize.test.mybatis.base.demo.BaseDemo;
import com.synthesize.test.mybatis.base.mapper.BaseMapper;
import com.synthesize.test.mybatis.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T extends BaseDemo> implements BaseService<T> {
    BaseMapper<T> baseMapper;

    @Override
    public void baseInsert(T t) {
        baseMapper.baseInsert(t);
    }

    @Override
    public void baseUpdate(T t) {
        baseMapper.baseUpdate(t);
    }

    @Override
    public void baseDelete(Long id) {
        baseMapper.baseDelete(id);
    }


}
