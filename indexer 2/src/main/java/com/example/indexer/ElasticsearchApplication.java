package com.example.indexer;

import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.io.stream.Writeable;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ElasticsearchApplication {

    public static void main(String[] args) throws IOException, JSONException {
        //Book book = new Book("prueba", "prueba", "prueba", 12.9, 2, "prueba", "prueba", 3, 3, "prueba", "prueba", 2, 2);
        System.out.println("################ Se está ejecutando la clase ElasticSearchapplication ################");
        /*BookRestTemplateService bookRestTemplateService = new BookRestTemplateService();
        String str = bookRestTemplateService.createUserIndex(book);
        System.out.println("Salida de book prueba:");
        System.out.println(str);*/
        BufferedReader br = null;
        System.out.println("Hola antes del try");
        List<Book> books = new ArrayList<Book>();
        try {
            System.out.println("Hola try");
            br = new BufferedReader(new FileReader(""));
            //Nos saltamos la primera línea para que no lea las labels del dataset
            String line = br.readLine();
            //Primer libro
            line = br.readLine();
            while (null != line) {
                System.out.println("Hola while");
                String[] libro = line.split(";");
                if(libro.length!=16) {
                    int aux = libro.length - 16;
                    for(int i=1; i<=aux; i++){
                        libro[8] += libro[8+aux];
                    }
                    Book book = new Book(libro[0],libro[1],libro[2],Double.parseDouble(libro[3]),Integer.parseInt(libro[7]),libro[8],libro[8+aux+1],Integer.parseInt(libro[8+aux+2]),Integer.parseInt(libro[8+aux+3]),libro[8+aux+4],libro[8+aux+5],Integer.parseInt(libro[8+aux+6]),Integer.parseInt(libro[8+aux+7]));
                    books.add(book);
                    System.out.println(book.toString());
                }else{
                    Book book = new Book(libro[0],libro[1],libro[2],Double.parseDouble(libro[3]),Integer.parseInt(libro[7]),libro[8],libro[9],Integer.parseInt(libro[10]),Integer.parseInt(libro[11]),libro[12],libro[13],Integer.parseInt(libro[14]),Integer.parseInt(libro[15]));
                    books.add(book);
                    System.out.println(book.toString());
                }
                line = br.readLine();
            }
        } catch (Exception e) {

        } finally {
            if (null != br) {
                br.close();
            }
        }

        doBulkV3(books);
        //SpringApplication.run(ElasticsearchApplication.class, args);
    }

    private static void doBulk(List<Book> books) {
        BulkRequest.Builder br = new BulkRequest.Builder();
        int index = 0;
        for(Book b : books){
            br.operations(op -> op.index(idx -> idx.index("book").id(b.getId()).document(b)));
            System.out.println("Hago algo num: " + index);
            index++;
        }

        //BulkResponse result =
    }

    private static void doBulkV2(List<Book> books){
        org.elasticsearch.action.bulk.BulkRequest request = new org.elasticsearch.action.bulk.BulkRequest();
        for(Book book : books){
            request.add(new IndexRequest(book.getDescription())
                    .source(XContentType.JSON, "field", "foo"));
            request.add(new IndexRequest());
        }

    }

    private static void doBulkV3(List<Book> books) throws IOException, JSONException {
        //JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        /*for(Book book:books){
            jsonMap.put("id", book.getId());
            jsonMap.put("title", book.getTitle());
            jsonMap.put("category", book.getCategory());
            jsonMap.put("price", book.getPrice());
            jsonMap.put("numberReviews", book.getNumberOfReviews());
            jsonMap.put("description", book.getDescription());
            jsonMap.put("imageLink", book.getImageLink());
            jsonMap.put("stars", book.getStars());
            jsonMap.put("numberPages", book.getNumberOfPages());
            jsonArray.put(jsonMap);
        }*/

        String path = "";
        try(PrintWriter out = new PrintWriter(new FileWriter(path))){
            for(Book book:books){
                jsonObject.put("id", book.getId());
                jsonObject.put("title", book.getTitle());
                jsonObject.put("category", book.getCategory());
                jsonObject.put("price", book.getPrice());
                jsonObject.put("numberReviews", book.getNumberOfReviews());
                jsonObject.put("description", book.getDescription());
                jsonObject.put("imageLink", book.getImageLink());
                jsonObject.put("stars", book.getStars());
                jsonObject.put("numberPages", book.getNumberOfPages());
                out.write(jsonObject.toString());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        /*IndexRequest request = new IndexRequest("book", "doc", books.get(1).getDescription())
                .source(jsonMap)
                .setPipeline("book");*/

    }

    private static void doBulkV4(){

    }

}
