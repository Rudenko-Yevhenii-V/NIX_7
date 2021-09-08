package ry.rudenko.yevhenii;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.nixSONlib.SimpleMapper;
import ry.rudenko.yevhenii.windows.LoginWindow;

public class MainIONIO {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

  public static void main(String[] args) {


//    SimpleMapper simpleMapper = new SimpleMapper();
//    String myJson = "[{\"id\":\"1\",\"nameOfBook\":\"Harry Potter\"},{\"id\":\"2\",\"nameOfBook\""
//        + ":\"Harry Potter2\"},{\"id\":\"3\",\"nameOfBook\":\"Harry Potter3\"}]";
//
//    final List<Book> booksReturn =  simpleMapper.readJsonToList(myJson, new Book());
//
//    for (Book book : booksReturn) {
//      System.out.println("book.getId() = " + book.getId());
//      System.out.println("book.getNameOfBook() = " + book.getNameOfBook());
//    }

//    Book[] books;
//    List<Book> list = new ArrayList<>();
//    Book book1 = new Book();
//    book1.setId("1");
//    book1.setNameOfBook("Harry Potter");
//    Book book2 = new Book();
//    book2.setId("2");
//    book2.setNameOfBook("Harry Potter2");
//    Book book3 = new Book();
//    book3.setId("3");
//    book3.setNameOfBook("Harry Potter3");
//   books = new Book[]{book1, book2, book3};
//
//   list.add(book1);
//   list.add(book2);
//   list.add(book3);
//    System.out.println("simplMapper.writeValue(books) = " + simpleMapper.writeArrayToJson(books));
//    System.out.println("simpleMapper.writeListToJson(list) = " + simpleMapper.writeListToJson(list));
//    //need dell
//    Gson gson = new Gson();
//    String expectedJson = gson.toJson(books);
//    System.out.println("expectedJson = " + expectedJson);
//    System.out.println("expectedJson.equals(simplMapper.writeArrayToJson(books)) = " + expectedJson
//        .equals(simpleMapper.writeArrayToJson(books)));
//    System.out.println("expectedJson.equals(simpleMapper.writeListToJson(list)) = " + expectedJson
//        .equals(simpleMapper.writeListToJson(list)));

//    ObjectMapper objectMapper = new ObjectMapper();
//    try {
//      objectMapper.writeValue(new File("bookExempl.json"), books);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
    //need



//    List<String> list = new ArrayList<>();
//    System.out.println("simplMapper.writeListToJson(Collections.singletonList(list)) = " + simplMapper
//        .writeValue(Collections.singletonList(list)));

//    [
//     {"id":"1","nameOfBook":"Harry Potter1"},
//    {"id":"2","nameOfBook":"Harry Potter2"},
//    {"id":"3","nameOfBook":"Harry Potter3"}
//    ]






    LOGGER_INFO.info("test main");
    LoginWindow loginWindow = new LoginWindow();
    loginWindow.setVisible(true);
  }
}
