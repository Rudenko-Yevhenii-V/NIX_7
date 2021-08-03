package ry.rudenko.taskLevel1.task2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ry.rudenko.taskLevel1.task1.UniqueCharactersFromArray;

public class KnightsMoveValidatorTest {

  @Test
  public void isPossiblePath() {
    List<Boolean> actual = new ArrayList<>();
    List<Boolean> expected = new ArrayList<>();
    boolean actual1 = new KnightsMoveValidator(1, 1, 3, 2).isPossiblePath();
    boolean expected1 = true;
    boolean actual2 = new KnightsMoveValidator(1, 1, 2, 3).isPossiblePath();
    boolean expected2 = true;
    boolean actual3 = new KnightsMoveValidator(1, 1, 3, 0).isPossiblePath();
    boolean expected3 = true;
    boolean actual4 = new KnightsMoveValidator(1, 1, 2, -1).isPossiblePath();
    boolean expected4 = true;
    boolean actual5 = new KnightsMoveValidator(1, 1, 0, -1).isPossiblePath();
    boolean expected5 = true;
    boolean actual6 = new KnightsMoveValidator(1, 1, -1, 0).isPossiblePath();
    boolean expected6 = true;
    boolean actual7 = new KnightsMoveValidator(1, 1, -1, 2).isPossiblePath();
    boolean expected7 = true;
    boolean actual8 = new KnightsMoveValidator(1, 1, 0, 3).isPossiblePath();
    boolean expected8 = true;
    boolean actual9 = new KnightsMoveValidator(1, 1, 1, 3).isPossiblePath();
    boolean expected9 = false;
    boolean actual10 = new KnightsMoveValidator(1, 1, 0, 2).isPossiblePath();
    boolean expected10 = false;
    actual.add(actual1);
    expected.add(expected1);
    actual.add(actual2);
    expected.add(expected2);
    actual.add(actual3);
    expected.add(expected3);
    actual.add(actual4);
    expected.add(expected4);
    actual.add(actual5);
    expected.add(expected5);
    actual.add(actual6);
    expected.add(expected6);
    actual.add(actual7);
    expected.add(expected7);
    actual.add(actual8);
    expected.add(expected8);
    actual.add(actual9);
    expected.add(expected9);
    actual.add(actual10);
    expected.add(expected10);

    assertEquals(actual, expected);
  }
}