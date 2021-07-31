package ry.rudenko.nix.chess.game;

import java.util.LinkedList;
import java.util.List;

import ry.rudenko.nix.chess.figures.Bishop;
import ry.rudenko.nix.chess.figures.EmptyFigure;
import ry.rudenko.nix.chess.figures.Figure;
import ry.rudenko.nix.chess.figures.King;
import ry.rudenko.nix.chess.figures.Knight;
import ry.rudenko.nix.chess.figures.Pawn;
import ry.rudenko.nix.chess.figures.Queen;
import ry.rudenko.nix.chess.figures.Rook;
import ry.rudenko.nix.chess.game.utilColors.Colors;

public class DrowBoard {

    Colors myColors = new Colors();
    private int countDrawColorSells = 0;

    public DrowBoard() {
    }

    public String drawColorFigures(String stringToDrawColor, boolean isWhite) {
        if (isWhite) {
            return myColors.ansiRed + stringToDrawColor;
        } else {
            return myColors.ansiBlack + stringToDrawColor;
        }
    }

    private String drawColorSells(String stringToDrawColor) {
        String returnConstructor;
        if (stringToDrawColor.equals("")) {
            countDrawColorSells++;
            return "";
        }
        if ((countDrawColorSells % 2) == 0) {
            countDrawColorSells++;
            returnConstructor =
                    myColors.ansiCyanBackground + " " + stringToDrawColor + " " + myColors.ansiReset;
            return returnConstructor;
        } else {
            countDrawColorSells++;
            returnConstructor =
                    myColors.ansiWhiteBackground + " " + stringToDrawColor + " " + myColors.ansiReset;
            return returnConstructor;
        }
    }

    public Figure[][] firstAddFigureToArrayBoard(Figure[][] chessboard) {
        List<Figure> list = new LinkedList<>();
        list.add(new Rook(false));
        list.add(new Knight(false));
        list.add(new Bishop(false));
        list.add(new Queen(false));
        list.add(new King(false));
        list.add(new Bishop(false));
        list.add(new Knight(false));
        list.add(new Rook(false));
        list.add(new Rook(true));
        list.add(new Knight(true));
        list.add(new Bishop(true));
        list.add(new Queen(true));
        list.add(new King(true));
        list.add(new Bishop(true));
        list.add(new Knight(true));
        list.add(new Rook(true));

        for (int row = 0; row < chessboard.length; row++) {
            for (int col = 0; col < chessboard[row].length; col++) {
                if (row == 0) {
                    chessboard[row][col] = list.get(col);
                } else if (row == 1) {
                    chessboard[row][col] = new Pawn(false);
                } else if (row == 6) {
                    chessboard[row][col] = new Pawn(true);
                } else if (row == 7) {
                    chessboard[row][col] = list.get(col + 8);
                } else {
                    chessboard[row][col] = new EmptyFigure(true);
                }
            }
        }
        return chessboard;
    }

    public void drawBoard(Figure[][] chessboard) {
        new Helper().clearConsole();
        if (myColors.getShell().equals("shell")) {
            System.out.printf("_|%12s%12s%12s%12s%12s%12s%12s%12s%n", "\u0041", "B", "C", "D",
                    "E", "F", "G", "H");
            for (int row = 0; row < 8; row++) {
                System.out.println((8 - row) + drawColorSells(""));
                for (int line = 0; line < 6; line++) {
                    for (int cell = 0; cell < 8; cell++) {
                        System.out.print("   " + drawColorSells((chessboard[row][cell].drawASCII())[line]));
                    }
                    System.out.println();
                }

            }
            System.out.println();
            System.out.println(" ****** RED ****** ");
            System.out.println("if teams tied enter EXIT");
        } else {
            System.out.println(" ****** BLACK ****** ");
            System.out.printf("_| %2s %2s %2s %2s %2s %2s %2s %2s", "\u0041", "B", "C", "D",
                    "E", "F", "G", "H");
            for (int row = 0; row < chessboard.length; row++) {
                System.out.println(drawColorSells(""));
                System.out.printf("%2d", 8 - row);
                for (int col = 0; col < chessboard[row].length; col++) {
                    if (chessboard[row][col] != null) {
                        System.out.printf("%2s", drawColorSells(chessboard[row][col].draw()));
                    } else {
                        System.out.printf("%2s", drawColorSells("\u2662"));
                    }
                }
            }
            System.out.println();
            System.out.println(" ****** RED ****** ");
            System.out.println("if teams tied enter EXIT");
        }
    }
}
