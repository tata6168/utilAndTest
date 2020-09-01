package com.synthesize.test.lucene.service.proxy;

import com.synthesize.test.lucene.service.LuceneService;
import com.synthesize.test.lucene.service.impl.LuceneServiceImpl;

import java.io.IOException;

public enum  Factory {
    PRODUCTION;
    public LuceneService store(LuceneServiceImpl luceneService) throws IOException {
        return (LuceneService) new LuceneProxy(luceneService).proxy();
    }
}
