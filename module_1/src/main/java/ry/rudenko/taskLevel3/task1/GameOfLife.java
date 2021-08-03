package ry.rudenko.taskLevel3.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {

  private int rows;
  private int colums;
  private boolean runOn = true;
  private boolean[][] boardOfLife;
  boolean[][] bufferOfBoardOfLife;
  private boolean isAlive = true;
  private boolean isEmpty = false;

  public GameOfLife(int rows, int colums) {
    this.rows = rows;
    this.colums = colums;
    boardOfLife = new boolean[rows][colums];
    initBoardOfLife();
  }

  public boolean isRunOn() {
    return runOn;
  }

  private void initBoardOfLife() {
    for (int i = 0; i < boardOfLife.length; i++) {
      for (int j = 0; j < boardOfLife[i].length; j++) {
        boardOfLife[i][j] = isEmpty;
      }
    }
  }

  public void setAliveCellToBoardOfLife(int row, int colum) {
    boardOfLife[row][colum] = isAlive;
  }

  public void oneIteration() {

    if (Arrays.deepEquals(bufferOfBoardOfLife, boardOfLife)) {
      runOn = false;
    }
    bufferOfBoardOfLife = copyArrays(boardOfLife);
    for (int i = 0; i < bufferOfBoardOfLife.length; i++) {
      for (int j = 0; j < bufferOfBoardOfLife[i].length; j++) {
        int analyzingNearCellWithAlive = analyzingNearCellWithAlive(bufferOfBoardOfLife, i, j);
        if (bufferOfBoardOfLife[i][j]) {
          if (analyzingNearCellWithAlive < 2) {
            boardOfLife[i][j] = false;
          } else if ((analyzingNearCellWithAlive == 2) || (analyzingNearCellWithAlive == 3)) {
          } else {
            boardOfLife[i][j] = false;
          }
        } else {
          if (analyzingNearCellWithAlive == 3) {
            boardOfLife[i][j] = true;
          }
        }
      }
    }
    System.out.println(printArray(bufferOfBoardOfLife));
  }

  private int analyzingNearCellWithAlive(boolean[][] boardOfLife, int i, int j) {
    List<Boolean> arayOfNearCells = new ArrayList<>();
    int analyzingNearCellWithAlive = 0;
    for (int k = -1; k < 2; k++) {//i
      for (int l = -1; l < 2; l++) {//j
        if (!((k == 0) && (l == 0))) {
          if (!(((i + k) < 0) || ((j + l) < 0) || ((i + k) > rows - 1) || ((j + l) > colums - 1))) {
            arayOfNearCells.add(boardOfLife[i + k][j + l]);
          }
        }
      }
    }
    for (boolean el : arayOfNearCells
    ) {
      if (el) {
        analyzingNearCellWithAlive += 1;
      }
    }
    return analyzingNearCellWithAlive;
  }

  public boolean[][] copyArrays(boolean[][] original) {
    boolean[][] copyExempl = new boolean[rows][colums];
    for (int i = 0; i < original.length; i++) {
      for (int j = 0; j < original[i].length; j++) {
        copyExempl[i][j] = original[i][j];
      }
    }
    return copyExempl;
  }

  public StringBuilder printArray(boolean[][] bufferOfBoardOfLife) {
    StringBuilder printArrayText = new StringBuilder();
    printArrayText.append("  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17\n");
    for (int i = 0; i < bufferOfBoardOfLife.length; i++) {
      printArrayText.append(i);
      for (int j = 0; j < bufferOfBoardOfLife[i].length; j++) {
        if (boardOfLife[i][j]) {
          printArrayText.append(" * ");
        } else {
          printArrayText.append(" - ");
        }
      }
      printArrayText.append("\n");

    }
    return printArrayText;
  }
}
