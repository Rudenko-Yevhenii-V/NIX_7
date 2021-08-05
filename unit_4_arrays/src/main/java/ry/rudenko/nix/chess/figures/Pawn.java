package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.DrowBoard;

public class Pawn extends Figure {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String draw() {

        if (myColors.getShell().equals("shell")) {
            return new DrowBoard().drawColorFigures("\u265f", isWhite);
        } else {
            if (isWhite) {

                return new DrowBoard().drawColorFigures("♙", isWhite);
            } else {
                return new DrowBoard().drawColorFigures("\u265f", isWhite);
            }
        }
    }

    @Override
    public String[] drawASCII() {

        String paw1 = new DrowBoard().drawColorFigures("        ", isWhite);
        String paw2 = new DrowBoard().drawColorFigures("   ()   ", isWhite);
        String paw3 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
        String paw4 = new DrowBoard().drawColorFigures("  /__\\  ", isWhite);
        String[] pawn = {paw1, paw2, paw3, paw4};
        return pawn;
    }

    @Override
    public boolean isMoveValid(int nowRow, int nowCol, int needRow, int needCol, Figure[][] figures) {
        if (this.isWhite) {
            try {
                return (((needRow - nowRow) < 3)) &&
                        ((nowCol == needCol) && nowRow == (needRow + 1)) ||
                        ((nowRow == 6) && (nowCol == needCol) && (nowRow == (needRow + 2))) ||
                        ((nowRow == (needRow + 1)) && (Math.abs(nowCol - needCol) == 1));

            } catch (NullPointerException e) {
                return false;
            }
        } else {
            try {
                return (((nowRow - needRow) < 3)) &&
                        (((nowCol == needCol) && nowRow == (needRow - 1))
                                || ((nowRow == 1) && (nowCol == needCol) && (nowRow == (needRow - 2)))
                                || ((nowRow == (needRow - 1)))
                                && (Math.abs(nowCol - needCol) == 1));
            } catch (NullPointerException e) {
                return false;
            }
        }
    }
}
