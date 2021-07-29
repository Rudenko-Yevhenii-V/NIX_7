package ry.rudenko.nix.chess;

import ry.rudenko.nix.chess.game.Chessboard;
import ry.rudenko.nix.chess.game.DrowBoard;
import ry.rudenko.nix.chess.game.Greetings;
import ry.rudenko.nix.chess.game.myColors.MyColors;

public class Main {

  public static void main(String[] args) {
    for (String arg : args) {
      new MyColors().setShell(arg);
    }
   // new Greetings().sayHelloStartGame();
    Chessboard myChessboard = new Chessboard();
    DrowBoard drowBoard = new DrowBoard();
    while (myChessboard.getGameRunning()) {
      drowBoard.drawBoard(myChessboard.getChessboard());
      myChessboard.move();
    }

  }
}
