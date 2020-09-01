package com.synthesize.util.resolver;

public abstract class AbAnnotationTactics<T> implements AnnotationTactics<T> {
    @Override
    public abstract Object tactics(String fieldName, T t);

    @Override
    public Object invoking(Class annotationType,T t) {
        String name = annotationType.getSimpleName();
        this.tactics(name,t);
        return null;
    }

}
