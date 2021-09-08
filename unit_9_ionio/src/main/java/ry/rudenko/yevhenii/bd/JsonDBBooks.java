package ry.rudenko.yevhenii.bd;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.entity.IBooksAuthors;
import ry.rudenko.yevhenii.nixSONlib.SimpleMapper;

public class JsonDBBooks {

  private Book[] books = new Book[1];
  private AuthorBook[] authorsbooks = new AuthorBook[1];
  private Author[] authors = new Author[1];
  private final ObjectMapper objectMapper = new ObjectMapper();
  private static final JsonDBBooks instance = new JsonDBBooks();
  private SimpleMapper simpleMapper = new SimpleMapper();


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
      if(array.getClass().equals(Book[].class)){
        String stringJson = simpleMapper.writeArrayToJson(array);
        File file = new File("bookArray.json");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
        ) {
          bufferedWriter.write(stringJson);
        }catch (IOException e){
          System.out.println("e = " + e.getMessage());
        }
//        objectMapper.writeValue(new File("bookArray.json"), array);
      }
      if(array.getClass().equals(Author[].class)){
        String stringJson = simpleMapper.writeArrayToJson(array);
        File file = new File("authorArray.json");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
        ) {
          bufferedWriter.write(stringJson);
        }catch (IOException e){
          System.out.println("e = " + e.getMessage());
        }
//        objectMapper.writeValue(new File("authorArray.json"), array);
      }
      if(array.getClass().equals(AuthorBook[].class)){
        String stringJson = simpleMapper.writeArrayToJson(array);
        File file = new File("authorBookArray.json");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
        ) {
          bufferedWriter.write(stringJson);
        }catch (IOException e){
          System.out.println("e = " + e.getMessage());
        }
//        objectMapper.writeValue(new File("authorBookArray.json"), array);
      }
  }

  public IBooksAuthors[] read(IBooksAuthors[] array) {
    IBooksAuthors[] readOUT = null;
    try {
      if(array.getClass().equals(Book[].class)){
        Book[] bookOUT = null;
        if (new File("bookArray.json").exists()){
          bookOUT = objectMapper.readValue(
              new File("bookArray.json"),
              new TypeReference<Book[]>() {
              });
        }

        readOUT = bookOUT;
      }
      if(array.getClass().equals(Author[].class)){
        Author[] authorsOUT = null;
        if (new File("authorArray.json").exists()){
          authorsOUT = objectMapper.readValue(
              new File("authorArray.json"),
              new TypeReference<Author[]>() {
              });
        }

        readOUT = authorsOUT;
      }
      if(array.getClass().equals(AuthorBook[].class)){
        AuthorBook[] authorBooksOUT = null;
        if (new File("authorBookArray.json").exists()){
          authorBooksOUT = objectMapper.readValue(
              new File("authorBookArray.json"),
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
