package ru.rudenko.nix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.Windows.ShowModule;
import ru.rudenko.nix.dao.InMemoryAuthorBookDao;
import ru.rudenko.nix.dao.InMemoryAuthorDao;
import ru.rudenko.nix.dao.InMemoryBookDao;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.Book;
import ru.rudenko.nix.service.CRUDService;

public class Unit6Main {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

  public static void main(String[] args) {
    LOGGER_INFO.info("Main test log info");
    LOGGER_WARN.warn("Main test log warn");
    LOGGER_ERROR.error("Main test log error");
    ShowModule showModule = new ShowModule();
    showModule.setVisible(true);

//    Book book1 = new Book();
//    Book book2 = new Book();
//    Book book3 = new Book();
//    book1.setNameOfBook("test book 1");
//    book2.setNameOfBook("test book 2");
//    book3.setNameOfBook("test book 3");
////    InMemoryBookDao inMemoryBookDao = InMemoryBookDao.getInstance();
////    System.out.println(inMemoryBookDao.create(book1));
////    System.out.println(inMemoryBookDao.create(book2));
////    System.out.println(inMemoryBookDao.create(book3));
////
////    System.out.println("findAllBooks start - " + inMemoryBookDao.findAllBooks().length);
//
////    inMemoryBookDao.delete(book2.getId());
////    System.out.println("findAllBooks delet one - " + inMemoryBookDao.findAllBooks().length);
//
//    Author author1 = new Author();
//    Author author2 = new Author();
//    Author author3 = new Author();
//    author1.setName("test author1");
//    author2.setName("test author2");
//    author3.setName("test author3");
////    InMemoryAuthorDao inMemoryAuthorDao = InMemoryAuthorDao.getInstance();
////    System.out.println(inMemoryAuthorDao.create(author1));
////    System.out.println(inMemoryAuthorDao.create(author2));
////    System.out.println(inMemoryAuthorDao.create(author3));
////
////    System.out.println(" "
////        + "id author1 = " + author1.getId()
////        + "id author2 = " + author2.getId()
////        + "id author3 = " + author3.getId()
////    );
//
////    System.out.println("findAllAuthors start - " + inMemoryAuthorDao.findAllAuthors().length);
////    inMemoryAuthorDao.delete(author2.getId());
////    System.out.println("findAllAuthors delet one - " + inMemoryAuthorDao.findAllAuthors().length);
//
////
////    InMemoryAuthorBookDao inMemoryAuthorBookDao = InMemoryAuthorBookDao.getInstance();
////    String[] authors1 = {author1.getId(), author1.getId(), author1.getId()};
////    String[] authors2 = {author2.getId(), author2.getId(), author2.getId()};
////    String[] authors3 = {author3.getId(), author3.getId(), author3.getId()};
////    System.out.println(inMemoryAuthorBookDao.create(book1.getId(), authors1));
////    System.out.println(inMemoryAuthorBookDao.create(book2.getId(), authors2));
////    System.out.println(inMemoryAuthorBookDao.create(book3.getId(), authors3));
////    System.out.println(
////        "inMemoryAuthorBookDao start - " + inMemoryAuthorBookDao.findAllAuthorsBooks().length);
//Author[] authors111 = {author1, author2, author3};
//    System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
//    System.out.println(book1.getId());
//    System.out.println(author1.getId());
//    System.out.println(author2.getId());
//    System.out.println(author3.getId());
//    CRUDService crudService = CRUDService.getInstance();
//    crudService.createBookAuthors(book1, authors111);
//
//    System.out.println(InMemoryAuthorBookDao.getInstance().findAllAuthorsBooks().length + " InMemoryAuthorBookDao.getInstance().findAllAuthorsBooks().length");
//    System.out.println(InMemoryAuthorDao.getInstance().findAllAuthors().length + " InMemoryAuthorDao.getInstance().findAllAuthors().length");
//    System.out.println(InMemoryBookDao.getInstance().findAllBooks().length+ " InMemoryBookDao.getInstance().findAllBooks().length");
////    crudService.delete(book2.getId());
//
//
////        inMemoryAuthorBookDao.delete(book2.getId());
////    System.out.println(
////        "inMemoryAuthorBookDao start - " + inMemoryAuthorBookDao.findAllAuthorsBooks().length);

  }
}
