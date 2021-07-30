package src.nix.ry.rudenko;

import java.util.Scanner;
import ry.rudenko.nix.strings.reverse.ReverseString;

public class Main {

  public static void main(String[] args) {

    ReverseString reverse = new ReverseString();

    System.out.println("_________________________");
    System.out.println("actual = \"hello world\"\nexpected = \"olleh dlrow\"\n"
        + "reverse(\"hello world\") = " + reverse.reverse("hello world"));
    System.out.println("test passed: " + reverse.reverse("hello world").equals("olleh dlrow"));

    System.out.println("_________________________");
    System.out.println("actual = \"hello world\"\nexpected = \"hello lrowd\"\n"
        + "reverse(\"hello world\") = " + reverse.reverse("hello world", "worl"));
    System.out
        .println("test passed: " + reverse.reverse("hello world", "worl").equals("hello lrowd"));

    System.out.println("_________________________");
    System.out.println("actual = \"hello world\"\nexpected = \"helol owrld\"\n"
        + "reverse(\"hello world\") = " + reverse.reverse("hello world", 3, 7));
    System.out
        .println("test passed: " + reverse.reverse("hello world", 3, 7).equals("helol owrld"));

    System.out.println("_________________________");
    Scanner scanner = new Scanner(System.in);
    System.out.println("do you want read about ReverseString library? enter yes/no");
    String next = scanner.next();
    if (next.equalsIgnoreCase("yes")) {
      System.out.println("_________________________");
      System.out.println("_________________________");
      System.out.println("_________________________");
      System.out.println("_________________________");
      System.out.println(" String reverse(String src); - reverse word or sentence\n"
          + "\n"
          + "  String reverse(String src, boolean eachWord); - reverse sentence if true reverse eachWord\n"
          + "\n"
          + "  String reverse(String src, String dest); - reverse substring in string\n"
          + "\n"
          + "  String reverse(String src, String dest, boolean eachWord); reverse substring in string if true reverse eachWord\n"
          + "\n"
          + "  String reverse(String src, int firstIndex, int lastIndex); - reverse substring in string from first to last index\n"
          + "\n"
          + "  String reverse(String src, int firstIndex, int lastIndex, boolean eachWord);- reverse substring in string from first to last index if true reverse eachWord\n"
          + "\n"
          + "  String reverse(String src, char firstIndex, char lastIndex); - reverse substring in string from first to last index CharSequnce\n"
          + "\n"
          + "  String reverse(String src, char firstIndex, char lastIndex, boolean eachWord);  - reverse substring in string from first to last index CharSequnce if true reverse eachWord");
      System.out.println("_________________________");
      System.out.println("_________________________");
      System.out.println("_________________________");
      System.out.println("_________________________");
    } else {
      System.out.println("I would recommend reading about the library!!!GOOD BYE!!!");
    }
  }
}
