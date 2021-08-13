package ru.rudenko.nix.dao;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.AuthorBook;
import ru.rudenko.nix.entity.Book;

public class InMemoryAuthorBookDao {
  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
  private int count = 1;
  private AuthorBook[] authorsbooks = new AuthorBook[count];
  private static final InMemoryAuthorBookDao instance = new InMemoryAuthorBookDao();

  private InMemoryAuthorBookDao(){}

  public static InMemoryAuthorBookDao getInstance(){
    return instance;
  }
  public String create(String bookId, String[] authorsId) {
    LOGGER_INFO.info("enter to create AuthorBook");
    LOGGER_INFO.info("AuthorBook create in AuthorBook- " + bookId + " have number authors " + authorsId.length);
    LOGGER_INFO.info("table AuthorBook has length : " + authorsbooks.length);
    for (int i = 0; i < authorsbooks.length; i++) {
      if (!(authorsbooks[i] == null)){
        if(authorsbooks[i].getIdBook().equals(bookId)){
          return "this book exist in bd";
        }
      }
    }
    String[] idAuthors = new String[authorsId.length];
       for (int i = 0; i < idAuthors.length; i++) {
         AuthorBook authorBook = new AuthorBook();
         authorBook.setIdBook(bookId);
          authorBook.setIdAuthor(authorsId[i]);

          authorsbooks = Arrays.copyOf(authorsbooks, count );
         authorsbooks[count-1] = authorBook;
         count++;
         LOGGER_INFO.info("Table authorBook IdBook getIdAuthor: " +
             InMemoryBookDao.getInstance().findBookById(authorBook.getIdBook()).getNameOfBook()
             + " " +
             InMemoryAuthorDao.getInstance().findAuthorById(authorBook.getIdAuthor()).getName()
             );
       }
    LOGGER_INFO.info("table AuthorBook has length : " + authorsbooks.length);
    LOGGER_INFO.info(("table AuthorBook has last  3 elements : " + authorsbooks[authorsbooks.length-1].getIdBook() + " " + authorsbooks[authorsbooks.length-1].getIdAuthor()));
    LOGGER_INFO.info(("table AuthorBook has last  3 elements : " + authorsbooks[authorsbooks.length-2].getIdBook() + " " + authorsbooks[authorsbooks.length-2].getIdAuthor()));
    LOGGER_INFO.info(("table AuthorBook has last  3 elements : " + authorsbooks[authorsbooks.length-3].getIdBook() + " " + authorsbooks[authorsbooks.length-3].getIdAuthor()));
    LOGGER_INFO.info("Exit from create book");
    return authorsbooks[authorsbooks.length-1].getIdBook();
  }
  public void update(AuthorBook authorBook, Book book, Author[] authors) {

    AuthorBook inDbAuthorBook = findAuthorByIdBook(authorBook.getIdBook());
    inDbAuthorBook.setIdAuthor(authorBook.getIdAuthor());
  }
  public void delete(String idBook) {
    LOGGER_WARN.warn("try delete from database record authorBook where nameOfBook - " + findAuthorByIdBook(idBook).getIdBook());
    LOGGER_WARN.warn("total books in db books on start- " + findAllAuthorsBooks().length);
    int countMuchDelId = 0;
    AuthorBook[] bufferArray;
    for (int i = 0; i < authorsbooks.length; i++) {
      if (authorsbooks[i].getIdBook().equals(idBook)){
        authorsbooks[i] = null;
        countMuchDelId++;
      }
    }
    bufferArray = new AuthorBook[authorsbooks.length-countMuchDelId];
    int count = 0;
    for (int i = 0; i < bufferArray.length; i++) {
      if (!(authorsbooks[i]==null)){
        bufferArray[count] = authorsbooks[i];
        count++;
      }
    }
    authorsbooks = bufferArray;
    LOGGER_WARN.warn("total authorsbooks in db authorsbooks before deleting- " + findAllAuthorsBooks().length);
    LOGGER_WARN.warn("isExist authorsbooks in db - " + findAuthorByIdBook(idBook));

  }

//    int countMuchDelId = 0;
//    AuthorBook[] bufferArray;
//    LOGGER_WARN.warn("try delete database record id book - " + findAuthorByIdBook(id).getIdBook());
//    for (int i = 0; i < authorsbooks.length; i++) {
//      if (authorsbooks[i].getIdBook().equals(id)){
//        InMemoryAuthorDao.getInstance().delete(authorsbooks[i].getIdAuthor());
//        authorsbooks[i] = null;
//        countMuchDelId++;
//      }
//    }
//           System.out.println(authorsbooks.length);
//    bufferArray = new AuthorBook[authorsbooks.length-countMuchDelId];
//    int count = 0;
//    for (int i = 0; i < bufferArray.length; i++) {
//      if (!(authorsbooks[i]==null)){
//        bufferArray[count] = authorsbooks[i];
//        count++;
//      }
//    }
//    authorsbooks = bufferArray;
//    System.out.println(authorsbooks.length);
//    LOGGER_WARN.warn("isExist database record  id book  - " + findAuthorByIdBook(id));
//  }


  public AuthorBook findAuthorByIdBook(String idBook) {
    for (int i = 0; i < authorsbooks.length; i++) {
      if (authorsbooks[i] == null){
        continue;
      }
      if ((authorsbooks[i].getIdBook()).equals(idBook)) {
        return authorsbooks[i];
      }
    }
    return null;
  }

  public AuthorBook[] findAllAuthorsBooks() {
    return authorsbooks;
  }

}
