package ry.rudenko.yevhenii.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthorBook implements  IBooksAuthors{

  private String idAuthor;
  private String idBook;
}
