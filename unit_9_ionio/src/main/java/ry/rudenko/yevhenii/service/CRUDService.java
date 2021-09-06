package ry.rudenko.yevhenii.service;


import java.util.List;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.entity.User;

public interface CRUDService {

  void createBookAuthors(Book book, Author[] authors);
  void update(AuthorBook authorBook);
  void delete(String idBook);
  AuthorBook findBookAuthorByIdBook(String idBook);
  Author findAuthorById(String id);
  Book findBookById(String id);
  Book findBookByName(String nameOfBook);
  AuthorBook[] findAllAuthorsBooks();
  void updateAllData(String bookName, String bookNameSave,
      String authorName1, String authorNameSave1,
      String authorName2, String authorNameSave2,
      String authorName3, String authorNameSave3
  );

//  void create(User user);
//  void update(User user);
//  void delete(String id);
//  User findById(String id);
//  List<User> findAll();

}
