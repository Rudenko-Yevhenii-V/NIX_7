package ry.rudenko.yevhenii.bd;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ry.rudenko.yevhenii.entity.Book;

public class DelTEstSON {

public void  MakeJSON(){
  final ObjectMapper objectMapper = new ObjectMapper();

  Gson gson = new GsonBuilder()
      .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
      .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
      .create();
  Book book1 = new Book();
  book1.setId("12");
  book1.setNameOfBook("TEST1");
  Book book2 = new Book();
  book2.setId("1222");
  book2.setNameOfBook("TEST2");
  List<Book> bookList = new ArrayList<>();
  bookList.add(book1);
  bookList.add(book2);

  String pJson = gson.toJson(bookList);
  System.out.println("pJson = " + pJson);
  String pWrite  = bookList.toString();
  System.out.println("pWrite = " + pWrite);

  try {
    objectMapper.writeValue(new File("book.json"), bookList);
  } catch (IOException e) {
    e.printStackTrace();
  }



  try {
    Book[] langs = objectMapper.readValue(pJson, Book[].class);
    for (Book lang : langs) {
      System.out.println("lang = " + lang);
    }
    List<Book> langList = objectMapper.readValue(pJson, new TypeReference<List<Book>>(){});
    System.out.println("langList = " + langList);
  } catch (JsonProcessingException e) {
    e.printStackTrace();
  }

}
public void ExecJson(){
  final ObjectMapper objectMapper = new ObjectMapper();
  List<Book> langList = null;
  try {
    langList = objectMapper.readValue(
        new File("book.json"),
        new TypeReference<List<Book>>(){});
  } catch (IOException e) {
    e.printStackTrace();
  }

  langList.forEach(x -> System.out.println(x.toString()));
}

}

