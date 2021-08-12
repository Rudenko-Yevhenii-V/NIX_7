package ru.rudenko.nix.dao;

import java.util.Arrays;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.bd.Arraysbd;
import ru.rudenko.nix.entity.Book;

public class InMemoryBookDao {
  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
  private int count = 0;
  private int counterForgenerateIdBooks = 0;
  Arraysbd arraysbd = Arraysbd.getInstance();
  private Book[] books = arraysbd.getBooks();

  private static final InMemoryBookDao instance = new InMemoryBookDao();

  private InMemoryBookDao() {
  }

  public static InMemoryBookDao getInstance() {
    return instance;
  }

  public String create(Book book) {
    if (books.length > 1) {
      for (Book a : books
      ) {
        if (a.equals(book)) {
          return a.getId();
        }
      }
    }
    books = Arrays.copyOf(books, count + 1);
    book.setId(generateId());
    books[count] = book;
    count++;
    LOGGER_INFO.info(("table book id nameBook: " + book.getId() + " " + book.getNameOfBook()));
    return book.getId();
  }

  public void update(Book book) {
    Book inDbBook = findBookById(book.getId());
    inDbBook.setNameOfBook(book.getNameOfBook());
  }

  public void delete(String id) {
    if ((books.length) < 0) {
      for (int i = 0; i < books.length; i++) {
        if ((books[i].getId()).equals(id)) {
          books[i] = null;
          for (int j = 2; j < books.length - i; j++) {
            books[j - i] = books[j];
            books[j] = null;
          }
        }
      }
    }
  }

  public Book findBookById(String id) {
    for (int i = 0; i < books.length; i++) {
      if ((books[i].getId()).equals(id)) {
        return books[i];
      }
    }
    return null;
  }

  public Book findBookByName(String name) {
    for (int i = 0; i < books.length; i++) {
      if ((books[i].getNameOfBook()).equals(name)) {
        return books[i];
      }
    }
    return null;
  }

  public Book[] findAllBooks() {
    return books;
  }

  private String generateId() {
    String id = (counterForgenerateIdBooks + " BOOK  "
//        + UUID.randomUUID().toString()
    );
    counterForgenerateIdBooks++;
    if ((books.length) < 0) {
      for (int i = 0; i < books.length; i++) {
        if ((books[i].getId()).equals(id)) {
          return generateId();
        }
      }
    }
    return id;
  }
}