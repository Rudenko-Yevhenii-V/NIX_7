package ry.rudenko.yevhenii.homeWorkCollections;

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
    numbers = copyOf(numbers, count);
    numbers[count - 1] = n;
    numbers = leaveUniqueElements(numbers);
  }

  @Override
  public void add(Number... n) {
    for (Number number : n) {
      int count = numbers.length;
      count++;
      numbers = copyOf(numbers, count);
      numbers[count - 1] = number;
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
    for (Number number : first) {
      for (Number value : second) {
        if (number == null || value == null) {
          if (number == null && value == null) {
            count++;
            result = copyOf(numbers, count);
            result[count - 1] = number;
            result = leaveUniqueElements(numbers);
            continue;
          }
          continue;
        }
        if (number.equals(value)) {
          count++;
          result = copyOf(result, count);
          result[count - 1] = number;
          result = leaveUniqueElements(result);
        }
      }
    }
    this.numbers = result;
  }

  private Number[] copyOf(Number[] numbers, int count) {
    Number[] buffer = new Number[count];
    for (int i = 0; i < numbers.length; i++) {
      buffer[i] = numbers[i];
    }
    return buffer;
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
    for (Number value : first) {
      for (Number number : second) {
        if (value == null || number == null) {
          if (value == null && number == null) {
            count++;
            result = copyOf(numbers, count);
            result[count - 1] = value;
            result = leaveUniqueElements(numbers);
            continue;
          }
          continue;
        }
        if (value.equals(number)) {
          count++;
          result = copyOf(result, count);
          result[count - 1] = value;
          result = leaveUniqueElements(result);
        }
      }
    }
    this.numbers = result;
  }

  @Override
  public void sortDesc() {
    numbers = leaveUniqueElements(numbers);
    boolean isSorted = false;
    Number buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == null) {
          numbers[i] = 1234123499;
        }
      }
      for (int i = 0; i < numbers.length - 1; i++) {
        if ((Integer) numbers[i] < (Integer) numbers[i + 1]) {
          isSorted = false;
          buf = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = buf;
        }
      }
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i].equals(1234123499)) {
          numbers[i] = null;
        }
      }
    }
  }

  @Override
  public void sortDesc(int firstIndex, int lastIndex) {
    int counter = 0;
    Number[] buffer = new Number[lastIndex - firstIndex];
    for (int i = 0; i < lastIndex - firstIndex; i++) {
      buffer[counter] = numbers[firstIndex - 1 + i];
      counter++;
    }
    numbers = buffer;
    boolean isSorted = false;
    Number buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == null) {
          numbers[i] = 1234123499;
        }
      }
      for (int i = 0; i < numbers.length - 1; i++) {
        if ((Integer) numbers[i] < (Integer) numbers[i + 1]) {
          isSorted = false;
          buf = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = buf;
        }
      }
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i].equals(1234123499)) {
          numbers[i] = null;
        }
      }
    }
  }

  @Override
  public void sortDesc(Number value) {
    int counter = 0;
    int index = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i].equals(value)) {
        index = i;
        break;
      }
    }
    Number[] buffer = new Number[numbers.length - index + 1];
    for (int i = 0; i < buffer.length; i++) {
      buffer[counter] = numbers[index - 1 + i];
      counter++;
    }
    numbers = buffer;
    boolean isSorted = false;
    Number buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == null) {
          numbers[i] = 1234123499;
        }
      }
      for (int i = 0; i < numbers.length - 1; i++) {
        if ((Integer) numbers[i] < (Integer) numbers[i + 1]) {
          isSorted = false;
          buf = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = buf;
        }
      }
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i].equals(1234123499)) {
          numbers[i] = null;
        }
      }
    }
  }

  @Override
  public void sortAsc() {
    numbers = leaveUniqueElements(numbers);
    boolean isSorted = false;
    Number buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == null) {
          numbers[i] = 1234123499;
        }
      }
      for (int i = 0; i < numbers.length - 1; i++) {
        if ((Integer) numbers[i] > (Integer) numbers[i + 1]) {
          isSorted = false;
          buf = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = buf;
        }
      }
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i].equals(1234123499)) {
          numbers[i] = null;
        }
      }
    }
  }

  @Override
  public void sortAsc(int firstIndex, int lastIndex) {
    int counter = 0;
    Number[] buffer = new Number[lastIndex - firstIndex];
    for (int i = 0; i < lastIndex - firstIndex; i++) {
      buffer[counter] = numbers[firstIndex - 1 + i];
      counter++;
    }
    numbers = buffer;
    boolean isSorted = false;
    Number buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == null) {
          numbers[i] = 1234123499;
        }
      }
      for (int i = 0; i < numbers.length - 1; i++) {
        if ((Integer) numbers[i] > (Integer) numbers[i + 1]) {
          isSorted = false;
          buf = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = buf;
        }
      }
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i].equals(1234123499)) {
          numbers[i] = null;
        }
      }
    }
  }

  @Override
  public void sortAsc(Number value) {
    int counter = 0;
    int index = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i].equals(value)) {
        index = i;
        break;
      }
    }
    Number[] buffer = new Number[numbers.length - index + 1];
    for (int i = 0; i < buffer.length; i++) {
      buffer[counter] = numbers[index - 1 + i];
      counter++;
    }
    numbers = buffer;
    boolean isSorted = false;
    Number buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == null) {
          numbers[i] = 1234123499;
        }
      }
      for (int i = 0; i < numbers.length - 1; i++) {
        if ((Integer) numbers[i] > (Integer) numbers[i + 1]) {
          isSorted = false;
          buf = numbers[i];
          numbers[i] = numbers[i + 1];
          numbers[i + 1] = buf;
        }
      }
      for (int i = 0; i < numbers.length; i++) {
        if (numbers[i].equals(1234123499)) {
          numbers[i] = null;
        }
      }
    }
  }

  @Override
  public Number get(int index) {
    return numbers[index];
  }

  @Override
  public Number getMax() {
    Number max = numbers[0];
    for (Number number : numbers) {
      if (number == null) {
        continue;
      }
      if ((Integer) max < (Integer) number) {
        max = number;
      }
    }
    return max;
  }

  @Override
  public Number getMin() {
    Number min = numbers[0];
    for (Number number : numbers) {
      if (number == null) {
        continue;
      }
      if ((Integer) min > (Integer) number) {
        min = number;
      }
    }
    return min;
  }

  @Override
  public Number getAverage() {
    double sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == null) {
        numbers[i] = 0;
      }
    }
    for (Number number : numbers) {
      sum += Double.valueOf((Integer) number);
    }
    return sum / numbers.length;
  }

  @Override
  public Number getMedian() {
    numbers = leaveUniqueElements(numbers);

    double median;
    if (numbers.length % 2 == 0) {
      median =
          ((Integer) numbers[numbers.length / 2] + (Integer) numbers[numbers.length / 2 - 1]) / 2;
    } else {
      median = (Integer) numbers[numbers.length / 2];
    }
    return median;
  }

  @Override
  public Number[] toArray() {
    numbers = leaveUniqueElements(numbers);
    return numbers;
  }

  @Override
  public Number[] toArray(int firstIndex, int lastIndex) {
    int counter = 0;
    Number[] buffer = new Number[lastIndex - firstIndex];
    for (int i = 0; i < lastIndex - firstIndex; i++) {
      buffer[counter] = numbers[firstIndex - 1 + i];
      counter++;
    }
    numbers = buffer;
    numbers = leaveUniqueElements(numbers);
    return numbers;
  }

  @Override
  public void clear() {
    this.numbers = new Number[0];

  }

  @Override
  public MathSet cut(int firstIndex, int lastIndex) {
    Number[] buffer = this.numbers;
    Number[] first = new Number[firstIndex];
    Number[] second = new Number[buffer.length - lastIndex];
    if (first.length >= 0) {
      System.arraycopy(buffer, 0, first, 0, first.length);
    }
    if (second.length >= 0) {
      System.arraycopy(buffer, lastIndex, second, 0, second.length);
    }
    return new MathSet(first, second);
  }

  @Override
  public void clear(Number[] numbers) {
    numbers = leaveUniqueElements(numbers);
    this.numbers = leaveUniqueElements(this.numbers);
    Number[] buffer = new Number[0];
    for (Number number : this.numbers) {
      boolean isHave = true;
      for (Number value : numbers) {
        if (value.equals(number)) {
          isHave = false;
          break;
        }
      }
      if (isHave) {
        int count = buffer.length;
        count++;
        buffer = copyOf(buffer, count);
        buffer[count - 1] = number;
        buffer = leaveUniqueElements(buffer);
      }
    }
    this.numbers = buffer;
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

  @SafeVarargs
  public static <T> T[] concatAll(T[] first, T[]... rest) {
    int totalLength = first.length;
    for (T[] array : rest) {
      totalLength += array.length;
    }
    T[] result = java.util.Arrays.copyOf(first, totalLength);
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
    for (Number number : numbers) {
      boolean isHaveElement = false;
      if (isHaveNull) {
        if (number == null) {
          continue;
        }
      }
      for (Number resultNumber : resultNumbers) {
        if (!isHaveNull) {
          if (number == null) {
            isHaveNull = true;
          }
        }
        if (!(number == null || resultNumber == null)) {
          if (number.equals(resultNumber)) {
            isHaveElement = true;
          }
        }
      }
      if (!isHaveElement) {
        count++;
        resultNumbers = copyOf(resultNumbers, count);
        resultNumbers[count - 1] = number;
      }
    }
    return resultNumbers;
  }
}
