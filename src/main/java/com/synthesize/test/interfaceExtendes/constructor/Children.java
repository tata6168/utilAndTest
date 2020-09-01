package com.synthesize.test.interfaceExtendes.constructor;

public class Children extends Pare {

    public Children(String name) {
        super(name);
    }
    static void test (long...l){
        System.out.println(l.getClass().getTypeName());
    }

    public static void main(String[] args) {
        test();
    }
}
