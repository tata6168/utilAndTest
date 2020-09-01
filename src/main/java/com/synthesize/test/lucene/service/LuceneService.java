package com.synthesize.test.lucene.service;


import com.synthesize.test.lucene.demo.Demo;
import com.synthesize.test.lucene.demo.DemoOne;

import java.io.IOException;
import java.util.List;

public interface LuceneService {
    void writer(List<? extends Demo> demos) throws IOException, IllegalAccessException;
    List<Demo> termQuery(String field,String keyWord,int total);

    void writer(DemoOne demo);
}
