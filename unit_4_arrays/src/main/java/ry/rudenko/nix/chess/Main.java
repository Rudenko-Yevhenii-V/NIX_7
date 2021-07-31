package ry.rudenko.nix.chess;

import ry.rudenko.nix.chess.game.Chessboard;
import ry.rudenko.nix.chess.game.DrowBoard;
import ry.rudenko.nix.chess.game.Greetings;
import ry.rudenko.nix.chess.game.Helper;
import ry.rudenko.nix.chess.game.utilColors.Colors;

import java.util.Scanner;


public class Main {

    public static void main(String[] args)  {
    for (String arg : args) {
      new Colors().setShell(arg);
      new Helper().setShell(arg);
    }
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("STARTing GAME CHESS!");
        System.out.println();
        System.out.println("Press ENTER to continue...");
        scanner.nextLine();
        new Helper().clearConsole();
        System.out.println("OPEN FULL CONSOLE SIZE!!!");
        System.out.println();
        System.out.println("Press ENTER to continue...");
        scanner.nextLine();
        new Greetings().sayHelloStartGame();
        Chessboard myChessboard = new Chessboard();
        DrowBoard drowBoard = new DrowBoard();
        while (myChessboard.getGameRunning()) {
            drowBoard.drawBoard(myChessboard.getChessboard());
            myChessboard.move();
        }

    }
}
