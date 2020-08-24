package com.synthesize.test.qualifer;

public class TestVariable {
    final String variable;

    public TestVariable(String variable) {
        this.variable = variable;
    }


    public static void main(String[] args) {
        final char[] test= {'2'};
        test[0]='3';
        System.out.println(test);
    }
}
