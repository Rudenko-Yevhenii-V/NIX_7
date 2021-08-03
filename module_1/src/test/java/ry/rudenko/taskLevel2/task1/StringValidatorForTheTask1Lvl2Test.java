package ry.rudenko.taskLevel2.task1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ry.rudenko.taskLevel1.task2.KnightsMoveValidator;

public class StringValidatorForTheTask1Lvl2Test {

  @Test
  public void isValid() {
    List<Boolean> actual = new ArrayList<>();
    List<Boolean> expected = new ArrayList<>();
    boolean actual1 = new StringValidatorForTheTask1Lvl2(
        "(){{{}}[]])").isValid();
    boolean expected1 = false;
    actual.add(actual1);
    expected.add(expected1);
    boolean actual2 = new StringValidatorForTheTask1Lvl2(
        "").isValid();
    boolean expected2 = true;
    actual.add(actual2);
    expected.add(expected2);
    boolean actual3 = new StringValidatorForTheTask1Lvl2(
        "(((").isValid();
    boolean expected3 = false;
    actual.add(actual3);
    expected.add(expected3);
    boolean actual4 = new StringValidatorForTheTask1Lvl2(
        "'(', ')', '{', '}', '[' и ']',").isValid();
    boolean expected4 = true;
    actual.add(actual4);
    expected.add(expected4);
    assertEquals(actual, expected);
  }

}