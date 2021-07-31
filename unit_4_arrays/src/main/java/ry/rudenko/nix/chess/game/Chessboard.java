package ry.rudenko.nix.chess.game;

import java.util.Random;
import java.util.Scanner;

import ry.rudenko.nix.chess.figures.EmptyFigure;
import ry.rudenko.nix.chess.figures.Figure;
import ry.rudenko.nix.chess.logic.ValidCheker;


public class Chessboard {

  private Boolean gameRunning;
  private Figure[][] chessboard = new Figure[numOfRowsAndCols][numOfRowsAndCols];
  Scanner user_input = new Scanner(System.in);
  private static final int numOfRowsAndCols = 8;
  private static int nowRow, nowCol, needRow, needCol;
  DrowBoard drowBoard = new DrowBoard();
  private static Boolean whitesNowToMove;
  private static Boolean invalidMove = false;
  String enterMoveStep;

  public Figure[][] getChessboard() {
    return chessboard;
  }

  public Chessboard() {
    Random rand = new Random();
    whitesNowToMove = rand.nextBoolean();
    chessboard = drowBoard.firstAddFigureToArrayBoard(chessboard);
    gameRunning = true;
  }

  public Boolean getGameRunning() {
    return this.gameRunning;
  }

  public void move() {
    if (invalidMove) {
      System.err.println("Wrong MOVE! Please try again:");
      invalidMove = false;
    } else if (whitesNowToMove) {
      System.out
          .println("___________________________________________________\n"
              + "Red's move EXAMPLE ENTER: A2 to A4\n");
    } else {
      System.out
          .println("___________________________________________________\n"
              + "Black's move EXAMPLE ENTER: A7 to A6\n");
    }
    enterMoveStep = user_input.nextLine();
    if (enterMoveStep.equalsIgnoreCase("EXIT")) {
      gameRunning = false;
      System.out.println("Thanks you. Bye!");
      return;
    }
    String lowerCase = enterMoveStep.toLowerCase();
    String[] components = lowerCase.split(" ");
    nowRow = 7 - (components[0].charAt(1) - '1');
    nowCol = components[0].charAt(0) - 'a';
    needRow = 7 - (components[2].charAt(1) - '1');
    needCol = components[2].charAt(0) - 'a';
    if (new ValidCheker(whitesNowToMove, nowRow, nowCol, needRow, needCol,
        chessboard[nowRow][nowCol], chessboard[needRow][needCol], chessboard).moveValid()) {
      chessboard[needRow][needCol] = chessboard[nowRow][nowCol];
      chessboard[nowRow][nowCol] = new EmptyFigure(true);
      whitesNowToMove = !whitesNowToMove;
    } else {
      invalidMove = true;
      move();
    }
  }
}
