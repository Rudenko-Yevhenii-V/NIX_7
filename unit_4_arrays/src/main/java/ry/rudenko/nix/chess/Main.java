package ry.rudenko.nix.chess;

import ry.rudenko.nix.chess.game.Chessboard;
import ry.rudenko.nix.chess.game.DrowBoard;
import ry.rudenko.nix.chess.game.Helper;
import ry.rudenko.nix.chess.game.utilColors.Colors;

import java.io.*;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
//    for (String arg : args) {
//      new MyColors().setShell(arg);
//      new Helper().setShell(arg);
//    }
        new Colors().setShell("shell");
 //new Greetings().sayHelloStartGame();
    Chessboard myChessboard = new Chessboard();
    DrowBoard drowBoard = new DrowBoard();
    while (myChessboard.getGameRunning()) {
      drowBoard.drawBoard(myChessboard.getChessboard());
      myChessboard.move();
    }

//        String s = "  |\\_ \n" +
//                "  /  .\\_\n" +
//                " |   ___)\n" +
//                " |    \\\n" +
//                " |  =  |\n" +
//                " /_____\\\n" +
//                "[_______]";
//
//        String fugures = "                              .      +\n" +
//                "                              ww     ww\n" +
//                "     II       ()    _,,       ()     ()\n" +
//                "     )(       )(   \"-=\\~      )(     )(       ()\n" +
//                "     )(       )(     )(       )(     )(       )(\n" +
//                "ejm /__\\     /__\\   /__\\     /__\\   /__\\     /__\\";
//        List<Figure> list = new LinkedList<>();
//        list.add(new Rook(false));
//        list.add(new Knight(false));
//        list.add(new Bishop(false));
//        list.add(new Queen(false));
//        list.add(new King(false));
//        list.add(new Bishop(false));
//        list.add(new Knight(false));
//        list.add(new Rook(false));
//        list.add(new Rook(true));

//        String paw1 = "        ";
//        String paw2 = "        ";
//        String paw3 = "   II   ";
//        String paw4 = "   )(   ";
//        String paw5 = "   )(   ";
//        String paw6 = "  /__\\  ";
//
//        String[] pawn = {paw1, paw2, paw3, paw4, paw5, paw6};



//            System.out.println(paw1 + paw1 + paw1 + paw1 + paw1 + paw1 + paw1 + paw1);
//        System.out.println(paw2 + paw2 + paw2 + paw2 + paw2 + paw2 + paw2 + paw2);
//        System.out.println(paw3 + paw3 + paw3 + paw3 + paw3 + paw3 + paw3 + paw3);
//        System.out.println(paw4 + paw4 + paw4 + paw4 + paw4 + paw4 + paw4 + paw4);
//        System.out.println(paw5 + paw5 + paw5 + paw5 + paw5 + paw5 + paw5 + paw5);
//        System.out.println(paw6 + paw6 + paw6 + paw6 + paw6 + paw6 + paw6 + paw6);
//        String pawn1 = "             ";
//        String pawn2 = "             ";
//        String pawn3 = "             ";
//        String pawn4 = "             ";
//        String pawn5 = "             ";
//        String pawn6 = "             ";
//        String pawn7 = "             ";
//        String pawn8 = "     __     ";
//        String pawn9 = "     /  \\   ";
//        String pawn10 = "     \\__/   ";
//        String pawn11 = "    /____\\  ";
//        String pawn12 = "    |  |    ";
//        String pawn13 = "    |__|    ";
//        String pawn14 = "   (====)   ";
//        String pawn15 = "   }===={   ";
//        String pawn16 = "  (______)  ";
//        System.out.println(pawn1 + pawn1 + pawn1 + pawn1 + pawn1 + pawn1 + pawn1 + pawn1);
//        System.out.println(pawn2 + pawn2 + pawn2 + pawn2 + pawn2 + pawn2 + pawn2 + pawn2);
//        System.out.println(pawn3 + pawn3 + pawn3 + pawn3 + pawn3 + pawn3 + pawn3 + pawn3);
//        System.out.println(pawn4 + pawn4 + pawn4 + pawn4 + pawn4 + pawn4 + pawn4 + pawn4);
//        System.out.println(pawn5 + pawn5 + pawn5 + pawn5 + pawn5 + pawn5 + pawn5 + pawn5);
//        System.out.println(pawn6 + pawn6 + pawn6 + pawn6 + pawn6 + pawn6 + pawn6 + pawn6);
//        System.out.println(pawn7 + pawn7 + pawn7 + pawn7 + pawn7 + pawn7 + pawn7 + pawn7);
//        System.out.println(pawn8 + pawn8 + pawn8 + pawn8 + pawn8 + pawn8 + pawn8 + pawn8);
//        System.out.println(pawn9 + pawn9 + pawn9 + pawn9 + pawn9 + pawn9 + pawn9 + pawn9);
//        System.out.println(pawn10 + pawn10 + pawn10 + pawn10 + pawn10 + pawn10 + pawn10);
//        System.out.println(pawn11 + pawn11 + pawn11 + pawn11 + pawn11 + pawn11 + pawn11);
//        System.out.println(pawn12 + pawn12 + pawn12 + pawn12 + pawn12 + pawn12 + pawn12);
//        System.out.println(pawn13 + pawn13 + pawn13 + pawn13 + pawn13 + pawn13 + pawn13);
//        System.out.println(pawn14 + pawn14 + pawn14 + pawn14 + pawn14 + pawn14 + pawn14);
//        System.out.println(pawn15 + pawn15 + pawn15 + pawn15 + pawn15 + pawn15 + pawn15);
//        System.out.println(pawn16 + pawn16 + pawn16 + pawn16 + pawn16 + pawn16 + pawn16);


    }
}
