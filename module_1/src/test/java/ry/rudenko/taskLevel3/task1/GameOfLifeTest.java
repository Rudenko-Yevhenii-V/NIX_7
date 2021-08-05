package ry.rudenko.taskLevel3.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {
  GameOfLife gameOfLife = new GameOfLife(3, 3, false);
  boolean[][] testArray = new boolean[3][3];

  @Test
  public void copyArrays() {
    boolean[][] actual = gameOfLife.copyArrays(initArray(testArray));
    boolean[][] expected = initArray(testArray);
    assertArrayEquals(actual, expected);
  }

  @Test
  public void printArray() {

    int actual = gameOfLife.printArray((initArray(testArray))).length();
    int expected = 89;
    assertEquals(actual, expected);
  }
  public boolean[][] initArray(boolean[][] testArray){
    for (int i = 0; i < testArray.length; i++) {
      for (int j = 0; j < testArray[i].length; j++) {
        testArray[i][j] = true;
      }
    }
    return testArray;
  }
}