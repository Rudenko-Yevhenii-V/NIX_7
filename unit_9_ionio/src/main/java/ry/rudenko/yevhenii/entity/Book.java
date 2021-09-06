package ry.rudenko.yevhenii.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book implements  IBooksAuthors {

  private String id;
  private String nameOfBook;
}
