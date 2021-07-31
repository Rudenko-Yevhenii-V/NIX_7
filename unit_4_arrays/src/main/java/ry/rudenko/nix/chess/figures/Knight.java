package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.DrowBoard;

public class Knight extends Figure {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String draw() {
        if (myColors.getShell().equals("shell")) {
            return new DrowBoard().drawColorFigures("\u265e", isWhite);
        } else {
            if (isWhite) {
                return new DrowBoard().drawColorFigures("\u2658", isWhite);
            } else {
                return new DrowBoard().drawColorFigures("\u265e", isWhite);
            }
        }
    }

    @Override
    public String[] drawASCII() {

        String paw1 = new DrowBoard().drawColorFigures("        ", isWhite);
        String paw2 = new DrowBoard().drawColorFigures("        ", isWhite);
        String paw3 = new DrowBoard().drawColorFigures("  _,,   ", isWhite);
        String paw4 = new DrowBoard().drawColorFigures("\"-=\\~   ", isWhite);
        String paw5 = new DrowBoard().drawColorFigures("   )(   ", isWhite);
        String paw6 = new DrowBoard().drawColorFigures("  /__\\  ", isWhite);
        String[] pawn = {paw1, paw2, paw3, paw4, paw5, paw6};
        return pawn;
    }

    private static Boolean lShapedPath(int nowRow, int nowCol, int needRow, int needCol) {

        return ((Math.abs(nowRow - needRow) == 2 && Math.abs(nowCol
                - needCol) == 1)
                || (Math.abs(nowRow - needRow) == 1 && Math.abs(nowCol
                - needCol) == 2));
    }

    @Override
    public boolean isMoveValid(int nowRow, int nowCol, int needRow, int needCol, Figure[][] figures) {
        return lShapedPath(nowRow, nowCol, needRow, needCol);
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
