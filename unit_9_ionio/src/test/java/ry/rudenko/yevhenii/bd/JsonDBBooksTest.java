package ry.rudenko.yevhenii.bd;

import org.junit.jupiter.api.Test;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.entity.IBooksAuthors;


class JsonDBBooksTest {
  JsonDBBooks jsonDBBooks = JsonDBBooks.getInstance();

  @Test
  void testWrite() {
    Book[] books;
    Book book1 = new Book();
    book1.setId("1");
    book1.setNameOfBook("test1rttr");
    Book book2 = new Book();
    book2.setId("2");
    book2.setNameOfBook("test2rtrt");
    Book book3 = new Book();
    book3.setId("3");
    book3.setNameOfBook("test3rtrt");
    books = new Book[]{book1, book2, book3};
    jsonDBBooks.write(books);
    Author[] authors;
    Author author1 = new Author();
    author1.setId("1");
    author1.setName("author rttr1");
    Author author2 = new Author();
    author2.setId("2");
    author2.setName("author rttr2");
    Author author3 = new Author();
    author3.setId("3");
    author3.setName("author rttr3");
    authors = new Author[]{author1, author2, author3};
    jsonDBBooks.write(authors);
    AuthorBook[] authorBooks;
    AuthorBook authorBook1 = new AuthorBook();
    authorBook1.setIdAuthor("setIdAuthor 1");
    authorBook1.setIdBook("setIdBook 1");
    AuthorBook authorBook2 = new AuthorBook();
    authorBook2.setIdAuthor("setIdAuthor 2");
    authorBook2.setIdBook("setIdBook 2");
    authorBooks = new AuthorBook[]{authorBook1, authorBook2};
    jsonDBBooks.write(authorBooks);
  }

  @Test
  void testRead() {
    Book[] books = new Book[0];
    final IBooksAuthors[] read = jsonDBBooks.read(books);
    for (IBooksAuthors iBooksAuthors : read) {
      System.out.println("iBooksAuthors = " + iBooksAuthors);
    }
  }
  @Test
  void testGetBooks() {
    JsonDBBooks jsonDBBooks = JsonDBBooks.getInstance();
    final Book[] books = jsonDBBooks.getBooks();
    for (Book book : books) {
      System.out.println("book = " + book);
    }
  }
  @Test
  void testGetAuthors() {
    JsonDBBooks jsonDBBooks = JsonDBBooks.getInstance();
    final Author[] authors = jsonDBBooks.getAuthors();
    for (Author author : authors) {
      System.out.println("book = " + author);
    }
  }
  @Test
  void testGetAuthorsbooks() {
    JsonDBBooks jsonDBBooks = JsonDBBooks.getInstance();
    final AuthorBook[] authorBooks = jsonDBBooks.getAuthorsbooks();
    for (AuthorBook authorBook : authorBooks) {
      System.out.println("book = " + authorBook);
    }
  }
}