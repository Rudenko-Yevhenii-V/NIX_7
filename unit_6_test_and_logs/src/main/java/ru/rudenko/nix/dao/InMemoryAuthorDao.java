package ru.rudenko.nix.dao;

import java.util.Arrays;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.entity.Author;

public class InMemoryAuthorDao {
  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
  private int count = 0;
  private int counterForgenerateIdAuthors = 0;
  private Author[] authorsArray = new Author[count+1];
  private static final InMemoryAuthorDao instance = new InMemoryAuthorDao();

  private InMemoryAuthorDao(){}

  public static InMemoryAuthorDao getInstance(){
    return instance;
  }

  public String create(Author author) {
   if(authorsArray.length> 1){
     for (Author a: authorsArray
     ) {
       if(a.equals(author)){
          return a.getId();
       }
     }
   }
    authorsArray = Arrays.copyOf(authorsArray, count+1);
    author.setId(generateId());
    authorsArray[count] = author;
    count++;
    LOGGER_INFO.info(("table Author id name: " + author.getId() + " " + author.getName()));
    return author.getId();
  }

  public void update(Author author) {
    Author inDbAuthor = findAuthorById(author.getId());
    inDbAuthor.setName(author.getName());
  }

  public void delete(String id) {
    if ((authorsArray.length) < 0) {
      for (int i = 0; i < authorsArray.length; i++) {
        if ((authorsArray[i].getId()).equals(id)) {
          authorsArray[i] = null;
          for (int j = 2; j < authorsArray.length - i; j++) {
            authorsArray[j - i] = authorsArray[j];
            authorsArray[j] = null;
          }
        }
      }
    }
  }

  public Author findAuthorById(String id) {
    for (int i = 0; i < authorsArray.length; i++) {
      if ((authorsArray[i].getId()).equals(id)) {
        return authorsArray[i];
      }
    }
    return null;
  }

  public Author[] findAllAuthors() {
    return authorsArray;
  }

  private String generateId() {
    String id = (counterForgenerateIdAuthors+" AUTHOR "
//        + UUID.randomUUID().toString()
    );
    counterForgenerateIdAuthors++;
    if ((authorsArray.length) < 0) {
      for (int i = 0; i < authorsArray.length; i++) {
        if ((authorsArray[i].getId()).equals(id)) {
          return generateId();
        }
      }
    }
    return id;
  }
}
