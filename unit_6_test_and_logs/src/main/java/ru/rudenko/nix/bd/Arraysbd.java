package ru.rudenko.nix.bd;

import ru.rudenko.nix.entity.Book;

public class Arraysbd {
  private static final Arraysbd instance = new Arraysbd();
  private Arraysbd() { }

  public static Arraysbd getInstance() {
    return instance;
  }

  private Book[] books = new Book[1];

  public Book[] getBooks() {
    return books;
  }

  public void setBooks(Book[] books) {
    this.books = books;
  }
}
