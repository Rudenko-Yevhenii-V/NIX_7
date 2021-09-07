package ry.rudenko.yevhenii.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class Book implements  IBooksAuthors {

  private String id;

  @Override
  public String toString() {
    return "Book{" +
        "id='" + id + '\'' +
        ", nameOfBook='" + nameOfBook + '\'' +
        '}';
  }

  private String nameOfBook;
}
