package ru.rudenko.nix.dao;

import java.util.Arrays;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.bd.Arraysbd;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.Book;

public class InMemoryBookDao {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
private int count = 1;
  private int counterForgenerateIdBooks = 0;
  Arraysbd arraysbd = Arraysbd.getInstance();
  private Book[] books = arraysbd.getBooks();

  private static final InMemoryBookDao instance = new InMemoryBookDao();

  private InMemoryBookDao() {
  }

  public static InMemoryBookDao getInstance() {
    return instance;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String create(Book book) {

    LOGGER_INFO.info("enter to create book");
    LOGGER_INFO.info("Book create in book- " + book.getNameOfBook());
    LOGGER_INFO.info("table books has length : " + books.length);
    for (int i = 0; i < books.length; i++) {
      if (!(books[i] == null)){
        if(books[i].getNameOfBook().equals(book.getNameOfBook())){
          book.setId(books[i].getId());
          return book.getId();
        }
      }
    }
    books = Arrays.copyOf(books, count );
    book.setId(generateId());
    LOGGER_INFO.info("Book generate id in book- " + book.getNameOfBook() + " - " + book.getId());
    books[count-1] = book;
    count++;
    LOGGER_INFO.info("table books has length : " + books.length);
    LOGGER_INFO.info(("table books has last element : " + books[books.length-1].getId() + " " + books[books.length-1].getNameOfBook()));
    LOGGER_INFO.info("Exit from create book");
    return book.getId();
  }

  public void update(Book book) {
    Book inDbBook = findBookById(book.getId());
    inDbBook.setNameOfBook(book.getNameOfBook());
  }

  public void delete(String id) {
    LOGGER_WARN.warn("try delete from database record book name - " + findBookById(id).getNameOfBook());
    LOGGER_WARN.warn("total books in db books on start- " + findAllBooks().length);
    int countMuchDelId = 0;
    Book[] bufferArray;
    for (int i = 0; i < books.length; i++) {
      if (books[i].getId().equals(id)){
        books[i] = null;
        setCount(getCount()- 1);
        countMuchDelId++;
      }
    }
    bufferArray = new Book[books.length-countMuchDelId];
    int count = 0;
    for (int i = 0; i < books.length; i++) {
      if (!(books[i]==null)){
        bufferArray[count] = books[i];
        count++;
      }
    }
    books = bufferArray;
    LOGGER_WARN.warn("total books in db books before deleting- " + findAllBooks().length);
    LOGGER_WARN.warn("isExist book in db - " + findBookById(id));

  }

  public Book findBookById(String id) {
    if (books.length > 0) {
      for (int i = 0; i < books.length; i++) {
        if (books[i] == null){
          break;
        }
        if ((books[i].getId()).equals(id)) {
          return books[i];
        }
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