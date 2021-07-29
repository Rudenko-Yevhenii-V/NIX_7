package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.myColors.MyColors;

public abstract class Figure {
  MyColors myColors = new MyColors();
  public boolean isWhite;
  Figure[][] figures;

  public Figure(boolean isWhite) {
    this.isWhite = isWhite;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public abstract String draw();

  public abstract boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol, Figure[][] figures);


}
