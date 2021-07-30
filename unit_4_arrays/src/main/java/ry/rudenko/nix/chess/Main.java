package ry.rudenko.nix.chess;

import ry.rudenko.nix.chess.game.Chessboard;
import ry.rudenko.nix.chess.game.DrowBoard;
import ry.rudenko.nix.chess.game.Greetings;
import ry.rudenko.nix.chess.game.Helper;
import ry.rudenko.nix.chess.game.myColors.MyColors;

import java.awt.*;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String[] args) throws UnsupportedEncodingException {
//    for (String arg : args) {
//      new MyColors().setShell(arg);
//      new Helper().setShell(arg);
//    }
//  //  new Greetings().sayHelloStartGame();
//    Chessboard myChessboard = new Chessboard();
//    DrowBoard drowBoard = new DrowBoard();
//    while (myChessboard.getGameRunning()) {
//      drowBoard.drawBoard(myChessboard.getChessboard());
//      myChessboard.move();
//    }

//    Charset utf8 = Charset.forName("UTF-8");
//    Charset def = Charset.defaultCharset();
//
//    String charToPrint = "\u265F";
//
//    byte[] bytes = charToPrint.getBytes("UTF-8");
//
//    String message = new String(bytes , def.name());
//    System.out.println(message);
//    PrintStream printStream = new PrintStream(System.out, true, utf8.name());
//    printStream.println(message);
//    PrintWriter printWriter = new PrintWriter(System.out,true);
//    char aa = '\u265f';
//    printWriter.println("aa = " + aa);
//    printWriter.println("aa = " + aa);
//    printWriter.println("aa = " + aa);
//    System.out.println("  |\\_\n" +
//            "  /  .\\_\n" +
//            " |   ___)\n" +
//            " |    \\\n" +
//            " |  =  |\n" +
//            " /_____\\\n" +
//            "[_______]");

    String unicodeMessage =
            "\u7686\u3055\u3093\u3001\u3053\u3093\u306b\u3061\u306f";

    PrintStream out = new PrintStream(System.out, true, "UTF-8");
    out.println(unicodeMessage);


  }
}
