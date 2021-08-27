package ry.rudenko.yevhenii.homeWorkCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MathSetTest {

  @Test
  void constrEmpty() {
    MathSet mathSet = new MathSet();
    Assertions.assertEquals(mathSet.getNumbers().length, 0);
  }

  @Test
  void constrCapacity() {
    MathSet mathSet = new MathSet(10);
    Assertions.assertEquals(mathSet.getNumbers().length, 10);
  }

  @Test
  void constrNumbers() {
    Number[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 2345, 5, 11};
    MathSet mathSet = new MathSet(numbers);
    Number[] expectedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 2345, 11};
    for (int i = 0; i < mathSet.getNumbers().length; i++) {
      Assertions.assertEquals(mathSet.getNumbers()[i], expectedNumbers[i]);
    }
  }

  @Test
  void constrNumbersVarargs() {
    Number[] numbers1 = {11, 12, 13, 14, 15, 16, 17, 18, 18, null};
    Number[] numbers2 = {21, 22, 23, 24, 25, 26, 27, 28, 28, null};
    Number[] numbers3 = {31, 32, 33, 34, 35, 36, 37, 38, 38, null};
    MathSet mathSet = new MathSet(numbers1, numbers2, numbers3);
    Number[] expectedNumbers = {11, 12, 13, 14, 15, 16, 17, 18, null,
        21, 22, 23, 24, 25, 26, 27, 28, 31, 32, 33, 34, 35, 36, 37, 38};
    for (int i = 0; i < mathSet.getNumbers().length; i++) {
      Assertions.assertArrayEquals(mathSet.getNumbers(), expectedNumbers);
    }
  }

  @Test
  void constrMathSet() {
    Number[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 2345, 5, 11};
    MathSet mathSet1 = new MathSet(numbers);
    MathSet mathSet2 = new MathSet(mathSet1);
    Number[] expectedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 2345, 11};
    for (int i = 0; i < mathSet2.getNumbers().length; i++) {
      Assertions.assertEquals(mathSet2.getNumbers()[i], expectedNumbers[i]);
    }
  }

  @Test
  void constrMathSetsVarargs() {
    Number[] numbers1 = {11, 12, 13, 14, 15, 16, 17, 18, 18, null};
    Number[] numbers2 = {21, 22, 23, 24, 25, 26, 27, 28, 28, null};
    Number[] numbers3 = {31, 32, 33, 34, 35, 36, 37, 38, 38, null};
    MathSet mathSet1 = new MathSet(numbers1);
    MathSet mathSet2 = new MathSet(numbers2);
    MathSet mathSet3 = new MathSet(numbers3);

    MathSet mathSet = new MathSet(mathSet1, mathSet2, mathSet3);
    Number[] expectedNumbers = {11, 12, 13, 14, 15, 16, 17, 18, null,
        21, 22, 23, 24, 25, 26, 27, 28, 31, 32, 33, 34, 35, 36, 37, 38};
    for (int i = 0; i < mathSet.getNumbers().length; i++) {
      Assertions.assertArrayEquals(mathSet.getNumbers(), expectedNumbers);
    }
  }

  @Test
  void add() {
    MathSet mathSet = new MathSet();
    mathSet.add(7);
    mathSet.add(7);
    mathSet.add(3);
    mathSet.add((Number) null);
    mathSet.add((Number) null);
    Number[] expectedNumbers = {7, 3, null};
    Assertions.assertArrayEquals(mathSet.getNumbers(), expectedNumbers);
  }


  @Test
  void testAddVarargs() {
    MathSet mathSet = new MathSet();
    mathSet.add(7, 7, 3, null, null);
    Number[] expectedNumbers = {7, 3, null};
    Assertions.assertArrayEquals(mathSet.getNumbers(), expectedNumbers);
  }

  @Test
  void join() {
    MathSet mathSetMain = new MathSet();
    MathSet mathSet1 = new MathSet();
    mathSet1.add(7, 7, 3, null, null);
    mathSetMain.join(mathSet1);
    Number[] expectedNumbers1 = {7, 3, null};
    Assertions.assertArrayEquals(mathSetMain.getNumbers(), expectedNumbers1);
    MathSet mathSet2 = new MathSet();
    mathSet2.add(10, 11, 11, 12);
    mathSetMain.join(mathSet2);
    Number[] expectedNumbers2 = {7, 3, null, 10, 11, 12};
    Assertions.assertArrayEquals(mathSetMain.getNumbers(), expectedNumbers2);
  }

  @Test
  void testJoinVarargs() {
    MathSet mathSetMain = new MathSet();
    MathSet mathSet1 = new MathSet();
    mathSet1.add(7, 7, 3, null, null);
    MathSet mathSet2 = new MathSet();
    mathSet2.add(11, 12, 12, 13);
    MathSet mathSet3 = new MathSet();
    mathSet3.add(1000, 9999);
    mathSetMain.join(mathSet1, mathSet2, mathSet3);
    Number[] expectedNumbers1 = {7, 3, null, 11, 12, 13, 1000, 9999};
    Assertions.assertArrayEquals(mathSetMain.getNumbers(), expectedNumbers1);
  }

  @Test
  void intersection() {
    MathSet mathSetMain = new MathSet();
    MathSet mathSet1 = new MathSet();
    mathSet1.add(7, 7, 3, null, null);
    MathSet mathSet2 = new MathSet();
    mathSet2.add(11, 12, 12, 13, 7, 3, null);
    mathSetMain.intersection(mathSet1);
    Assertions.assertEquals(0, mathSetMain.getNumbers().length);
    mathSet1.intersection(mathSet2);
    Number[] expectedNumbers1 = {7, 3, null};
    Assertions.assertArrayEquals(expectedNumbers1, mathSet1.getNumbers());
  }

  @Test
  void testIntersectionVararg() {
    MathSet mathSet1 = new MathSet();
    mathSet1.add(7, 7, 3, 12, null, null);
    MathSet mathSet2 = new MathSet();
    mathSet2.add(11, 12, 12, 13, 7, 3, null);
    MathSet mathSet3 = new MathSet();
    mathSet3.add( 7, 3, null, 123,234234);
    MathSet mathSet4 = new MathSet();
    mathSet4.add(11, 12, 12, 13, 7, 3, 3456435);
    mathSet1.intersection(mathSet2, mathSet3, mathSet4);
    Number[] expectedNumbers1 = {7, 3,12, null};
    Assertions.assertArrayEquals(expectedNumbers1, mathSet1.getNumbers());
  }

  @Test
  void sortDesc() {
  }

  @Test
  void testSortDesc() {
  }

  @Test
  void testSortDesc1() {
  }

  @Test
  void sortAsc() {
  }

  @Test
  void testSortAsc() {
  }

  @Test
  void testSortAsc1() {
  }

  @Test
  void get() {
  }

  @Test
  void getMax() {
  }

  @Test
  void getMin() {
  }

  @Test
  void getAverage() {
  }

  @Test
  void getMedian() {
  }

  @Test
  void toArray() {
  }

  @Test
  void testToArray() {
  }

  @Test
  void clear() {
  }

  @Test
  void testClear() {
  }

  @Test
  void testClear1() {
  }

  @Test
  void leaveUniqueElements() {
    Number[] numbers = {1, 2, 4, 3, 5, 4, 3, 3, 5, 3, 5, 2, null, null, null};
    MathSet mathSet = new MathSet();
    final Number[] numbersResult = mathSet.leaveUniqueElements(numbers);
    Number[] expectedNumbers = {1, 2, 4, 3, 5, null};
    Assertions.assertArrayEquals(numbersResult, expectedNumbers);

  }

}