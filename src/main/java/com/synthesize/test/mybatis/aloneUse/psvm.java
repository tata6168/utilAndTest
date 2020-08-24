package com.synthesize.test.mybatis.aloneUse;

import com.synthesize.test.mybatis.aloneUse.dao.DemoDaoImpl;
import com.synthesize.test.mybatis.aloneUse.domain.Demo;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

import java.io.IOException;
import java.lang.reflect.Field;

public class psvm {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        System.out.println(SessionFactory.factory.getConfiguration().getMappedStatement("com.synthesize.test.mybatis.aloneUse.dao.DemoDao.select"));
        MappedStatement mappedStatement = SessionFactory.factory.getConfiguration().getMappedStatement("com.synthesize.test.mybatis.aloneUse.dao.DemoDao.select");
        BoundSql boundSql1 = mappedStatement.getBoundSql(Demo.class);
        Field sql =boundSql1.getClass().getDeclaredField("sql");
        sql.setAccessible(true);
        sql.set(boundSql1,"aaaaaaaaaaa");
        BoundSql boundSql = ((DefaultSqlSession) SessionFactory.factory.openSession()).
                getConfiguration().
                getMappedStatement("com.synthesize.test.mybatis.aloneUse.dao.DemoDao.select").
                getSqlSource().
                getBoundSql(Demo.class);
        System.out.println(boundSql.getSql());


    }
}
