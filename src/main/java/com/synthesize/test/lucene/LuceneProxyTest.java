package com.synthesize.test.lucene;

import com.synthesize.test.lucene.demo.Demo;
import com.synthesize.test.lucene.service.LuceneService;
import com.synthesize.test.lucene.service.impl.LuceneServiceImpl;
import com.synthesize.test.lucene.service.proxy.Factory;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LuceneProxyTest {
    static final Factory FACTORY = Factory.PRODUCTION;
    public static void main(String[] args) throws IOException, IllegalAccessException {
        LuceneService store = FACTORY.store(new LuceneServiceImpl());
        List<Demo> list = new ArrayList<Demo>();
        for (long i = 0; i < 10; i++) {
            Demo demo = new Demo();
            demo.setId(100+i);
            demo.setName("name"+i);
            list.add(demo);
        }
        store.writer(list);
    }
}
