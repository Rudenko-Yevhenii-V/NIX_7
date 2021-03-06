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

  @Override
  public String[] drawASCII() {
      String paw1 = new DrowBoard().drawColorFigures("   II   ", isWhite);
      String paw2 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
      String paw3 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
      String paw4 = new DrowBoard().drawColorFigures("  /__\\  ", isWhite);
      String[] pawn = {paw1, paw2, paw3, paw4};
      return pawn;
  }

  private static Boolean straightPath(int nowRow, int nowCol,
      int needRow, int needCol) {
    return !((nowRow != needRow) && (nowCol != needCol));
  }

  @Override
  public boolean isMoveValid(int nowRow, int nowCol, int needRow, int needCol, Figure[][] figures) {
    return straightPath(nowRow, nowCol, needRow, needCol);
  }
}
