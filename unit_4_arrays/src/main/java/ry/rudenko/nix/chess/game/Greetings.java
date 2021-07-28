package ry.rudenko.nix.chess.game;

import java.util.Random;
import ry.rudenko.nix.chess.game.myColors.MyColors;

public class Greetings {

  MyColors myColors = new MyColors();
  Random random = new Random();

  public void sayHelloStartGame() {
    new Helper().clearConsole();
    String chess = "********     *     *    *******    ********   ********\n" +
        "*            *     *    *          *          *\n" +
        "*            *     *    *          *          *\n" +
        "*            *******    *******    ********   ********\n" +
        "*            *     *    *                 *          *\n" +
        "*            *     *    *                 *          *\n" +
        "********     *     *    *******    ********   ********\n";
    System.out.flush();
    char[] charsOfChess = chess.toCharArray();
    for (char elOfCharsOfChess : charsOfChess) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.print(giveMixColors(String.valueOf(elOfCharsOfChess)));
    }
    try {
      Thread.sleep(1000);
      new Helper().clearConsole();
      System.out.print(myColors.ansiGreen + chess + myColors.ansiReset);
      Thread.sleep(500);
      new Helper().clearConsole();
      Thread.sleep(500);
      System.out.print(myColors.ansiRed + chess + myColors.ansiReset);
      Thread.sleep(300);
      new Helper().clearConsole();
      Thread.sleep(300);
      System.out.print(myColors.ansiPurple + chess  + myColors.ansiReset);
      Thread.sleep(700);
      new Helper().clearConsole();
      Thread.sleep(700);
      System.out.print(myColors.ansiYellow + chess + myColors.ansiReset);
      Thread.sleep(1000);
      new Helper().clearConsole();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
  }

  private String giveMixColors(String strigToColor) {

    switch (random.nextInt(9)) {
      case (1):
        return myColors.ansiReset + strigToColor;
      case (2):
        return myColors.ansiBlack + strigToColor;
      case (3):
        return myColors.ansiRed + strigToColor;
      case (4):
        return myColors.ansiYellow + strigToColor;
      case (5):
        return myColors.ansiGreen + strigToColor;
      case (6):
        return myColors.ansiBlue + strigToColor;
      case (7):
        return myColors.ansiPurple + strigToColor;
      case (8):
        return myColors.ansiCyan + strigToColor;
      case (9):
        return myColors.ansiWhite + strigToColor;
      default: return strigToColor;
    }
  }
}

