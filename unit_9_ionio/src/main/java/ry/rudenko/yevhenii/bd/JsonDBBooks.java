package ry.rudenko.yevhenii.bd;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.entity.IBooksAuthors;

public class JsonDBBooks {

  private Book[] books = new Book[1];
  private AuthorBook[] authorsbooks = new AuthorBook[1];
  private Author[] authors = new Author[1];
  private final ObjectMapper objectMapper = new ObjectMapper();
  private static final JsonDBBooks instance = new JsonDBBooks();

  private JsonDBBooks() {
  }

  public static JsonDBBooks getInstance() {
    return instance;
  }

  public Book[] getBooks() {
    return (Book[]) read(new Book[]{});
  }

  public AuthorBook[] getAuthorsbooks() {
    return (AuthorBook[]) read(new AuthorBook[]{});
  }

  public Author[] getAuthors() {
    return (Author[]) read(new Author[]{});
  }

  public void write(IBooksAuthors[] array) {
    try {
      if(array.getClass().equals(Book[].class)){
        objectMapper.writeValue(new File("filesJSON/bookArray.json"), array);
      }
      if(array.getClass().equals(Author[].class)){
        objectMapper.writeValue(new File("filesJSON/authorArray.json"), array);
      }
      if(array.getClass().equals(AuthorBook[].class)){
        objectMapper.writeValue(new File("filesJSON/authorBookArray.json"), array);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public IBooksAuthors[] read(IBooksAuthors[] array) {
    IBooksAuthors[] readOUT = null;
    try {
      if(array.getClass().equals(Book[].class)){
        Book[] bookOUT = null;
        if (new File("filesJSON/bookArray.json").exists()){
          bookOUT = objectMapper.readValue(
              new File("filesJSON/bookArray.json"),
              new TypeReference<Book[]>() {
              });
        }

        readOUT = bookOUT;
      }
      if(array.getClass().equals(Author[].class)){
        Author[] authorsOUT = null;
        if (new File("filesJSON/authorArray.json").exists()){
          authorsOUT = objectMapper.readValue(
              new File("filesJSON/authorArray.json"),
              new TypeReference<Author[]>() {
              });
        }

        readOUT = authorsOUT;
      }
      if(array.getClass().equals(AuthorBook[].class)){
        AuthorBook[] authorBooksOUT = null;
        if (new File("filesJSON/authorBookArray.json").exists()){
          authorBooksOUT = objectMapper.readValue(
              new File("filesJSON/authorBookArray.json"),
              new TypeReference<AuthorBook[]>() {
              });
        }
        readOUT = authorBooksOUT;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return readOUT;
  }
}
