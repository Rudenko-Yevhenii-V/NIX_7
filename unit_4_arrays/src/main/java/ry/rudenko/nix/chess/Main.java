package ry.rudenko.nix.chess;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import ry.rudenko.nix.chess.game.Chessboard;
import ry.rudenko.nix.chess.game.DrowBoard;
import ry.rudenko.nix.chess.game.Greetings;
import ry.rudenko.nix.chess.game.Sound;
import ry.rudenko.nix.chess.game.myColors.MyColors;


public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    for (String arg : args) {
      new MyColors().setShell(arg);
    }
//    new Greetings().sayHelloStartGame();

    Chessboard myChessboard = new Chessboard();
    DrowBoard drowBoard = new DrowBoard();
    while (myChessboard.getGameRunning()) {
      drowBoard.drawBoard(myChessboard.getChessboard());
      myChessboard.move();
    }

  }
}
