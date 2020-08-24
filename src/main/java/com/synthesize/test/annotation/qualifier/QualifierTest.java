package com.synthesize.test.annotation.qualifier;

import com.synthesize.test.annotation.qualifier.demo.One;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class QualifierTest {
    @Bean("t1")
    One t1(){
        One one = new One();
        one.setOne("t1");
        return one;
    }
    @Bean("t2")
    One t2(){
        One one = new One();
        one.setOne("t2");
        return one;
    }
}
