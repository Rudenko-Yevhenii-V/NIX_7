package ru.rudenko.nix.dao;

import java.util.Arrays;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.AuthorBook;
import ru.rudenko.nix.entity.Book;
import ru.rudenko.nix.service.CRUDService;

public class InMemoryAuthorBookDao {

  private int count = 0;
  private AuthorBook[] authorsbooks = new AuthorBook[count + 1];
  private static final InMemoryAuthorBookDao instance = new InMemoryAuthorBookDao();

  private InMemoryAuthorBookDao(){}

  public static InMemoryAuthorBookDao getInstance(){
    return instance;
  }
  public void create(String book, String[] authors) {
    String[] idAuthors = new String[authors.length];
       for (int i = 0; i < idAuthors.length; i++) {
         AuthorBook authorBook = new AuthorBook();
         authorBook.setIdBook(book);
          authorBook.setIdAuthor(authors[i]);
          authorsbooks = Arrays.copyOf(authorsbooks, count + 1);
         authorsbooks[count] = authorBook;
         count++;
         System.out.println("+++++++++++++++++" + authorsbooks.length);
         System.out.println("Table authorBook IdBook getIdAuthor: " + authorBook.getIdBook() + " " + authorBook.getIdAuthor());

       }

//    //delete
//    for (AuthorBook b: authorsbooks
//    ) {
//      System.out.println("AuthorBookDao " + count + " count++ ==== create AuthorBook[] authorsbooks  " + b.getIdAuthor() + "getIdAuthor " + b.getIdBook() + " = getIdBook");
//    }
//    //delete
  }
  public void update(AuthorBook authorBook, Book book, Author[] authors) {

    AuthorBook inDbAuthorBook = findAuthorByIdBook(authorBook.getIdBook());
    inDbAuthorBook.setIdAuthor(authorBook.getIdAuthor());
  }
//  public void delete(String id) {
//    if ((authorsArray.length) < 0) {
//      for (int i = 0; i < authorsArray.length; i++) {
//        if ((authorsArray[i].getId()).equals(id)) {
//          authorsArray[i] = null;
//          for (int j = 2; j < authorsArray.length - i; j++) {
//            authorsArray[j - i] = authorsArray[j];
//            authorsArray[j] = null;
//          }
//        }
//      }
//    }
//  }

  public AuthorBook findAuthorByIdBook(String idBook) {
    for (int i = 0; i < authorsbooks.length; i++) {
      if ((authorsbooks[i].getIdBook()).equals(idBook)) {
        return authorsbooks[i];
      }
    }
    return null;
  }

  public AuthorBook[] findAllAuthorsBooks() {
    System.out.println(" ---------------- " + authorsbooks.length);
    return authorsbooks;
  }

}
