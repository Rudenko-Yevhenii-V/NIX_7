package ry.rudenko.yevhenii.collections;

import java.util.Arrays;
import ry.rudenko.yevhenii.collections.linked.Backet;
import ry.rudenko.yevhenii.homeWorkCollections.IMathSet;

public class CHashSet {

  private int capacity = 16;
  private Backet[] backets = new Backet[capacity];


  public CHashSet() {
    System.out.println(backets[0]);
    for (int i = 0; i < backets.length; i++) {
      backets[i] = new Backet();
    }
  }

  public CHashSet(int capacity) {
    this.capacity = capacity;
  }

  public CHashSet(Number[] numbers) {

  }

  public CHashSet(Number[]... numbers) {

  }

  public CHashSet(CHashSet numbers) {

  }

  public CHashSet(CHashSet... numbers) {

  }

      public  void add(Number n){
        long whatBacket = n.hashCode();
        while (whatBacket > 9){
          whatBacket = whatBacket / 10;
        }
        backets[(int) whatBacket].addLast(n);
      }
    public  void add(Number ... n){
      System.out.println("n.length = " + n.length);
      for (Number number : n) {
        System.out.println("number = " + number);
      }
    }
    public  void join(CHashSet ms){
      System.out.println("join");
      System.out.println("ms = " + ms);
    }
    public  void join(CHashSet... ms){

    }
    public  void sortDesc(){

    }
    public  void sortDesc(int firstIndex, int lastIndex){

    }
    public  void sortDesc(Number value){

    }
    public  void sortAsc(){

    }
    public  void sortAsc(int firstIndex, int lastIndex){

    }
    public  void sortAsc(Number value){

    }
    public  Number get(int index){
      return null;
    }
    public  Number getMax(){
      return null;
    }
    public  Number getMin(){
      return null;
    }
    public  Number getAverage(){
      return null;
    }
    public  Number getMedian(){
      return null;
    }
    public  Number[] toArray(){
      return null;
    }
    public  Number[] toArray(int firstIndex, int lastIndex){

      return null;
    }
    public  void clear(){

    }
    public  void clear(int firstIndex, int lastIndex){

    }
    public  void clear(Number[] numbers){

    }

  @Override
  public String toString() {
    return "MathSet{" +
        "capacity=" + capacity +
        ", backets=" + Arrays.toString(backets) +
        '}';
  }
}
