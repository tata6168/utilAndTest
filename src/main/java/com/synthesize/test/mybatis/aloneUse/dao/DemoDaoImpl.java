package com.synthesize.test.mybatis.aloneUse.dao;

import com.synthesize.test.mybatis.aloneUse.SessionFactory;
import com.synthesize.test.mybatis.aloneUse.domain.Demo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoDaoImpl implements DemoDao {
    @Override
    public List<Demo> select() {
        try {
            List<Demo> demoList = new ArrayList<>();
            SqlSession session = SessionFactory.INSTANCE.getSession();
            List<Object> objects = session.selectList("com.synthesize.test.mybatis.aloneUse.dao.DemoDao.select");

            objects.forEach(e->{
                System.out.println(e);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
