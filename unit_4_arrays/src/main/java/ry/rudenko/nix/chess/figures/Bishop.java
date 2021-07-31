package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.DrowBoard;

public class Bishop extends Figure {

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String draw() {
        if (myColors.getShell().equals("shell")) {
            return new DrowBoard().drawColorFigures("\u265d", isWhite);

        } else {
            if (isWhite) {
                return new DrowBoard().drawColorFigures("\u2657", isWhite);
            } else {
                return new DrowBoard().drawColorFigures("\u265d", isWhite);
            }
        }
    }

    @Override
    public String[] drawASCII() {
        String paw1 = new DrowBoard().drawColorFigures("        ", isWhite);
        String paw2 = new DrowBoard().drawColorFigures("        ", isWhite);
        String paw3 = new DrowBoard().drawColorFigures("   ()   ", isWhite);
        String paw4 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
        String paw5 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
        String paw6 = new DrowBoard().drawColorFigures("  /__\\  ", isWhite);
        String[] pawn = {paw1, paw2, paw3, paw4, paw5, paw6};
        return pawn;
    }

    private static Boolean diagonalPath(int srcRow, int srcCol,
                                        int destRow, int destCol) {
        return ((Math.abs(srcRow - destRow) == Math.abs(srcCol
                - destCol)));
    }

    @Override
    public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol, Figure[][] figures) {
        return diagonalPath(srcRow, srcCol, destRow, destCol);
    }


}
