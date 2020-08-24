package com.synthesize.test.lucene;

import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class  Lucene {
    //test document model
    static String doc1 = "a b c";
    static String doc2 = "a b c d";
    static String doc3 = "1 2 3 a b";

    //index repository locations
    static String path = "E:\\ideaProject\\utilAndTest\\src\\main\\resources\\lucene\\index";

    //创建索引
    static void indexWriterTest() throws IOException {
        //索引库位置
        FSDirectory open = FSDirectory.open(Paths.get(path));
        //分词器
        SimpleAnalyzer analyzer = new SimpleAnalyzer();
        //索引写入器
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(open,config);
        //文本转换为document对象
        Document doco = new Document();
        doco.add(new TextField("title","doc1", Field.Store.YES));
        doco.add(new TextField("content",doc1, Field.Store.YES));
        //通过IndexWriter将doc对象提交到缓冲区
        indexWriter.addDocument(doco);
        indexWriter.commit();
        indexWriter.close();
    }
    //修改
    static void updateIndex() throws IOException {

    }
    //删除
    static void deleteIndex() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(path));
        IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig(new SimpleAnalyzer()));
        indexWriter.deleteAll();
        indexWriter.commit();
        indexWriter.close();
    }
    //查询
    //Retrieve index  封装查询为查询对象提交
    static void retrieve(String keyWords) throws ParseException, IOException {
        //查询字段名字  = 分词器
        String field = "content";
        SimpleAnalyzer analyzer = new SimpleAnalyzer();
        //查询解析
        QueryParser parser = new QueryParser(field, analyzer);
        Query query = parser.parse(field + keyWords);
        //
        FSDirectory open = FSDirectory.open(Paths.get(path));
        DirectoryReader reader = DirectoryReader.open(open);
        //准备IndexSearcher对象 查询到文档编号
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        //param2：为前1000个符合查询的是文件
        TopDocs search = indexSearcher.search(query, 1000);
        //命中所有文档index的封装
        ScoreDoc[] scoreDocs = search.scoreDocs;
        for (ScoreDoc doc : scoreDocs) {
            int i = doc.doc;
            Document document = indexSearcher.doc(i);
            System.out.println( "documentId:"+i+"\n"+
                                "documentTitle:"+document.get("title")+"\n"+
                                "documentContent:"+document.get("content"));
        }

    }


    public static void main(String[] args) throws IOException, ParseException {
        //indexWriterTest();
        retrieve("a b");
//        deleteIndex();
    }
}
