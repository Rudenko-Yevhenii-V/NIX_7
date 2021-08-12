package ru.rudenko.nix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.dao.InMemoryAuthorDao;
import ru.rudenko.nix.entity.Author;

public class AuthorService {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private final InMemoryAuthorDao authorDao = InMemoryAuthorDao.getInstance();
  private static final AuthorService instance = new AuthorService();

  private AuthorService(){}

  public static AuthorService getInstance(){
    return instance;
  }
  public void create(Author author) {
    LOGGER_INFO.info("create new author: " + author.getName());
    authorDao.create(author);
  }

  public void update(Author author) {
    authorDao.update(author);
  }

  public void delete(String id) {
    LOGGER_WARN.warn("remove author by id: " + id);
    authorDao.delete(id);
  }

  public Author findAuthorById(String id) {
    return authorDao.findAuthorById(id);
  }
  public Author[] findAllAuthors() {
    return authorDao.findAllAuthors();
  }
}
