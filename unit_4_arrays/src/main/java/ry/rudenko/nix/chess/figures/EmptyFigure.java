package ry.rudenko.nix.chess.figures;


import ry.rudenko.nix.chess.game.DrowBoard;

public class EmptyFigure extends Figure {
  private final String empty = "empty";

  @Override
  public String toString() {
    return empty;
  }

  public EmptyFigure(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public String draw() {
    if(myColors.getShell().equals("shell")){
      return new DrowBoard().drawColorFigures("\u2662", isWhite);

    }else{
      if (isWhite) {
        return new DrowBoard().drawColorFigures("\u2662", isWhite);
      } else {
        return new DrowBoard().drawColorFigures("\u2662", isWhite);
      }
    }
  }

  @Override
  public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol, Figure[][] figures) {
    return false;
  }
}
