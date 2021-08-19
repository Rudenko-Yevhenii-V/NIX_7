package ru.rudenko.nix;

import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.utill.NixDate;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 12:41 PM
 * @project NIX_7
 */
public class Unit7Main {

  public static void main(String[] args) throws InterruptedException {

    Calendar calendar1 = new Calendar(864000001);
    Calendar calendar2 = new Calendar(64000001);
    Calendar calendar3 = new Calendar(4000001);
    Calendar calendar4 = new Calendar(5643664000001l);
    Calendar calendar5 = new Calendar(64444444444000001l);
    Calendar calendar6 = new Calendar(60001);
    Calendar calendar7 = new Calendar(601);
    Calendar[] calendars = {calendar1, calendar2,calendar3,calendar4,calendar5,calendar6,calendar7};
    NixDate nixDate = new NixDate();
    Calendar[] sortesCal = (Calendar[]) nixDate.sortTimesFromLowToHight(calendars);
    for (int i = 0; i < sortesCal.length; i++) {
      System.out.println(sortesCal[i].time);
    }
    Calendar[] sortesCalw = (Calendar[]) nixDate.sortTimesFromHightToLow(calendars);
    for (int i = 0; i < sortesCalw.length; i++) {
      System.out.println(sortesCalw[i].time);
    }

//    System.out.println(" findDifferenceBetweenDates = " +
//        new NixDate().findDifferenceBetweenDates(calendar2, calendar1).getTime());
//    System.out.println(" timeAddTime = " +
//        new NixDate().timeAddTime(calendar1, calendar2).getTime());
//    System.out.println(" timeSubtractTime = " +
//        new NixDate().timeSubtractTime(calendar1, calendar2).getTime());
//    calendar1.print(calendar1);
//
//    calendar1.print(calendar1);
//    while (true) {
//      calendar1.addMilliseconds(1000);
//      Thread.sleep(1000);
//      calendar1.print(calendar1);
//    }
  }
}
