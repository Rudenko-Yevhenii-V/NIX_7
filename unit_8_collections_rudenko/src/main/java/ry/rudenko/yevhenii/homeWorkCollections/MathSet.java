package ry.rudenko.yevhenii.homeWorkCollections;


import java.util.Arrays;
import java.util.Objects;


public class MathSet implements IMathSet {

  private int capacity = 0;
  private Number[] numbers = new Number[capacity];

  public MathSet() {
  }

  public MathSet(int capacity) {
    this.capacity = capacity;
    numbers = new Number[capacity];
  }

  public MathSet(Number[] numbers) {
    this.numbers = leaveUniqueElements(numbers);
  }

  public MathSet(Number[]... numbers) {
    Number[] result = numbers[0];
    result = concatAll(result, numbers);
    this.numbers = leaveUniqueElements(result);
  }

  public MathSet(MathSet numbers) {
    this.numbers = leaveUniqueElements(numbers.getNumbers());
  }

  public MathSet(MathSet... numbers) {
    Number[] result = numbers[0].getNumbers();
    for (MathSet number : numbers) {
      result = concatAll(result, number.getNumbers());
    }
    this.numbers = leaveUniqueElements(result);
  }

  @Override
  public void add(Number n) {
    int count = numbers.length;
    count++;
    numbers = Arrays.copyOf(numbers, count);
    numbers[count - 1] = n;
    numbers = leaveUniqueElements(numbers);
  }

  @Override
  public void add(Number... n) {
    for (int i = 0; i < n.length; i++) {
      int count = numbers.length;
      count++;
      numbers = Arrays.copyOf(numbers, count);
      numbers[count - 1] = n[i];
      numbers = leaveUniqueElements(numbers);
    }
  }

  @Override
  public void join(MathSet ms) {
    this.numbers = concatAll(this.numbers, ms.getNumbers());
  }

  @Override
  public void join(MathSet... ms) {
    for (MathSet m : ms) {
      this.numbers = concatAll(this.numbers, m.getNumbers());
    }
  }

  @Override
  public void intersection(MathSet ms) {
    if (this.numbers.length == 0 || ms.getNumbers().length == 0) {
      this.numbers = new Number[0];
      return;
    }
    Number[] first = this.numbers;
    Number[] second = ms.getNumbers();
    Number[] result = new Number[0];
    int count = result.length;
    for (int i = 0; i < first.length; i++) {
      for (int j = 0; j < second.length; j++) {
        if(first[i] == null || second[j] == null){
          if (first[i] == null && second[j] == null){
            count++;
            result = Arrays.copyOf(numbers, count);
            result[count - 1] = first[i];
            result = leaveUniqueElements(numbers);
            continue;
          }
          continue;
        }
        if (first[i].equals(second[j])) {
          count++;
          result = Arrays.copyOf(result, count);
          result[count - 1] = first[i];
          result = leaveUniqueElements(result);
        }
      }
    }
    this.numbers = result;
  }

  @Override
  public void intersection(MathSet... ms) {
    MathSet mS = new MathSet(ms);
    if (this.numbers.length == 0 || mS.getNumbers().length == 0) {
      this.numbers = new Number[0];
      return;
    }
    Number[] first = this.numbers;
    Number[] second = mS.getNumbers();
    Number[] result = new Number[0];
    int count = result.length;
    for (int i = 0; i < first.length; i++) {
      for (int j = 0; j < second.length; j++) {
        if(first[i] == null || second[j] == null){
          if (first[i] == null && second[j] == null){
            count++;
            result = Arrays.copyOf(numbers, count);
            result[count - 1] = first[i];
            result = leaveUniqueElements(numbers);
            continue;
          }
          continue;
        }
        if (first[i].equals(second[j])) {
          count++;
          result = Arrays.copyOf(result, count);
          result[count - 1] = first[i];
          result = leaveUniqueElements(result);
        }
      }
    }
    this.numbers = result;
  }

  @Override
  public void sortDesc() {

  }

  @Override
  public void sortDesc(int firstIndex, int lastIndex) {

  }

  @Override
  public void sortDesc(Number value) {

  }

  @Override
  public void sortAsc() {

  }

  @Override
  public void sortAsc(int firstIndex, int lastIndex) {

  }

  @Override
  public void sortAsc(Number value) {

  }

  @Override
  public Number get(int index) {
    return null;
  }

  @Override
  public Number getMax() {
    return null;
  }

  @Override
  public Number getMin() {
    return null;
  }

  @Override
  public Number getAverage() {
    return null;
  }

  @Override
  public Number getMedian() {
    return null;
  }

  @Override
  public Number[] toArray() {
    return new Number[0];
  }

  @Override
  public Number[] toArray(int firstIndex, int lastIndex) {
    return new Number[0];
  }

  @Override
  public void clear() {

  }

  @Override
  public void clear(int firstIndex, int lastIndex) {

  }

  @Override
  public void clear(Number[] numbers) {

  }

  public int getCapacity() {
    return numbers.length;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public Number[] getNumbers() {
    return numbers;
  }

  public void setNumbers(Number[] numbers) {
    this.numbers = numbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MathSet mathSet = (MathSet) o;
    return capacity == mathSet.capacity &&
        Arrays.equals(numbers, mathSet.numbers);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(capacity);
    result = 31 * result + Arrays.hashCode(numbers);
    return result;
  }

  @SafeVarargs
  public static <T> T[] concatAll(T[] first, T[]... rest) {
    int totalLength = first.length;
    for (T[] array : rest) {
      totalLength += array.length;
    }
    T[] result = Arrays.copyOf(first, totalLength);
    int offset = first.length;
    for (T[] array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }

  public Number[] leaveUniqueElements(Number[] numbers) {
    int count = 1;
    boolean isHaveNull = false;
    Number[] resultNumbers = new Number[1];
    resultNumbers[0] = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      boolean isHaveElement = false;
      if (isHaveNull) {
        if (numbers[i] == null) {
          continue;
        }
      }
      for (int j = 0; j < resultNumbers.length; j++) {
        if (!isHaveNull) {
          if (numbers[i] == null) {
            isHaveNull = true;
          }
        }
        if (!(numbers[i] == null || resultNumbers[j] == null)) {
          if (numbers[i].equals(resultNumbers[j])) {
            isHaveElement = true;
          }
        }
      }
      if (!isHaveElement) {
        count++;
        resultNumbers = Arrays.copyOf(resultNumbers, count);
        resultNumbers[count - 1] = numbers[i];
      }
    }
    return resultNumbers;
  }

  @Override
  public String toString() {
    return "MathSet{" +
        "capacity=" + capacity +
        ", numbers=" + Arrays.toString(numbers) +
        '}';
  }
}
