package ru.rudenko.nix.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.rudenko.nix.dao.InMemoryBookDao;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.AuthorBook;
import ru.rudenko.nix.entity.Book;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommonTest {

  private static int bookID;
  private static int authorID;
  private final static CRUDService userService = CRUDService.getInstance();
  @Test
  @Order(1)
  void tryCreateWithEmptyBookName() {
    Author author1 = new Author();
    author1.setName("test author1 " );
    Author author2 = new Author();
    author2.setName("test author 2");
    Author author3 = new Author();
    author3.setName("test author 3");
    Author[] authors = {author1, author2, author3};
    Book book = new Book();
    book.setNameOfBook("");
    userService.createBookAuthors(book, authors);
    Assertions.assertEquals(1, userService.findAllAuthorsBooks().length);
  }

  @Test
  @Order(2)
  void tryCreateWithNullBook() {
    Author author1 = new Author();
    author1.setName("test author1 " );
    Author author2 = new Author();
    author2.setName("test author 2");
    Author author3 = new Author();
    author3.setName("test author 3");
    Author[] authors = {author1, author2, author3};
    String expectError = "java.lang.NullPointerException";
    String catchError = "";
    try {
      userService.createBookAuthors(null, authors);
    }catch (NullPointerException er){
      catchError = er.toString();
    }

    Assertions.assertEquals(expectError, catchError);
  }
  @Test
  @Order(3)
  void tryCreateWithEmptyAuthorName() {
    Author author1 = new Author();
    author1.setName("");
    Author author2 = new Author();
    author2.setName("test author 2");
    Author author3 = new Author();
    author3.setName("test author 3");
    Author[] authors = {author1, author2, author3};
    Book book = new Book();
    book.setNameOfBook("harry potter");
    userService.createBookAuthors(book, authors);
    Assertions.assertEquals(1, userService.findAllAuthorsBooks().length);
  }
}

