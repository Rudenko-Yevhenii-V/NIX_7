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
  private final InMemoryAuthorDao authorDao = InMemoryAuthorDao.getInstance();
  private final InMemoryBookDao bookDao = InMemoryBookDao.getInstance();
  private final InMemoryAuthorBookDao authorBookDao = InMemoryAuthorBookDao.getInstance();
  private static final CRUDService instance = new CRUDService();

  private CRUDService() {
  }

  public static CRUDService getInstance() {
    return instance;
  }

  public void createBookAuthors(Book book, Author[] authors) {

    int count = 0;
    bookDao.create(book);
    String[] authorsId = new String[count];
    for (Author author : authors) {
      authorsId = Arrays.copyOf(authorsId, count + 1);
      count++;
      authorDao.create(author);
      authorsId[count - 1] = InMemoryAuthorDao.getInstance().findAuthorById(author.getId())
          .getId();
    }
    authorBookDao.create(InMemoryBookDao.getInstance().findBookById(book.getId()).getId()
        , authorsId);

  }

  public void update(AuthorBook authorBook, Book book, Author[] authors) {
    authorBookDao.update(authorBook, book, authors);
  }

  public void delete(String id) {
    LOGGER_WARN.warn(
        " CRUDService remove book by id: " + InMemoryBookDao.getInstance().findBookById(id)
            .getNameOfBook());
    authorBookDao.delete(id);
    bookDao.delete(id);
//    authorDao.delete(id);
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

  public void updateAllData(String bookName, String bookNameSave,
      String authorName1, String authorNameSave1,
      String authorName2, String authorNameSave2,
      String authorName3, String authorNameSave3
  ) {
    if (!(bookNameSave.equals(bookName))) {
      Book bookUpdate = new Book();
      bookUpdate.setId(InMemoryBookDao.getInstance()
          .findBookByName(bookNameSave).getId());
      bookUpdate.setNameOfBook(bookName);
      InMemoryBookDao.getInstance().update(bookUpdate);
    }
    if (!(authorNameSave1.equals(authorName1))) {
      Author author1Update = new Author();
      author1Update.setName(authorName1);
      authorDao.create(author1Update);
      AuthorBook[] allAuthorsBooks = authorBookDao.findAllAuthorsBooks();
      for (int i1 = 0; i1 < allAuthorsBooks.length; i1++) {
        if (allAuthorsBooks[i1].getIdBook().equals(InMemoryBookDao.getInstance()
            .findBookByName(bookName).getId())) {
          if (allAuthorsBooks[i1].getIdAuthor().equals(InMemoryAuthorDao.getInstance()
              .findAuthorByName(authorNameSave1).getId())) {
            allAuthorsBooks[i1].setIdAuthor(InMemoryAuthorDao.getInstance()
                .findAuthorByName(authorName1).getId());
          }
        }
      }
    }
    if (!(authorNameSave2.equals(authorName2))) {
      Author author2Update = new Author();
      author2Update.setName(authorName2);
      InMemoryAuthorDao.getInstance().create(author2Update);
      AuthorBook[] allAuthorsBooks = InMemoryAuthorBookDao.getInstance()
          .findAllAuthorsBooks();
      for (int i1 = 0; i1 < allAuthorsBooks.length; i1++) {
        if (allAuthorsBooks[i1].getIdBook().equals(InMemoryBookDao.getInstance()
            .findBookByName(bookName).getId())) {
          if (allAuthorsBooks[i1].getIdAuthor().equals(InMemoryAuthorDao.getInstance()
              .findAuthorByName(authorNameSave2).getId())) {
            allAuthorsBooks[i1].setIdAuthor(InMemoryAuthorDao.getInstance()
                .findAuthorByName(authorName2).getId());
          }
        }
      }
    }
    if (!(authorNameSave3.equals(authorName3))) {
      Author author3Update = new Author();
      author3Update.setName(authorName3);
      InMemoryAuthorDao.getInstance().create(author3Update);
      AuthorBook[] allAuthorsBooks = InMemoryAuthorBookDao.getInstance()
          .findAllAuthorsBooks();
      for (int i1 = 0; i1 < allAuthorsBooks.length; i1++) {
        if (allAuthorsBooks[i1].getIdBook().equals(InMemoryBookDao.getInstance()
            .findBookByName(bookName).getId())) {
          if (allAuthorsBooks[i1].getIdAuthor().equals(InMemoryAuthorDao.getInstance()
              .findAuthorByName(authorNameSave3).getId())) {
            allAuthorsBooks[i1].setIdAuthor(InMemoryAuthorDao.getInstance()
                .findAuthorByName(authorName3).getId());
          }
        }
      }
    }
  }
}
