package ry.rudenko.nix.chess.figures;

import ry.rudenko.nix.chess.game.DrowBoard;
import ry.rudenko.nix.chess.game.myColors.MyColors;

public class Pawn extends Figure {

  public Pawn(boolean isWhite) {
    super(isWhite);
  }

  @Override
  public String draw() {
    if(myColors.getShell().equals("shell")){
      return new DrowBoard().drawColorFigures("\u265f", isWhite);
    }else{
      if (isWhite) {
        return new DrowBoard().drawColorFigures("♙", isWhite);
      } else {
        return new DrowBoard().drawColorFigures("\u265f", isWhite);
      }
    }
  }

  @Override
  public boolean isMoveValid(int nowRow, int nowCol, int needRow, int needCol) {

    if (this.isWhite) {
      return (((nowCol == needCol) && nowRow == (needRow + 1))
          || ((nowRow == 6) && (nowCol == needCol) && (nowRow == (needRow + 2)))
          || ((nowRow == (needRow + 1))
          && (Math.abs(nowCol - needCol) == 1)));
    } else {
      return (((nowCol == needCol) && nowRow == (needRow - 1))
          || ((nowRow == 1) && (nowCol == needCol) && (nowRow == (needRow - 2)))
          || ((nowRow == (needRow - 1))
          && (Math.abs(nowCol - needCol) == 1)));
    }
  }
}
