package ry.rudenko.yevhenii.util.homeWorkCollections;

public interface IMathSet {

  void add(Number n);

  void add(Number... n);

  void join(MathSet ms);

  void join(MathSet... ms);

  void intersection(MathSet ms);

  void intersection(MathSet... ms);

  void sortDesc();

  void sortDesc(int firstIndex, int lastIndex);

  void sortDesc(Number value);

  void sortAsc();

  void sortAsc(int firstIndex, int lastIndex);

  void sortAsc(Number value);

  Number get(int index);

  Number getMax();

  Number getMin();

  Number getAverage();

  Number getMedian();

  Number[] toArray();

  Number[] toArray(int firstIndex, int lastIndex);

  void clear();

  MathSet cut(int firstIndex, int lastIndex);

  void clear(Number[] numbers);
}
