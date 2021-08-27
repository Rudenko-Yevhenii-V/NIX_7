package ry.rudenko.yevhenii.homeWorkCollections;

import com.sun.tools.javac.util.ArrayUtils;
import java.util.Arrays;
import java.util.Objects;
import ry.rudenko.yevhenii.collections.CHashSet;
import ry.rudenko.yevhenii.collections.linked.Backet;

/**
 * @author Rudenko Yevhenii
 * @created 27/08/2021 - 9:42 AM
 * @project NIX_7
 */
public class MathSet implements  IMathSet{
  private int capacity = 1;
  Number[] numbers = new Number[capacity];

  public MathSet() {
    this.capacity = 100;
  }

  public MathSet(int capacity) {
    this.capacity = capacity;
  }

  public MathSet(Number[] numbers) {
    this.numbers = numbers;
  }

  public MathSet(Number[]... numbers) {
   this.numbers = concatAll(this.numbers, numbers);
  }

  public MathSet(MathSet numbers) {
      this.numbers = numbers.getNumbers();
  }

  public MathSet(MathSet... numbers) {
    for (int i = 0; i < numbers.length; i++) {
      this.numbers = concatAll(this.numbers, numbers[i].getNumbers());
    }
  }

  @Override
  public void add(Number n) {

  }

  @Override
  public void add(Number... n) {

  }

  @Override
  public void join(MathSet ms) {

  }

  @Override
  public void join(MathSet... ms) {

  }

  @Override
  public void intersection(MathSet ms) {

  }

  @Override
  public void intersection(MathSet... ms) {

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
    return capacity;
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
  @Override
  public String toString() {
    return "MathSet{" +
        "capacity=" + capacity +
        ", numbers=" + Arrays.toString(numbers) +
        '}';
  }
}
