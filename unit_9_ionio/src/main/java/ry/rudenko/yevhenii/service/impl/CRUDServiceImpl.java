package ry.rudenko.yevhenii.service.impl;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ry.rudenko.yevhenii.bd.JsonDBBooks;
import ry.rudenko.yevhenii.dao.impl.AuthorBookDaoImpl;
import ry.rudenko.yevhenii.dao.impl.AuthorDaoImpl;
import ry.rudenko.yevhenii.dao.impl.BookDaoImpl;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.service.CRUDService;

public class CRUDServiceImpl implements CRUDService {
  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private final AuthorDaoImpl authorDao = new AuthorDaoImpl();
  private final BookDaoImpl bookDao = new BookDaoImpl();
  private final AuthorBookDaoImpl authorBookDao = new AuthorBookDaoImpl();
  private static final CRUDServiceImpl instance = new CRUDServiceImpl();

  private CRUDServiceImpl() {
  }

  public static CRUDServiceImpl getInstance() {
    return instance;
  }

  @Override
  public void createBookAuthors(Book book, Author[] authors) {
    if (book.getNameOfBook().equals("")) {
      return;
    }
    if (authors[0].getName().equals("")) {
      return;
    }
    LOGGER_INFO.info(" createBookAuthors in " + book.getNameOfBook() + " " + authors.length);
    int count = 0;
    bookDao.create(book);
    String[] authorsId = new String[count];
    for (Author author : authors) {
      authorsId = Arrays.copyOf(authorsId, count + 1);
      count++;
      authorDao.create(author);
      authorsId[count - 1] = new AuthorDaoImpl().findAuthorById(author.getId())
          .getId();
    }
    final String idBook = new BookDaoImpl().findBookById(book.getId()).getId();

    authorBookDao.create(idBook, authorsId);
  }

  @Override
  public void update(AuthorBook authorBook) {
    LOGGER_INFO.info(" update in " + authorBook.getIdBook() + " " + authorBook.getIdAuthor());
    authorBookDao.update(authorBook);
  }

  @Override
  public void delete(String idBook) {
    LOGGER_WARN.warn(
        " CRUDService remove book by id: " + new BookDaoImpl().findBookById(idBook)
            .getNameOfBook());
    authorBookDao.delete(idBook);
    bookDao.delete(idBook);
  }

  @Override
  public AuthorBook findBookAuthorByIdBook(String idBook) {
    LOGGER_INFO.info(" findBookAuthorByIdBook in " + idBook);
    return authorBookDao.findAuthorByIdBook(idBook);
  }

  @Override
  public Author findAuthorById(String id) {
    return authorDao.findAuthorById(id);
  }

  @Override
  public Book findBookById(String id) {
    return bookDao.findBookById(id);
  }

  @Override
  public Book findBookByName(String nameOfBook) {
    return bookDao.findBookByName(nameOfBook);
  }

  @Override
  public AuthorBook[] findAllAuthorsBooks() {
    return authorBookDao.findAllAuthorsBooks();
  }

  @Override
  public void updateAllData(String bookName, String bookNameSave, String authorName1,
      String authorNameSave1, String authorName2, String authorNameSave2, String authorName3,
      String authorNameSave3) {
    LOGGER_INFO.info(" updateAllData in " +  bookName + bookNameSave
        + authorName1 + authorNameSave1
        + authorName2 + authorNameSave2
        + authorName3 + authorNameSave3);

    if (!(bookNameSave.equals(bookName))) {
      Book bookUpdate = new Book();
      bookUpdate.setId(new BookDaoImpl()
          .findBookByName(bookNameSave).getId());
      bookUpdate.setNameOfBook(bookName);
      new BookDaoImpl().update(bookUpdate);
    }
    if (!(authorNameSave1.equals(authorName1))) {
      Author author1Update = new Author();
      author1Update.setName(authorName1);
      authorDao.create(author1Update);
      AuthorBook[] allAuthorsBooks = authorBookDao.findAllAuthorsBooks();
      for (AuthorBook allAuthorsBook : allAuthorsBooks) {
        if (allAuthorsBook.getIdBook().equals(bookDao
            .findBookByName(bookName).getId())) {
          if (allAuthorsBook.getIdAuthor().equals(authorDao
              .findAuthorByName(authorNameSave1).getId())) {
            allAuthorsBook.setIdAuthor(authorDao
                .findAuthorByName(authorName1).getId());
          }
        }
      }
      JsonDBBooks.getInstance().write(allAuthorsBooks);
    }
    if (!(authorNameSave2.equals(authorName2))) {
      Author author2Update = new Author();
      author2Update.setName(authorName2);
      authorDao.create(author2Update);
      AuthorBook[] allAuthorsBooks = authorBookDao
          .findAllAuthorsBooks();
      for (AuthorBook allAuthorsBook : allAuthorsBooks) {
        if (allAuthorsBook.getIdBook().equals(new BookDaoImpl()
            .findBookByName(bookName).getId())) {
          if (allAuthorsBook.getIdAuthor().equals(authorDao
              .findAuthorByName(authorNameSave2).getId())) {
            allAuthorsBook.setIdAuthor(authorDao
                .findAuthorByName(authorName2).getId());
          }
        }
      }
      JsonDBBooks.getInstance().write(allAuthorsBooks);
    }
    if (!(authorNameSave3.equals(authorName3))) {
      Author author3Update = new Author();
      author3Update.setName(authorName3);
      authorDao.create(author3Update);
      AuthorBook[] allAuthorsBooks = authorBookDao
          .findAllAuthorsBooks();
      for (AuthorBook allAuthorsBook : allAuthorsBooks) {
        if (allAuthorsBook.getIdBook().equals(new BookDaoImpl()
            .findBookByName(bookName).getId())) {
          if (allAuthorsBook.getIdAuthor().equals(authorDao
              .findAuthorByName(authorNameSave3).getId())) {
            allAuthorsBook.setIdAuthor(authorDao
                .findAuthorByName(authorName3).getId());
          }
        }
      }
      JsonDBBooks.getInstance().write(allAuthorsBooks);
    }
  }
}
