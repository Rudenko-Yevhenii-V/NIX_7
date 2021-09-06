package ry.rudenko.yevhenii.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Author implements IBooksAuthors {

  private String id;
  private String name;
}
