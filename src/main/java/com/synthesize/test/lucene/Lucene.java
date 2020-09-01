package com.synthesize.test.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.classic.QueryParserTokenManager;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
* TERM:词语
* analyzer：分析器
* parser:解析器，语法分析
* */
public class  Lucene {
    //test document model
    static String doc1 = "a b c";
    static String doc2 = "a b c d";
    static String doc3 = "1 2 3 a b";
    //index repository locations
    static String path = "E:\\ideaProject\\utilAndTest\\src\\main\\resources\\lucene\\index";
    static Path pathP = Paths.get(path);
    static FSDirectory directory=null;
    static Analyzer analyzer = new SimpleAnalyzer();

    static {
        try {
            directory = FSDirectory.open(pathP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    //删除
    static void deleteIndex() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(path));
        IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig(new SimpleAnalyzer()));
        indexWriter.deleteAll();
        indexWriter.commit();
        indexWriter.close();
    }

    //词条搜索 单个关键字 分词查询 查询 DirectoryReader对象
    static void analyzerQuery(String keyWords,String title){
        QueryParser parser = new QueryParser(title,analyzer);

        try {
            //parse  可以将String 解析为查询对象
            Query query = parser.parse("name:"+ keyWords);
            DirectoryReader reader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs search = searcher.search(query, 100);
            System.out.println(search.scoreDocs.length);
            for (ScoreDoc sd : search.scoreDocs) {
                Document doc = reader.document(sd.doc);
                doc.getFields().forEach(e->{
                    System.out.println(e.name());
                    System.out.println(e.stringValue());
                });
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
    //单个关键字不分词查询 TermQuery

    static void termQuery(String field,String keyWords){

        Term term = new Term((field == null || field == "" ? "name" : field), keyWords);
        TermQuery query = new TermQuery(term);

        try {
            DirectoryReader reader = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(query, 100);
            System.out.println(docs.scoreDocs.length);
            for (ScoreDoc doc : docs.scoreDocs) {
                Document document = reader.document(doc.doc);
                System.out.println("id: "+document.get("id"));
                System.out.println("name: "+document.get("name"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
    //LongPoint
    static void point(String field,long num){
        Query query = LongPoint.newExactQuery(field, num);
        try {
            DirectoryReader open = DirectoryReader.open(directory);
            IndexSearcher searcher = new IndexSearcher(open);
            ScoreDoc[] search = searcher.search(query, 1).scoreDocs;
            System.out.println(search.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
//        deleteIndex();
 //       termQuery("name","name1");
        point("id",100l);
    }


}
