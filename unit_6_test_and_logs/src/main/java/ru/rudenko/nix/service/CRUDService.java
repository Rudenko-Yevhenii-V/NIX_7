package ru.rudenko.nix.service;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.dao.InMemoryAuthorBookDao;
import ru.rudenko.nix.dao.InMemoryAuthorDao;
import ru.rudenko.nix.dao.InMemoryBookDao;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.AuthorBook;
import ru.rudenko.nix.entity.Book;

public class CRUDService {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private  InMemoryAuthorDao authorDao = InMemoryAuthorDao.getInstance();
  private  InMemoryBookDao bookDao = InMemoryBookDao.getInstance();
  private  InMemoryAuthorBookDao authorBookDao = InMemoryAuthorBookDao.getInstance();
  private static final CRUDService instance = new CRUDService();

  private CRUDService(){}
  int count = 0;
  String[] authorsId = new String[count];
  public static CRUDService getInstance(){
    return instance;
  }
  public void createBookAuthors(Book book, Author[] authors) {
    for (Author author:authors
    ) {
      authorsId = Arrays.copyOf(authorsId, count + 1);
      count++;
      authorsId[count-1] = authorDao.create(author);
    }
    authorBookDao.create(bookDao.create(book), authorsId);
  }

  public void update(AuthorBook authorBook, Book book, Author[] authors) {
    authorBookDao.update(authorBook, book, authors);
  }
  public AuthorBook findBookByIdBook(String idBook) {
    return authorBookDao.findAuthorByIdBook(idBook);
  }

  public Author findAuthorById(String id) {
    return authorDao.findAuthorById(id);
  }
  public Book findBookById(String id) {
    return bookDao.findBookById(id);
  }
  public Book findBookByName(String nameOfBook) {
    return bookDao.findBookByName(nameOfBook);
  }


  public AuthorBook[] findAllAuthorsBooks() {
    return authorBookDao.findAllAuthorsBooks();
  }
}
