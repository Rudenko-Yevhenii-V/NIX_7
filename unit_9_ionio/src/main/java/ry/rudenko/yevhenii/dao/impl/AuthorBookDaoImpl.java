package ry.rudenko.yevhenii.dao.impl;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ry.rudenko.yevhenii.bd.JsonDBBooks;
import ry.rudenko.yevhenii.entity.AuthorBook;

public class AuthorBookDaoImpl {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private AuthorBook[] authorsbooks;
  private int count = 1;

  public AuthorBookDaoImpl() {
    authorsbooks = JsonDBBooks.getInstance().getAuthorsbooks();
    if (authorsbooks == null) {
      authorsbooks = new AuthorBook[1];
    }else {
      count = authorsbooks.length+1;
    }
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
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
          new BookDaoImpl().findBookById(authorBook.getIdBook()).getNameOfBook()
          + " " +
          new AuthorDaoImpl().findAuthorById(authorBook.getIdAuthor()).getName()
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
    JsonDBBooks.getInstance().write(authorsbooks);
  }

  public void update(AuthorBook authorBook) {

    AuthorBook inDbAuthorBook = findAuthorByIdBook(authorBook.getIdBook());
    inDbAuthorBook.setIdAuthor(authorBook.getIdAuthor());
    JsonDBBooks.getInstance().write(authorsbooks);
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
    JsonDBBooks.getInstance().write(authorsbooks);
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
