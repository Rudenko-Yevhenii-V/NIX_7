package ru.rudenko.nix;

import ru.rudenko.nix.Windows.ShowModule;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.AuthorBook;
import ru.rudenko.nix.entity.Book;
import ru.rudenko.nix.service.AuthorService;
import ru.rudenko.nix.service.BookService;
import ru.rudenko.nix.service.CRUDService;

public class Main {

  public static void main(String[] args) {
    ShowModule showModule = new ShowModule();
    showModule.setVisible(true);
//*****************************************************************************************************
//    CRUDService createOneBookWithAuthors = CRUDService.getInstance();
//
//    Book book1 = new Book();
//    book1.setNameOfBook("Harry Potter");
//    Author author1 = new Author();
//    author1.setName("J. K. Rowling");
//    Author author2 = new Author();
//    author2.setName("A. S. Buragova");
//    Author[] authors = {author1, author2};
//  createOneBookWithAuthors.createBookAuthors(book1, authors);
//  AuthorBook[] authorBooks = createOneBookWithAuthors.findAllAuthorsBooks();
//    for (int i = 0; i < authorBooks.length; i++) {
//      System.out.println( createOneBookWithAuthors.findBookById(authorBooks[i].getIdBook()).getNameOfBook() + " name book") ;
//      System.out.println(createOneBookWithAuthors.findAuthorById(authorBooks[i].getIdAuthor()).getName() + " author of book ") ;
//    }

//****************************************************************************
//    Author author1 = new Author();
//    author1.setName("author1");
//    Author author2 = new Author();
//    author2.setName("author2");
//    Author author3 = new Author();
//    author3.setName("author3");
//    Book book1 = new Book();
//    book1.setNameOfBook("book1");
//    Book book2 = new Book();
//    book2.setNameOfBook("book2");
//    Book book3 = new Book();
//    book3.setNameOfBook("book3");
//    AuthorService authorService = new AuthorService();
//    authorService.create(author1);
//    author1.setName("author1update");
//    authorService.update(author1);
//    System.out.println(" authorService.findAuthorById(author1.getId()) " + authorService
//        .findAuthorById(author1.getId()));
//    authorService.create(author2);
//    authorService.create(author3);
//    for (Author u : authorService.findAllAuthors()
//    ) {
//      System.out.println("authorService : name - " + u.getName() + " id - " + u.getId());
//    }
//    BookService bookService = new BookService();
//    bookService.create(book1);
//    System.out.println(bookService.findBookById(book1.getId()).getNameOfBook()
//        + " + bookService.findBookById(book1.getId())");
//    book1.setNameOfBook("book1updating");
//    bookService.update(book1);
//    System.out.println(book1.getId());
//    bookService.create(book2);
//    bookService.create(book3);
//    bookService.delete(book3.getId());
//    for (Book u : bookService.findAllBooks()
//    ) {
//      System.out.println("bookService : nameOfBook -  " + u.getNameOfBook() + " id - " + u.getId());
//    }
//    //test
//    AuthorBook authorBook1 = new AuthorBook();
//    AuthorBook authorBook2 = new AuthorBook();
//    Author[] autors1 = {author1, author2};
//    Author[] autors2 = {author1, author3};
//
//    CRUDService crudService = new CRUDService();
//    //create
//    crudService.createBookAuthors(book1, autors1);
//
//    System.out.println(authorBook1.getIdBook() + " = authorBook.getIdBook111()");
//    System.out.println("findBookByIdBook  = " + crudService.findBookByIdBook(book1.getId()));
//    //findBookByIdBook
//    AuthorBook authorBook = crudService.findBookByIdBook(book1.getId());
//
//    System.out.println(authorBook.getIdBook());
//
//    AuthorBook[] authorBooks = crudService.findAllAuthorsBooks();
//    System.out.println(authorBooks.length + " authorBooks.length");
//    for (int i = 0; i < authorBooks.length; i++) {
//      System.out.println(authorBooks[i].getIdAuthor() + " authorBooks[i].getIdAuthor()") ;
//      System.out.println(authorBooks[i].getIdBook() + " authorBooks[i].getIdBook() ") ;
//    }
    //    crudService.update();

    //**************************************************************
//    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//    CRUDService crudServiceTest = new CRUDService();
//    AuthorBook authorBookTest = new AuthorBook();
//    Author authorTest = new Author();
//    authorTest.setName("TestAuthorName");
//    Author[] authors = {authorTest};
//    Book bookTest = new Book();
//    bookTest.setNameOfBook("TestBookName");
//    crudService.createBookAuthors(authorBookTest, bookTest, authors);
//    AuthorBook authorBookTestFindByIdBook = crudService.findBookByIdBook(bookTest.getId());
//    System.out.println(authorBookTestFindByIdBook.getIdAuthor());
//    System.out.println(authorBookTestFindByIdBook.getIdBook());
  }

}
