package ry.rudenko.yevhenii.dao;


import ry.rudenko.yevhenii.entity.Author;

public interface AuthorDao {
  String create(Author author);
  void update(Author author);
  void delete(String id);
}
