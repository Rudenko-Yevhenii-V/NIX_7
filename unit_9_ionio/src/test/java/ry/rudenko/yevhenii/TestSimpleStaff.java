package ry.rudenko.yevhenii;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ry.rudenko.yevhenii.dao.impl.AuthorDaoImpl;
import ry.rudenko.yevhenii.dao.impl.BookDaoImpl;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.service.impl.CRUDServiceImpl;


public class TestSimpleStaff {
  private final static CRUDServiceImpl userService = CRUDServiceImpl.getInstance();

  @Test
  void createBookAuthors() {
    final AuthorBook[] allAuthorsBooks = userService.findAllAuthorsBooks();
    int chengerName = 3;
    Author author1 = new Author();
    author1.setName("test1 " + chengerName);
    Author author2 = new Author();
    author2.setName("test2 " + chengerName);
    Author author3 = new Author();
    author3.setName("test3 " + chengerName);
    Author[] authors = {author1, author2, author3};
    Book book = new Book();
    book.setNameOfBook("test book " + chengerName);
    userService.createBookAuthors(book, authors);
    Assertions.assertEquals((allAuthorsBooks.length) + 3, userService.findAllAuthorsBooks().length);
  }
  @Test
  void testFindByALL() {
    System.out.println(
        "new File(\"filesJSON/bookArray.json\").exists() = " + new File("filesJSON/bookArray.json")
            .exists());
    final AuthorBook[] allAuthorsBooks = userService.findAllAuthorsBooks();
    for (int i = 0; i < allAuthorsBooks.length; i++) {
      AuthorBook allAuthorsBook = allAuthorsBooks[i];
      System.out.println(
          "         author = " + new AuthorDaoImpl()
              .findAuthorById(allAuthorsBook.getIdAuthor()));
      if((i+1)%3 == 0){

        System.out.println(
            "book = " + new BookDaoImpl()
                .findBookById(allAuthorsBook.getIdBook()));

      }
    }
  }
}
