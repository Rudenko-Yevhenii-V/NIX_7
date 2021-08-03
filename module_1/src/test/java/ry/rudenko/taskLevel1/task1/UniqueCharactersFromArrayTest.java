package ry.rudenko.taskLevel1.task1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class UniqueCharactersFromArrayTest {

  @Test
  public void returnTheNumberOfUniqueCharactersFromArray() {
    List<Integer> actual = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();
    int[] numbers1 = {1, 4, 5, 1, 1, 3};
    int expected1 = 4;
    int[] numbers2 = {1};
    int expected2 = 1;

    actual.add(new UniqueCharactersFromArray()
        .ReturnTheNumberOfUniqueCharactersFromArray(numbers1));
    expected.add(expected1);
    actual.add(new UniqueCharactersFromArray()
        .ReturnTheNumberOfUniqueCharactersFromArray(numbers2));
    expected.add(expected2);

    assertEquals(actual, expected);
  }
}