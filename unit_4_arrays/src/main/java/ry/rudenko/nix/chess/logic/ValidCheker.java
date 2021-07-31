package ry.rudenko.nix.chess.logic;

import ry.rudenko.nix.chess.figures.EmptyFigure;
import ry.rudenko.nix.chess.figures.Figure;

public class ValidCheker {

    private boolean whitesNowToMove;
    private int nowRow;
    private int nowCol;
    private int needRow;
    private int needCol;
    private Figure figure1;
    private Figure figure2;
    private Figure[][] figures;

    public ValidCheker(boolean whitesNowToMove, int nowRow, int nowCol, int needRow, int needCol,
                       Figure figure1, Figure figure2, Figure[][] figures) {

        this.whitesNowToMove = whitesNowToMove;
        this.nowRow = nowRow;
        this.nowCol = nowCol;
        this.needRow = needRow;
        this.needCol = needCol;
        this.figure1 = figure1;
        this.figure2 = figure2;
        this.figures = figures;

    }

    public boolean moveValid() {

        if (nowRow < 0 || nowRow > 7 || nowCol < 0 || nowCol > 7 || needRow < 0
                || needRow > 7 || needCol < 0 || needCol > 7) {
            System.out.println("Move is outside the board!");
            return false;
        }
        if (figure1 == null) {
            System.err.println("Origin is empty");
            return false;
        }
        if ((figure1.isWhite && !whitesNowToMove)
                || (!figure1.isWhite && whitesNowToMove)) {
            System.err.println("It's not your turn");
            return false;
        }
        //todo
        if (!(figures[nowRow][nowCol].toString().equals("Knight"))) {
            if (nowRow == needRow) {
                for (int i = 1; i <= Math.abs(needCol - nowCol); i++) {
                    if ((figures[nowRow][nowCol + i * sign(needCol - nowCol)]).toString().equals
                            (new EmptyFigure(true).toString())) {
                        return false;
                    } else {
                        if (!(equilsFiguresByIsWhite(figures[nowRow][nowCol],
                                figures[nowRow][nowCol + i * sign(needCol - nowCol)]))) {
                            return false;
                        }
                    }
                }
            }
            if (needCol == nowCol) {
                for (int i = 1; i <= Math.abs(needRow - nowRow); i++) {
                    if (!(figures[nowRow + i * sign(needRow - nowRow)][nowCol]).toString().equals(
                            ((new EmptyFigure(true).toString())))) {
                        return false;
                    } else {
                        if (!(equilsFiguresByIsWhite(figures[nowRow][nowCol], figures[nowRow +
                                i * sign(needRow - nowRow)][nowCol]))) {
                            return false;
                        }
                    }
                }
            }
        }

        else {
            //System.out.println(" it is knight. Dont have all logic");
        }
        //todo
        if (!figure1.isMoveValid(nowRow, nowCol, needRow,
                needCol, figures)) {
            System.out.println("This piece doesn't move like that");
            return false;
        }
        if (figure2 == null) {
            return true;
        }
        equilsFiguresByIsWhite(figure1, figure2);

        return true;
    }

    private static int sign(int x) {
        if (x >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    private static boolean equilsFiguresByIsWhite(Figure figure1, Figure figure2) {
        if (figure1.isWhite
                && figure2.isWhite) {
            System.err.println("RED cannot land on red");
            return false;
        }
        if (!figure1.isWhite
                && !figure2.isWhite) {
            System.err.println("Black cannot land on black");
            return false;
        }
        return true;
    }
}
