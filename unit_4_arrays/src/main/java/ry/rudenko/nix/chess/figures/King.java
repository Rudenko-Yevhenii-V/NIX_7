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
  public String[] drawASCII() {
    if (myColors.getShell().equals("shell")) {
      String paw1 = new DrowBoard().drawColorFigures("        ", isWhite);
      String paw2 = new DrowBoard().drawColorFigures("        ", isWhite);
      String paw3 = new DrowBoard().drawColorFigures("   II   ", isWhite);
      String paw4 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
      String paw5 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
      String paw6 = new DrowBoard().drawColorFigures("  /__\\  ", isWhite);
      String[] pawn = {paw1, paw2, paw3, paw4, paw5, paw6};
      return pawn;
    } else {
      if (isWhite) {
        String paw1 = "        ";
        String paw2 = "        ";
        String paw3 = "   II   ";
        String paw4 = "   )(   ";
        String paw5 = "   )(   ";
        String paw6 = "  /__\\  ";
        String[] pawn = {paw1, paw2, paw3, paw4, paw5, paw6};
        return pawn;
      } else {
        String paw1 = "********";
        String paw2 = "********";
        String paw3 = "***II***";
        String paw4 = "***)(***";
        String paw5 = "***)(***";
        String paw6 = "**/__\\**";
        String[] pawn = {paw1, paw2, paw3, paw4, paw5, paw6};
        return pawn;
      }
    }
  }

  @Override
  public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol, Figure[][] figures) {
    return Math.abs(destRow - srcRow) <= 1 || Math.abs(destCol - srcCol) <= 1;
  }
}
