package com.synthesize.test.staticVariable;

public class psvm {
    public static void main(String[] args) {
        new C1().subtract();
        new C2().subtract();
        System.out.println(Parent.num);
    }
}
