package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.DrowBoard;

public class Rook extends Figure {

  public Rook(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public String draw() {
    if (myColors.getShell().equals("shell")) {
      return new DrowBoard().drawColorFigures("\u265c", isWhite);
    } else {
      if (isWhite) {
        return new DrowBoard().drawColorFigures("\u2656", isWhite);
      } else {
        return new DrowBoard().drawColorFigures("\u265c", isWhite);
      }
    }
  }

  private static Boolean straightPath(int nowRow, int nowCol,
      int needRow, int needCol) {
    return !((nowRow != needRow) && (nowCol != needCol));
  }

  @Override
  public boolean isMoveValid(int nowRow, int nowCol, int needRow, int needCol) {
    return straightPath(nowRow, nowCol, needRow, needCol);
  }
}
