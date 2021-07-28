package ry.rudenko.nix.chess.logic;

import ry.rudenko.nix.chess.figures.Figure;

public class ValidCheker {
  private boolean moveValid;
  boolean whitesNowToMove;
  int nowRow;
  int nowCol;
  int needRow;
  int needCol;
  Figure figure1;
  Figure figure2;

  public ValidCheker(boolean whitesNowToMove, int nowRow, int nowCol, int needRow, int needCol,
      Figure figure1, Figure figure2) {

    this.whitesNowToMove = whitesNowToMove;
    this.nowRow = nowRow;
    this.nowCol = nowCol;
    this.needRow = needRow;
    this.needCol = needCol;
    this.figure1 = figure1;
    this.figure2 = figure2;
  }

  public boolean moveValid() {
    if (nowRow < 0 || nowRow > 7 || nowCol < 0 || nowCol > 7 || needRow < 0
        || needRow > 7 || needCol < 0 || needCol > 7) {
      System.out.println("Move is outside the board!");
      return false;
    }
    if (figure1 == null) {
      System.err.println("Origin is empty");
      return false;
    }
    if ((figure1.isWhite && !whitesNowToMove)
        || (!figure1.isWhite && whitesNowToMove)) {
      System.err.println("It's not your turn");
      return false;
    }
    if (!figure1.isMoveValid(nowRow, nowCol, needRow,
        needCol)) {
      System.out.println("This piece doesn't move like that");
      return false;
    }
    if (figure2 == null) {
      return true;
    }
    if (figure1.isWhite
        && figure2.isWhite) {
      System.err.println("White cannot land on white");
      return false;
    }
    if (!figure1.isWhite
        && !figure2.isWhite) {
      System.err.println("Black cannot land on black");
      return false;
    }
    return true;
  }

}
