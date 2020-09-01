package com.synthesize.test.lucene.util;


import com.synthesize.test.lucene.demo.Demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//存储每个demo与lucene有关联的字段名
public class LuceneDemoFieldMap {
    //写入字段解析Map
    public final static Map<Class,List<DemoResolver>> DEMWRITERFIELD = new HashMap<>();
    //查询返回解析字段解析Map
    public final static Map<Class,List<DemoResolver>> DEMOSEARCHFIELD = new HashMap<>();
}
