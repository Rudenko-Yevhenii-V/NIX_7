package ru.rudenko.nix.dao;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.entity.AuthorBook;

public class InMemoryAuthorBookDao {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private AuthorBook[] authorsbooks = new AuthorBook[1];
  private int count = 1;
  private static final InMemoryAuthorBookDao instance = new InMemoryAuthorBookDao();

  private InMemoryAuthorBookDao() {
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public static InMemoryAuthorBookDao getInstance() {
    return instance;
  }

  public void create(String bookId, String[] authorsId) {

    LOGGER_INFO.info("enter to create AuthorBook");
    LOGGER_INFO.info(
        "AuthorBook create in AuthorBook- " + bookId + " have number authors " + authorsId.length);
    LOGGER_INFO.info("table AuthorBook has length : " + authorsbooks.length);
    for (AuthorBook authorsbook : authorsbooks) {
      if (!(authorsbook == null)) {
        if (authorsbook.getIdBook().equals(bookId)) {
          return;
        }
      }
    }
    String[] idAuthors = new String[authorsId.length];
    for (int i = 0; i < idAuthors.length; i++) {
      AuthorBook authorBook = new AuthorBook();
      authorBook.setIdBook(bookId);
      authorBook.setIdAuthor(authorsId[i]);
      authorsbooks = Arrays.copyOf(authorsbooks, count);
      authorsbooks[count - 1] = authorBook;
      count++;
      LOGGER_INFO.info("Table authorBook IdBook getIdAuthor: " +
          InMemoryBookDao.getInstance().findBookById(authorBook.getIdBook()).getNameOfBook()
          + " " +
          InMemoryAuthorDao.getInstance().findAuthorById(authorBook.getIdAuthor()).getName()
      );
    }
    LOGGER_INFO.info("table AuthorBook has length : " + authorsbooks.length);
    LOGGER_INFO.info(
        ("table AuthorBook has last  3 elements : " + authorsbooks[authorsbooks.length - 1]
            .getIdBook() + " " + authorsbooks[authorsbooks.length - 1].getIdAuthor()));
    LOGGER_INFO.info(
        ("table AuthorBook has last  3 elements : " + authorsbooks[authorsbooks.length - 2]
            .getIdBook() + " " + authorsbooks[authorsbooks.length - 2].getIdAuthor()));
    LOGGER_INFO.info(
        ("table AuthorBook has last  3 elements : " + authorsbooks[authorsbooks.length - 3]
            .getIdBook() + " " + authorsbooks[authorsbooks.length - 3].getIdAuthor()));
    LOGGER_INFO.info("Exit from create book");
  }

  public void update(AuthorBook authorBook) {

    AuthorBook inDbAuthorBook = findAuthorByIdBook(authorBook.getIdBook());
    inDbAuthorBook.setIdAuthor(authorBook.getIdAuthor());
  }

  public void delete(String idBook) {
    LOGGER_WARN.warn(
        "try delete from database record authorBook where nameOfBook - " + findAuthorByIdBook(
            idBook).getIdBook());
    LOGGER_WARN.warn("total books in db books on start- " + findAllAuthorsBooks().length);
    int countMuchDelId = 0;

    AuthorBook[] bufferArray;
    for (int i = 0; i < authorsbooks.length; i++) {
      if (authorsbooks[i].getIdBook().equals(idBook)) {
        authorsbooks[i] = null;
        setCount(getCount() - 1);
        countMuchDelId++;
      }
    }

    bufferArray = new AuthorBook[authorsbooks.length - countMuchDelId];
    int countbufferArray = 0;
    for (AuthorBook authorsbook : authorsbooks) {
      if (!(authorsbook == null)) {
        bufferArray[countbufferArray] = authorsbook;
        countbufferArray++;
      }
    }
    authorsbooks = bufferArray;
    LOGGER_WARN.warn(
        "total authorsbooks in db authorsbooks before deleting- " + findAllAuthorsBooks().length);
    LOGGER_WARN.warn("isExist authorsbooks in db - " + findAuthorByIdBook(idBook));

  }

  public AuthorBook findAuthorByIdBook(String idBook) {
    for (AuthorBook authorsbook : authorsbooks) {
      if (authorsbook == null) {
        continue;
      }
      if ((authorsbook.getIdBook()).equals(idBook)) {
        return authorsbook;
      }
    }
    return null;
  }

  public AuthorBook findBookByidAuthor(String idAuthor) {
    for (AuthorBook authorsbook : authorsbooks) {
      if (authorsbook == null) {
        continue;
      }
      if ((authorsbook.getIdAuthor()).equals(idAuthor)) {
        return authorsbook;
      }
    }
    return null;
  }

  public AuthorBook[] findAllAuthorsBooks() {
    return authorsbooks;
  }

}
