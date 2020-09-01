package com.synthesize.test.lucene.service.impl;

import com.synthesize.test.lucene.annotation.FieldCondition;
import com.synthesize.test.lucene.demo.Demo;
import com.synthesize.test.lucene.demo.DemoOne;
import com.synthesize.test.lucene.service.LuceneService;

import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.apache.lucene.document.Field.*;
@Service
public class   LuceneServiceImpl implements LuceneService {
    IndexWriter indexWriter;
    static FSDirectory directory;

    static {
        try {
            directory = FSDirectory.open(Paths.get("E:\\ideaProject\\utilAndTest\\src\\main\\resources\\lucene\\index"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    //根据传入的Demo属性上的注解来解析成Document对象
    public void writer(List<? extends Demo> demos) throws IOException {
        this.indexWriter = new IndexWriter(directory,new IndexWriterConfig(new SimpleAnalyzer()));
        boolean docSign = false;
        //数据为空
        if (demos.size()==0)
            return;
        List<Document> docs = new ArrayList<>();
        for (Demo e : demos) {
            Document doc = null;
            for (Field f : e.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                FieldCondition fd = f.getDeclaredAnnotation(FieldCondition.class);
                if(fd==null)
                    continue;
                if(!docSign)
                    doc=new Document();
                Class<? extends org.apache.lucene.document.Field> type = fd.type();
                try{
                    if(type.equals(StringField.class) || type.equals(TextField.class)){
                        Constructor<? extends org.apache.lucene.document.Field> constructor =
                                type.getDeclaredConstructor(String.class,String.class,Store.class);
                        doc.add(constructor.newInstance(f.getName(),(String)f.get(e),fd.store()));
                        if(!docSign){
                            docSign=true;
                        }
                        System.out.println("String add end"+" name:"+f.getName()+" value:"+f.get(e));
                    }else if(type.equals(LongPoint.class)){
                        Constructor<? extends org.apache.lucene.document.Field> constructor =
                                type.getDeclaredConstructor(String.class,long[].class);
                        doc.add(constructor.newInstance(f.getName(),new long[]{(long) f.get(e)}));
                        if(!docSign){
                            docSign=true;
                        }
                        System.out.println("Long add end");
                    }else if(type.equals(StoredField.class)){

                    }else {
                        try {
                            throw new Exception("Field Type Error");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
            }
            if (docSign){
                docs.add(doc);
                docSign=false;
            }

        }
        if(docs.size()>0){
            indexWriter.addDocuments(docs);
        }
    }

    @Override
    public List<Demo> termQuery(String field, String keyWord,int total) {
        TermQuery query = new TermQuery(new Term(field, keyWord));
        try {
            DirectoryReader reader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(reader);
            ScoreDoc[] scoreDocs = searcher.search(query, total == 0 ? 1 : total).scoreDocs;
            for (ScoreDoc doc : scoreDocs) {
                Document d = reader.document(doc.doc);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writer(DemoOne demo) {

    }
}
