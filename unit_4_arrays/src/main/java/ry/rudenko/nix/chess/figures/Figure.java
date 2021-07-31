package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.utilColors.Colors;

public abstract class Figure {
  Colors myColors = new Colors();
  public boolean isWhite;
  Figure[][] figures;

  public Figure(boolean isWhite) {
    this.isWhite = isWhite;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public abstract String draw();
  public  abstract String[] drawASCII();

  public abstract boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol, Figure[][] figures);


}
