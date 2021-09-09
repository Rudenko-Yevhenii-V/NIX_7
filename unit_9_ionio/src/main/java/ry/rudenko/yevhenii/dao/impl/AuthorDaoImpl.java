package ry.rudenko.yevhenii.dao.impl;

import java.util.Arrays;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ry.rudenko.yevhenii.bd.JsonDBBooks;
import ry.rudenko.yevhenii.dao.AuthorDao;
import ry.rudenko.yevhenii.entity.Author;

public class AuthorDaoImpl implements AuthorDao {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private int count = 1;
  private Author[] authorsArray;

  public AuthorDaoImpl() {
    authorsArray = JsonDBBooks.getInstance().getAuthors();
    if (authorsArray == null) {
      authorsArray = new Author[1];
    } else {
      count = authorsArray.length + 1;
    }
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String create(Author author) {

    LOGGER_INFO.info("enter to create author");
    LOGGER_INFO.info(count + " Author create in author- " + author.getName());
    LOGGER_INFO.info("table authors has length : " + authorsArray.length);

    for (Author value : authorsArray) {
      if (!(value == null)) {
        if (value.getName().equals(author.getName())) {
          author.setId(value.getId());
          return author.getId();

        }
      }
    }
    author.setId(generateId());
    authorsArray = Arrays.copyOf(authorsArray, count);
    LOGGER_INFO.info("Author generate id in Author- " + author.getName() + " - " + author.getId());
    authorsArray[count - 1] = author;
    count++;
    LOGGER_INFO.info("table Authors has length : " + authorsArray.length);
    LOGGER_INFO.info(
        ("table Authors has last element : " + authorsArray[authorsArray.length - 1].getId() + " "
            + authorsArray[authorsArray.length - 1].getName()));
    LOGGER_INFO.info(("table Author id name: " + author.getId() + " " + author.getName()));
    LOGGER_INFO.info("Exit from create author");
    JsonDBBooks.getInstance().write(authorsArray);
    return author.getId();
  }

  public void update(Author author) {
    for (Author value : authorsArray) {
      if (!(value == null)) {
        if (value.getName().equals(author.getName())) {
          author.setId(value.getId());
          return;
        }
      }
    }
    Author inDbAuthor = findAuthorById(author.getId());
    inDbAuthor.setName(author.getName());
    JsonDBBooks.getInstance().write(authorsArray);
  }

  public void delete(String id) {
    LOGGER_WARN.warn("try delete database record author - " + findAuthorById(id).getName());
    int countMuchDelId = 0;
    Author[] bufferArray;
    for (int i = 0; i < authorsArray.length; i++) {
      if (authorsArray[i].getId().equals(id)) {
        authorsArray[i] = null;
        setCount(getCount() - 1);
        countMuchDelId++;
      }
    }
    bufferArray = new Author[authorsArray.length - countMuchDelId];
    int count = 0;
    for (Author author : authorsArray) {
      if (!(author == null)) {
        bufferArray[count] = author;
        count++;
      }
    }
    authorsArray = bufferArray;
    LOGGER_WARN.warn("isExist database record author - " + findAuthorById(id));
    JsonDBBooks.getInstance().write(authorsArray);
  }

  public Author findAuthorById(String id) {
    if (authorsArray.length > 0) {
      for (Author author : authorsArray) {
        if (author == null) {
          break;
        }
        if ((author.getId()).equals(id)) {
          return author;
        }
      }
    }
    return null;
  }

  public Author findAuthorByName(String authorName) {
    for (Author author : authorsArray) {
      if ((author.getName()).equals(authorName)) {
        return author;
      }
    }
    return null;
  }

  public Author[] findAllAuthors() {
    return authorsArray;
  }

  private String generateId() {
    String id = (UUID.randomUUID().toString());
    if ((authorsArray.length) > 2) {
      for (Author author : authorsArray) {
        if ((author.getId()).equals(id)) {
          return generateId();
        }
      }
    }
    return id;
  }
}
