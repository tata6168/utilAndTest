package com.synthesize.test.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Date;

public class ProxyFactory implements InvocationHandler{
    Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object proxy(){
        return Proxy.newProxyInstance(  target.getClass().getClassLoader(),
                                        target.getClass().getInterfaces(),
                                        this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("1");
        Object invoke = method.invoke(target, args);
        System.out.println("3");
        return invoke;
    }
    public static void main(String[] args) {
        Object proxy = new ProxyFactory(new ProxyObj()).proxy();
        ((Parent)proxy).test1(new Date(System.currentTimeMillis()));
        ((Parent)proxy).test2();
    }


}
