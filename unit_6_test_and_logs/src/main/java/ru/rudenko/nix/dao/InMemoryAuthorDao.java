package ru.rudenko.nix.dao;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.entity.Author;

public class InMemoryAuthorDao {
  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
  private int counterForgenerateIdAuthors = 0;
  private int count = 1;
  private Author[] authorsArray = new Author[1];
  private static final InMemoryAuthorDao instance = new InMemoryAuthorDao();

  private InMemoryAuthorDao(){}

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public static InMemoryAuthorDao getInstance(){
    return instance;
  }

  public String create(Author author) {

    LOGGER_INFO.info("enter to create author");
    LOGGER_INFO.info(count + " Author create in author- " + author.getName());
    LOGGER_INFO.info("table authors has length : " + authorsArray.length);

     for (int i = 0; i < authorsArray.length; i++) {
       if (!(authorsArray[i] == null)){
         if(authorsArray[i].getName().equals(author.getName())){
           author.setId(authorsArray[i].getId());
           return author.getId();

         }
       }
     }
    authorsArray = Arrays.copyOf(authorsArray, count);
    author.setId(generateId());
    LOGGER_INFO.info("Author generate id in Author- " + author.getName() + " - " + author.getId());
    authorsArray[count-1] = author;
    count++;
    LOGGER_INFO.info("table Authors has length : " + authorsArray.length);
    LOGGER_INFO.info(("table Authors has last element : " + authorsArray[authorsArray.length-1].getId() + " " + authorsArray[authorsArray.length-1].getName()));
    LOGGER_INFO.info(("table Author id name: " + author.getId() + " " + author.getName()));
    LOGGER_INFO.info("Exit from create author");
    return author.getId();
  }
  public void update(Author author) {
    for (int i = 0; i < authorsArray.length; i++) {
      if (!(authorsArray[i] == null)){
        if(authorsArray[i].getName().equals(author.getName())){
          author.setId(authorsArray[i].getId());
          return ;
        }
      }
    }
    Author inDbAuthor = findAuthorById(author.getId());
    inDbAuthor.setName(author.getName());

  }

  public void delete(String id) {
    LOGGER_WARN.warn("try delete database record author - " + findAuthorById(id).getName());
    int countMuchDelId = 0;
    Author[] bufferArray;
    for (int i = 0; i < authorsArray.length; i++) {
      if (authorsArray[i].getId().equals(id)){
        authorsArray[i] = null;
        setCount(getCount() - 1);
        countMuchDelId++;
      }
    }
    bufferArray = new Author[authorsArray.length-countMuchDelId];
    int count = 0;
    for (int i = 0; i < authorsArray.length; i++) {
      if (!(authorsArray[i]==null)){
        bufferArray[count] = authorsArray[i];
        count++;
      }
    }
    authorsArray = bufferArray;
    LOGGER_WARN.warn("isExist database record author - " + findAuthorById(id));
    }

  public Author findAuthorById(String id) {
    if (authorsArray.length > 0) {
      for (int i = 0; i < authorsArray.length; i++) {
        if (authorsArray[i] == null){
          break;
        }
        if ((authorsArray[i].getId()).equals(id)) {
          return authorsArray[i];
        }
      }
    }
    return null;
  }
  public Author findAuthorByName(String authorName) {
    for (int i = 0; i < authorsArray.length; i++) {
      if ((authorsArray[i].getName()).equals(authorName)) {
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
