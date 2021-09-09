package ry.rudenko.yevhenii.dao;

import ry.rudenko.yevhenii.entity.Book;

public interface BookDao {
  void create(Book book);
  void update(Book book);
  void delete(String id);
  Book findBookById(String id);
  Book findBookByName(String name);
  Book[] findAllBooks();


}
