package com.synthesize.test.lucene.util;


import com.synthesize.test.lucene.annotation.FieldCondition;
import com.synthesize.util.classfile.GetPackageClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LuceneDemoFieldResolve {

    public void resolve(String demoPackage){
        // Map  key添加标志
        boolean sign = true;
        List<Class> demoClasses = GetPackageClass.INSTANCE.getClasses(demoPackage, false);
        Iterator<Class> iterator = demoClasses.iterator();
        while (iterator.hasNext()){
            Class e = iterator.next();
            for (Field f : e.getDeclaredFields()) {
                f.setAccessible(true);
                FieldCondition fieldCondition = f.getDeclaredAnnotation(FieldCondition.class);
                if(fieldCondition != null){
                    if(sign){
                        sign=false;
                        LuceneDemoFieldMap.DEMOSEARCHFIELD.put(e,new ArrayList<>());
                        LuceneDemoFieldMap.DEMWRITERFIELD.put(e,new ArrayList<>());
                    }
                    DemoResolver resolver = new DemoResolver();
                    List<DemoResolver> list = LuceneDemoFieldMap.DEMOSEARCHFIELD.get(e);
                    List<DemoResolver> list1 = LuceneDemoFieldMap.DEMWRITERFIELD.get(e);
                    resolver.setFieldName(f.getName());
                    resolver.setType(fieldCondition.type());
                    resolver.setStore(fieldCondition.store());
                    //如果此字段不存储就不用放到查询Map中
                    if(fieldCondition.store()!= org.apache.lucene.document.Field.Store.NO)
                        list.add(resolver);
                    list1.add(resolver);

                }
            }
            sign = true;
        }
    }

}