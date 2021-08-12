package ru.rudenko.nix.dao;

import java.util.Arrays;
import java.util.UUID;
import ru.rudenko.nix.bd.Arraysbd;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.Book;
import ru.rudenko.nix.service.CRUDService;

public class InMemoryBookDao {

  private int count = 0;
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
    System.out.println("table book id nameBook: " + book.getId() + " " + book.getNameOfBook());

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

  public Book[] findAllUsers() {
    return books;
  }

  private String generateId() {
    String id = UUID.randomUUID().toString();
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