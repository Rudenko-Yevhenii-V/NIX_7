package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.DrowBoard;

public class Queen extends Figure {

  public Queen(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public String draw() {
    if (myColors.getShell().equals("shell")) {
      return new DrowBoard().drawColorFigures("\u265b", isWhite);
    } else {
      if (isWhite) {
        return new DrowBoard().drawColorFigures("\u2655", isWhite);
      } else {
        return new DrowBoard().drawColorFigures("\u265b", isWhite);
      }
    }
  }


  private static Boolean diagonalPath(int nowRow, int nowCol, int needRow,
      int needCol) {
    return ((Math.abs(nowRow - needRow) == Math.abs(nowCol - needCol)));
  }

  private static Boolean straightPath(int nowRow, int nowCol, int needRow,
      int needCol) {
    return !((nowRow != needRow) && (nowCol != needCol));
  }

  @Override
  public boolean isMoveValid(int nowRow, int nowCol, int needRow, int needCol) {
    return (diagonalPath(nowRow, nowCol, needRow, needCol))
        || straightPath(nowRow, nowCol, needRow, needCol);
  }
}
