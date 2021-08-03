package ry.rudenko.taskLevel1.task3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ry.rudenko.taskLevel1.task2.KnightsMoveValidator;

public class AreaOfTriangleTest {

  @Test
  public void calculateAreaOfTriangleFromVertices() {
    List<Long> actual = new ArrayList<>();
    List<Long> expected = new ArrayList<>();
    long actual1 = new AreaOfTriangle().CalculateAreaOfTriangleFromVertices(1, 5, 6, -4, -2, 1);
    long expected1 = 23;
    actual.add(actual1);
    expected.add(expected1);
    long actual2 = new AreaOfTriangle().CalculateAreaOfTriangleFromVertices(5, 3, 3, 5, -2, 2);
    long expected2 = 8;
    actual.add(actual2);
    expected.add(expected2);
    assertEquals(actual, expected);
  }
}