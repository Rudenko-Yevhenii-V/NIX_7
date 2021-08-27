package ry.rudenko.yevhenii.homeWorkCollections;


import ry.rudenko.yevhenii.collections.CHashSet;

public interface IMathSet {

  public void add(Number n);

  public void add(Number... n);

  public void join(MathSet ms);

  public void join(MathSet... ms);
  public void intersection(MathSet ms);
  public void intersection (MathSet ... ms);

  public void sortDesc();

  public void sortDesc(int firstIndex, int lastIndex);

  public void sortDesc(Number value);

  public void sortAsc();

  public void sortAsc(int firstIndex, int lastIndex);

  public void sortAsc(Number value);

  public Number get(int index);

  public Number getMax();

  public Number getMin();

  public Number getAverage();

  public Number getMedian();

  public Number[] toArray();

  public Number[] toArray(int firstIndex, int lastIndex);

  public void clear();

  public void clear(int firstIndex, int lastIndex);

  public void clear(Number[] numbers);
}
