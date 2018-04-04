package com.sw.test;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMongodb {
    //mongodb crud
    @Test
    public void testCrud(){
        //获取MongoDb的连接客户端
        MongoClient mongoClient=new MongoClient("127.0.0.1",27017);
        //System.out.println(mongoClient);

        //指定连接mongodb哪个数据库 ctrl+alt+v
        MongoDatabase aaaa = mongoClient.getDatabase("aaaa");

        //System.out.println(aaaa);
        //获取数据库中的所有集合
      /*  MongoIterable<String> names = aaaa.listCollectionNames();
        for (String s : names) {
            System.out.println(s);
        }*/

      //通过集合名称获取对象
        MongoCollection<Document> person = aaaa.getCollection("person");

        //创建文档
        /*Document doc=new Document();
        //追加数据
        doc.append("_id",10).append("name","张柯基").append("age",20);
        //添加数据
        person.insertOne(doc);*/


      /*  List<Document> list=new ArrayList<Document>();
        Document doc=new Document();
        doc.append("_id",11).append("name","张柯基").append("age",20);
        list.add(doc);
        person.insertMany(list);*/


      //修改数据
      //person.updateOne(Filters.eq("_id",10),new Document("$set",new Document("name","贱贱")));



        //删除
      //  person.deleteOne(Filters.eq("_id",10));


        //多条件查询 年龄>10 小于20
        BasicDBObject cind=new BasicDBObject();
        BasicDBList basicDBList=new BasicDBList();//多个条件
        basicDBList.add(new Document("name",new Document("$eq","张柯基")));
        basicDBList.add(new Document("age",new Document("$eq",20)));
        cind.put("$and",basicDBList);

        FindIterable<Document> documents1 = person.find(cind);
        for (Document d : documents1) {
            System.out.println(d);
        }


       /* //查询所有
        FindIterable<Document> documents = person.find();
        for (Document document : documents) {
            System.out.println(document);
        }*/


    }

}
