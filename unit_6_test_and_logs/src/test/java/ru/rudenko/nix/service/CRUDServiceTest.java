package ru.rudenko.nix.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.AuthorBook;
import ru.rudenko.nix.entity.Book;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CRUDServiceTest {

  private final static CRUDService userService = CRUDService.getInstance();
  private final static int USERS_SIZE = 10;

  @BeforeAll
  static void setUp() {
    for (int i = 0; i < USERS_SIZE; i++) {
      Author author1 = new Author();
      author1.setName("test author " + i);
      Author author2 = new Author();
      author2.setName("test author " + i);
      Author author3 = new Author();
      author3.setName("test author " + i);
      Author[] authors = {author1, author2, author3};
      Book book = new Book();
      book.setNameOfBook("test book " + i);
      userService.createBookAuthors(book, authors);
    }
    Assertions.assertEquals(USERS_SIZE * 3, userService.findAllAuthorsBooks().length);
  }

  @Test
  @Order(1)
  void createBookAuthors() {
    Author author1 = new Author();
    author1.setName("test 1author createBookAuthors");
    Author author2 = new Author();
    author2.setName("test 2 createBookAuthors");
    Author author3 = new Author();
    author3.setName("test 3author createBookAuthors");
    Author[] authors = {author1, author2, author3};
    Book book = new Book();
    book.setNameOfBook("test book createBookAuthors");
    userService.createBookAuthors(book, authors);
    Assertions.assertEquals((USERS_SIZE * 3) + 3, userService.findAllAuthorsBooks().length);
  }

  @Test
  @Order(2)
  void update() {
    AuthorBook[] allAuthorsBooks = userService.findAllAuthorsBooks();
    String idBook = allAuthorsBooks[0].getIdBook();
    String idAuthor = allAuthorsBooks[0].getIdAuthor();
    AuthorBook authorBook = new AuthorBook();
    authorBook.setIdBook(idBook);
    authorBook.setIdAuthor(idAuthor + "test");
    userService.update(authorBook);
    allAuthorsBooks = userService.findAllAuthorsBooks();
    Assertions.assertEquals(idAuthor + "test", allAuthorsBooks[0].getIdAuthor());
  }

  @Test
  @Order(3)
  void delete() {
    AuthorBook[] allAuthorsBooks = userService.findAllAuthorsBooks();
    int before = allAuthorsBooks.length;
    String idBook = allAuthorsBooks[0].getIdBook();
    userService.delete(idBook);
    allAuthorsBooks = userService.findAllAuthorsBooks();
    int after = allAuthorsBooks.length;
    Assertions.assertEquals(before-3, after);
  }

  @Test
  @Order(4)
  void findAllAuthorsBooks() {
    AuthorBook[] allAuthorsBooks = userService.findAllAuthorsBooks();
    int expected = 30;
    Assertions.assertEquals(expected, allAuthorsBooks.length);
  }
}