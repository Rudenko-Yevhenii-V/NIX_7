package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.DrowBoard;

public class King extends Figure {

  public King(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public String draw() {
    if (myColors.getShell().equals("shell")) {
      return new DrowBoard().drawColorFigures("\u265a", isWhite);
    } else {
      if (isWhite) {
        return new DrowBoard().drawColorFigures("\u2654", isWhite);
      } else {
        return new DrowBoard().drawColorFigures("\u265a", isWhite);
      }
    }
  }


  @Override
  public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol) {
    return Math.abs(destRow - srcRow) <= 1 || Math.abs(destCol - srcCol) <= 1;
  }
}
