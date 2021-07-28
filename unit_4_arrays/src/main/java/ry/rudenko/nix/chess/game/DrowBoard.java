package ry.rudenko.nix.chess.game;

import ry.rudenko.nix.chess.figures.Bishop;
import ry.rudenko.nix.chess.figures.Figure;
import ry.rudenko.nix.chess.figures.King;
import ry.rudenko.nix.chess.figures.Knight;
import ry.rudenko.nix.chess.figures.Pawn;
import ry.rudenko.nix.chess.figures.Queen;
import ry.rudenko.nix.chess.figures.Rook;
import ry.rudenko.nix.chess.game.myColors.MyColors;

public class DrowBoard {

  MyColors myColors = new MyColors();
  private int countDrawColorSells = 0;

  public DrowBoard() {
  }

  public String drawColorFigures(String stringToDrawColor, boolean isWhite) {
    if (isWhite) {
      return myColors.ansiWhite + stringToDrawColor;

    } else {
      return myColors.ansiBlack + stringToDrawColor;
    }

  }

  private String drawColorSells(String stringToDrawColor) {
    String returnConstructor;
    if (stringToDrawColor.equals("")) {
      countDrawColorSells++;
      return "";
    }
    if ((countDrawColorSells % 2) == 0) {
      countDrawColorSells++;
      returnConstructor =
          myColors.ansiGreenBackground + " " + stringToDrawColor + " " + myColors.ansiReset;
      return returnConstructor;
    } else {
      countDrawColorSells++;
      returnConstructor =
          myColors.ansiYellowBackground + " " + stringToDrawColor + " " + myColors.ansiReset;
      return returnConstructor;
    }

  }

  public Figure[][] firstAddFigureToArrayBoard(Figure[][] chessboard) {
    for (int row = 0; row < chessboard.length; row++) {
      for (int col = 0; col < chessboard[row].length; col++) {
        if (row == 0) {
          switch (col) {
            case 0:
              chessboard[row][col] = new Rook(false);
              break;
            case 1:
              chessboard[row][col] = new Knight(false);
              break;
            case 2:
              chessboard[row][col] = new Bishop(false);
              break;
            case 3:
              chessboard[row][col] = new Queen(false);
              break;
            case 4:
              chessboard[row][col] = new King(false);
              break;
            case 5:
              chessboard[row][col] = new Bishop(false);
              break;
            case 6:
              chessboard[row][col] = new Knight(false);
              break;
            case 7:
              chessboard[row][col] = new Rook(false);
              break;
          }
        } else if (row == 1) {
          chessboard[row][col] = new Pawn(false);
        } else if (row == 6) {
          chessboard[row][col] = new Pawn(true);
        } else if (row == 7) {
          switch (col) {
            case 0:
              chessboard[row][col] = new Rook(true);
              break;
            case 1:
              chessboard[row][col] = new Knight(true);
              break;
            case 2:
              chessboard[row][col] = new Bishop(true);
              break;
            case 3:
              chessboard[row][col] = new Queen(true);
              break;
            case 4:
              chessboard[row][col] = new King(true);
              break;
            case 5:
              chessboard[row][col] = new Bishop(true);
              break;
            case 6:
              chessboard[row][col] = new Knight(true);
              break;
            case 7:
              chessboard[row][col] = new Rook(true);
              break;
          }
        } else {
          chessboard[row][col] = null;
        }
      }
    }

    return chessboard;
  }

  public void drawBoard(Figure[][] chessboard) {
    new Helper().clearConsole();
    System.out.println(" ****** BLACK ****** ");
    System.out.printf("_| %2s %2s %2s %2s %2s %2s %2s %2s", "\u0041", "B", "C", "D",
        "E", "F", "G", "H");
    for (int row = 0; row < chessboard.length; row++) {
      System.out.println(drawColorSells(""));
      System.out.printf("%2d", 8 - row);
      for (int col = 0; col < chessboard[row].length; col++) {
        if (chessboard[row][col] != null) {
          System.out.printf("%2s", drawColorSells(chessboard[row][col].draw()));
        } else {
          System.out.printf("%2s", drawColorSells("\u2662"));

        }
      }
    }
    System.out.println();
    System.out.println(" ****** WHITE ****** ");
    System.out.println("if teams tied enter EXIT");

  }

}
