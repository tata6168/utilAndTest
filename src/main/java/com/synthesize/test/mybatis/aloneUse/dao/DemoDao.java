package com.synthesize.test.mybatis.aloneUse.dao;

import com.synthesize.test.mybatis.aloneUse.domain.Demo;

import java.util.List;

public interface DemoDao {
    List<Demo> select();
}
