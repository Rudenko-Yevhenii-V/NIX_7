package ry.rudenko.yevhenii;

import java.util.Scanner;
import ry.rudenko.yevhenii.windows.WindowConstructors;

public class CollectionsMain {

  public static void main(String[] args) {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nClass MathSet have!\n"
        + "Constructors:\n"
        + "1. MathSet()\n"
        + "2. MathSet(int capacity)\n"
        + "3. MathSet(Number[] numbers)\n"
        + "4. MathSet(Number[] ... numbers)\n"
        + "5. MathSet(MathSet numbers)\n"
        + "6. MathSet(MathSet ... numbers)\n"
        + "Methods:\n"
        + "1. void add(Number n)\n"
        + "2. void add(Number ... n)\n"
        + "3. void join(MathSet ms)\n"
        + "4. void join(MathSet ... ms)\n"
        + "5. void intersection(MathSet ms)\n"
        + "6. void intersection (MathSet ... ms)\n"
        + "7. void sortDesc()\n"
        + "8. void sortDesc(int firstIndex, int lastIndex)\n"
        + "9. void sortDesc(Number value)\n"
        + "10. void sortAsc()\n"
        + "11. void sortAsc(int firstIndex, int lastIndex)\n"
        + "12. void sortAsc(Number value)\n"
        + "13. Number get(int index)\n"
        + "14. Number getMax()\n"
        + "15. Number getMin()\n"
        + "16. Number getAverage()\n"
        + "17. Number getMedian()\n"
        + "18. Number[] toArray();\n"
        + "19. Number[] toArray(int firstIndex, int lastIndex);\n"
        + "20.MathSet cut(int firstIndex, int lastIndex)\n"
        + "21. void clear()\n"
        + "22.void clear(Number[] numbers)\n\n\n  Enter 1 to class demonstration \n  Enter else to exit");
    Scanner scanner = new Scanner(System.in);
    String answer = scanner.nextLine();
    if (answer.equals("1")){
      new WindowConstructors().setVisible(true);
    }
  }
}
