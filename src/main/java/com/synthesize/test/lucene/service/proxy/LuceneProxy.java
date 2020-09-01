package com.synthesize.test.lucene.service.proxy;
import com.synthesize.test.lucene.service.LuceneService;
import com.synthesize.test.lucene.service.impl.LuceneServiceImpl;
import org.apache.lucene.index.IndexWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class LuceneProxy implements InvocationHandler {
    Object target;
    public LuceneProxy(Object target) throws IOException {
        this.target = target;
    }
    public Object proxy(){
        if(target!=null&&target instanceof LuceneService)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                      target.getClass().getInterfaces(),
                                      this
                );
        return target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(this.target, args);
        Field writer = this.target.getClass().getDeclaredField("indexWriter");
        writer.setAccessible(true);
        IndexWriter indexWriter = (IndexWriter) writer.get(target);
        if(indexWriter==null) {
            throw new Exception("...variable indexWriter null");
        }
        indexWriter.commit();
        System.out.println("commit");
        indexWriter.close();
        return invoke;

    }

}
