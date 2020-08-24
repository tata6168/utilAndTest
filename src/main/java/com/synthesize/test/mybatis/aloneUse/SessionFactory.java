package com.synthesize.test.mybatis.aloneUse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public enum SessionFactory {
    INSTANCE;
    //SqlSessionFactory有且只有一个
    public static SqlSessionFactory factory = null;

    //初始化SqlSessionFactory
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsReader("mybatis/aloneUse/MyBatis-Config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取session
    public SqlSession getSession() throws IOException {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis/aloneUse/MyBatis-Config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);

        return build.openSession();
    }
    //关闭session
    public void closeSession(SqlSession sqlSession){
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
