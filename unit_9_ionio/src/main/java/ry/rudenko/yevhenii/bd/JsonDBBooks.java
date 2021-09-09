package ry.rudenko.yevhenii.bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.entity.IBooksAuthors;
import ry.rudenko.yevhenii.entity.User;
import ry.rudenko.yevhenii.nixSONlib.SimpleMapper;

public class JsonDBBooks {

  private Book[] books = new Book[1];
  private AuthorBook[] authorsbooks = new AuthorBook[1];
  private Author[] authors = new Author[1];
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
    if (array.getClass().equals(Book[].class)) {
      String stringJson = simpleMapper.writeArrayToJson(array);
      File file = new File("bookArray.json");
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
      ) {
        bufferedWriter.write(stringJson);
      } catch (IOException e) {
        System.out.println("e = " + e.getMessage());
      }
    }
    if (array.getClass().equals(Author[].class)) {
      String stringJson = simpleMapper.writeArrayToJson(array);
      File file = new File("authorArray.json");
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
      ) {
        bufferedWriter.write(stringJson);
      } catch (IOException e) {
        System.out.println("e = " + e.getMessage());
      }
    }
    if (array.getClass().equals(AuthorBook[].class)) {
      String stringJson = simpleMapper.writeArrayToJson(array);
      File file = new File("authorBookArray.json");
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
      ) {
        bufferedWriter.write(stringJson);
      } catch (IOException e) {
        System.out.println("e = " + e.getMessage());
      }
    }
  }

  public IBooksAuthors[] read(IBooksAuthors[] array) {

    IBooksAuthors[] readOUT = null;
    if (array.getClass().equals(Book[].class)) {
      String stringJson = null;
      File file = new File("bookArray.json");
      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))
      ) {
        stringJson = bufferedReader.readLine();
      } catch (IOException e) {
        System.out.println("e = " + e.getMessage());
      }
      final List<Book> books = simpleMapper.readJsonToList(stringJson, new Book());
      Book[] myArray = books.toArray(new Book[books.size()]);
      readOUT = myArray;
    }
    if (array.getClass().equals(Author[].class)) {
      String stringJson = null;
      File file = new File("authorArray.json");
      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))
      ) {
        stringJson = bufferedReader.readLine();
      } catch (IOException e) {
        System.out.println("e = " + e.getMessage());
      }
      final List<Author> author = simpleMapper.readJsonToList(stringJson, new Author());
      Author[] myArray = author.toArray(new Author[author.size()]);
      readOUT = myArray;
    }
    if (array.getClass().equals(AuthorBook[].class)) {
      String stringJson = null;
      File file = new File("authorBookArray.json");
      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))
      ) {
        stringJson = bufferedReader.readLine();
      } catch (IOException e) {
        System.out.println("e = " + e.getMessage());
      }
      final List<AuthorBook> authorBook = simpleMapper.readJsonToList(stringJson, new AuthorBook());
      AuthorBook[] myArray = authorBook.toArray(new AuthorBook[authorBook.size()]);
      readOUT = myArray;
    }
    return readOUT;
  }

  public List<User> read() {
    List<User> readOUT;
    String stringJson = null;
    File file = new File("userArray.json");
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))
    ) {
      stringJson = bufferedReader.readLine();
    } catch (IOException e) {
      System.out.println("e = " + e.getMessage());
    }
    readOUT = simpleMapper.readJsonToList(stringJson, new User());
    return readOUT;
  }
}
