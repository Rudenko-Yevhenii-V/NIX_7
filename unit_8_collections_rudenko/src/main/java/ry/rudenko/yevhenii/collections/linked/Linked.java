package ry.rudenko.yevhenii.collections.linked;

/**
 * @author Rudenko Yevhenii
 * @created 26/08/2021 - 1:28 PM
 * @project NIX_7
 */
public interface Linked<E> {
  void  addLast(E e);
  void  addFirst(E e);
  int size();
  E getElementByIndex(int counter);
}
