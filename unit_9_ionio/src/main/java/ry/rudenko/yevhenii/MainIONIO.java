package ry.rudenko.yevhenii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.nixSONlib.SimplMapper;
import ry.rudenko.yevhenii.windows.LoginWindow;

public class MainIONIO {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

  public static void main(String[] args) {
    SimplMapper simplMapper = new SimplMapper();

    Book[] books;
    Book book1 = new Book();
    book1.setId("1");
    book1.setNameOfBook("test1rttr");
    Book book2 = new Book();
    book2.setId("2");
    book2.setNameOfBook("test2rtrt");
    Book book3 = new Book();
    book3.setId("3");
    book3.setNameOfBook("test3rtrt");
    books = new Book[]{book1, book2, book3};
//    jsonDBBooks.write(books);
    System.out.println("simplMapper.writeValue(books) = " + simplMapper.writeValue(books));

    List<String> list = new ArrayList<>();
    System.out.println("simplMapper.writeValue(Collections.singletonList(list)) = " + simplMapper
        .writeValue(Collections.singletonList(list)));








//    LOGGER_INFO.info("test main");
//    LoginWindow loginWindow = new LoginWindow();
//    loginWindow.setVisible(true);
  }
}
