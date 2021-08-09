package ry.rudenko;

import java.util.Scanner;
import ry.rudenko.windows.ShowModule;

public class Main {

  public static void main(String[] args) {
    Scanner bufferedReader = new Scanner(System.in);
    System.out.println("Starting module 1");
    System.out.println("press enter");
    bufferedReader.nextLine();
    ShowModule showModule = new ShowModule();
    showModule.setVisible(true);
  }
}
