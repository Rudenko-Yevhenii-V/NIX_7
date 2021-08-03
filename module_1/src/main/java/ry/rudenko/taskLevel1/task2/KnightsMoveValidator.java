package ry.rudenko.taskLevel1.task2;

public class KnightsMoveValidator {
  private  int nowRow;
  private  int needRow;
  private  int nowCol;
  private  int needCol;

  public boolean isPossiblePath() {
    return ((Math.abs(nowRow - needRow) == 2 && Math.abs(nowCol
        - needCol) == 1)
        || (Math.abs(nowRow - needRow) == 1 && Math.abs(nowCol
        - needCol) == 2));
  }

  public KnightsMoveValidator(int nowRow,  int nowCol, int needRow, int needCol) {
    this.nowRow = nowRow;
    this.needRow = needRow;
    this.nowCol = nowCol;
    this.needCol = needCol;
  }
}
