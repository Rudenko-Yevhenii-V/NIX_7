package ry.rudenko.yevhenii.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;


/**
 * @author Rudenko Yevhenii
 * @created 05/09/2021 - 9:31 PM
 * @project NIX_7
 */
class CRUDServiceImplTest {
  private final static CRUDServiceImpl userService = CRUDServiceImpl.getInstance();
  private final static int USERS_SIZE = 10;

  @BeforeAll
  static void setUp() {
    if (userService.findAllAuthorsBooks().length < 2){
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
  }

  @Test
  @Order(1)
  void createBookAuthors() {
    final AuthorBook[] allAuthorsBooks = userService.findAllAuthorsBooks();
    Author author1 = new Author();
    author1.setName("test1 1");
    Author author2 = new Author();
    author2.setName("test2 1");
    Author author3 = new Author();
    author3.setName("test3 1");
    Author[] authors = {author1, author2, author3};
    Book book = new Book();
    book.setNameOfBook("test book 1");
    userService.createBookAuthors(book, authors);
    Assertions.assertEquals((allAuthorsBooks.length) + 3, userService.findAllAuthorsBooks().length);
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
  void delete() {
  }

  @Test
  void findBookAuthorByIdBook() {
  }

  @Test
  void findAuthorById() {
  }

  @Test
  void findBookById() {
  }

  @Test
  void findBookByName() {
  }

  @Test
  void findAllAuthorsBooks() {
  }

  @Test
  void updateAllData() {
  }
}