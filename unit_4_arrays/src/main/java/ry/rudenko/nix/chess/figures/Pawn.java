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
    public boolean isMoveValid(int nowRow, int nowCol, int needRow, int needCol, Figure[][] figures) {
        if (this.isWhite) {
            try {
                return (
                        ((nowCol == needCol) && nowRow == (needRow + 1)) ||
                                ((nowRow == 6) && (nowCol == needCol) && (nowRow == (needRow + 2))) ||
                                ((nowRow == (needRow + 1)) && (Math.abs(nowCol - needCol) == 1)) &&
                                        ((nowCol == needCol) || (needRow == nowRow) || (figures[nowRow][nowRow].isWhite ==
                                                !figures[needRow][needCol].isWhite)));
            } catch (NullPointerException e) {
                return false;
            }
        } else {
            try {
                return ((((nowCol == needCol) && nowRow == (needRow - 1))
                        || ((nowRow == 1) && (nowCol == needCol) && (nowRow == (needRow - 2)))
                        || ((nowRow == (needRow - 1)))
                        && (Math.abs(nowCol - needCol) == 1)) &&
                        ((nowCol == needCol) || (needRow == nowRow) || (figures[nowRow][nowCol].isWhite ==
                                !figures[needRow][needCol].isWhite)));
            } catch (NullPointerException e) {
                return false;
            }
        }
    }
}
