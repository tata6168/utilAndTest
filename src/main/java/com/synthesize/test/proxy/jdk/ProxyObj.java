package com.synthesize.test.proxy.jdk;

import java.sql.Date;

public class ProxyObj implements Parent {
    @Override
    public void test1(Date date) {
        System.out.println("2");
    }

    @Override
    public void test2() {
        System.out.println("b");
    }


}
