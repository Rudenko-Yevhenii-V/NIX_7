package ru.rudenko.nix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.dao.InMemoryBookDao;
import ru.rudenko.nix.entity.Book;

public class BookService {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

  private final InMemoryBookDao bookDao = InMemoryBookDao.getInstance();
  private static final BookService instance = new BookService();

  private BookService() {
  }

  public static BookService getInstance() {
    return instance;
  }

  public void create(Book book) {
    LOGGER_INFO.info("create new book: " + book.getNameOfBook());
    bookDao.create(book);
  }

  public void update(Book book) {
    bookDao.update(book);
  }

  public void delete(String id) {
    LOGGER_WARN.warn("remove book by id: " + id);
    bookDao.delete(id);
  }

  public Book findBookById(String id) {
    return bookDao.findBookById(id);
  }

  public Book[] findAllBooks() {
    return bookDao.findAllUsers();
  }
}