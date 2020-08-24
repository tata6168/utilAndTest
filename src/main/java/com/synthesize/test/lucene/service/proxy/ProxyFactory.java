package com.synthesize.test.lucene.service.proxy;
import com.synthesize.test.lucene.service.LuceneService;
import com.synthesize.test.lucene.service.impl.LuceneServiceImpl;
import org.apache.lucene.index.IndexWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class ProxyFactory implements InvocationHandler {
    Object target;
    public ProxyFactory(Object target) throws IOException {
        this.target = target;
    }
    private Object proxy(){
        if(target!=null&&target instanceof LuceneService)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                      target.getClass().getInterfaces(),
                                      this
                );
        return target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Field writer = target.getClass().getDeclaredField("indexWriter");
        writer.setAccessible(true);
        IndexWriter indexWriter = (IndexWriter) writer.get(target);
        if(indexWriter==null)
            throw new Exception("...variable indexWriter null");
        Object invoke = method.invoke(this.target, args);
        indexWriter.commit();
        indexWriter.close();
        return invoke;

    }

    public static void main(String[] args) throws IOException {
        LuceneService proxy = (LuceneService) new ProxyFactory(new LuceneServiceImpl()).proxy();
        proxy.search();
    }
}
