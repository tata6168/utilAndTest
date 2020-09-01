package com.synthesize.util.resolver;
//注解策略
public interface AnnotationTactics<T> {
    //选择执行
    Object tactics(String fieldName,T t);
    //注解绑定的方法
    Object invoking(Class annotationType,T t);
}
