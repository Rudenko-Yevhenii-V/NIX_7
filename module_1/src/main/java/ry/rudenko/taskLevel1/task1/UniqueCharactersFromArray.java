package ry.rudenko.taskLevel1.task1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueCharactersFromArray {

  public int ReturnTheNumberOfUniqueCharactersFromArray(int[] numbers) {
    Set<Integer> set = new HashSet<>();
    int uniqueNumbers = 0;
    for (int number : numbers
    ) {
      set.add(number);
    }
    uniqueNumbers = set.size();
    return uniqueNumbers;
  }
}
