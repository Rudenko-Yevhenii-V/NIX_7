package ru.rudenko.nix;

import ru.rudenko.nix.service.Parser;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 12:41 PM
 * @project NIX_7
 */
public class Unit7Main {

  public static void main(String[] args) throws InterruptedException {
    //done
//  dd/mm/yy
//  dd-mm-yy
//  dd.mm.yy
//  dd mm yy
    //dd ./-mm ./-yyyy hh:mm:ss:msmsms + any text
    //done
    //      • dd/mm/yy - 31/12/99  23:59:59:999
//      • m/d/yyyy - 3/4/2021
//      • mmm-d-yy - Март 4 21
//      • dd-mmm-yyyy 00:00 - 09 Апрель 789 45:23

    Parser parser = new Parser();
    //empty one
//    parser.ParseStringToCalendarDateFormat("-07-0005");
//    parser.ParseStringToCalendarDateFormat("22-07-");
//    Calendar time1 = (Calendar) parser.ParseStringToCalendarDateFormat("02--0002");
//    time1.print(time1);
    //empty one
//    parser.ParseStringToCalendarDateFormat("-07-0005   23:59:59:999");
//    parser.ParseStringToCalendarDateFormat("  ");
//    parser.ParseStringToCalendarDateFormat("23:59:59:");
//    parser.ParseStringToCalendarDateFormat("23:59::999");
//    parser.ParseStringToCalendarDateFormat("23::59:999");
//    parser.ParseStringToCalendarDateFormat(":59:59:999");
    parser.ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat("sdfasd 31 12 2005 23:59:59:999");
//    parser.ParseStringToCalendarDateFormat("00:00:00:000");
//    parser.ParseStringToCalendarDateFormat("24:59:59:999");
//    parser.ParseStringToCalendarDateFormat("00:60:59:999");
//    parser.ParseStringToCalendarDateFormat("01-07-0005");
//    parser.ParseStringToCalendarDateFormat("01-07-99");
//    parser.ParseStringToCalendarDateFormat("01.07.2005");
//    parser.ParseStringToCalendarDateFormat("31/12/2005  00:00:00:000");
//    parser.ParseStringToCalendarDateFormat("coming from the 25/11/2009 to the 30/11/2009");

//    //))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
//
//    Calendar calendar1 = new Calendar(864000001);
//    Calendar calendar2 = new Calendar(64000001);
//    Calendar calendar3 = new Calendar(4000001);
//    Calendar calendar4 = new Calendar(5643664000001l);
//    Calendar calendar5 = new Calendar(64444444444000001l);
//    Calendar calendar6 = new Calendar(60001);
//    Calendar calendar7 = new Calendar(601);
//    Calendar[] calendars = {calendar1, calendar2,calendar3,calendar4,calendar5,calendar6,calendar7};
//    NixDate nixDate = new NixDate();
//    Calendar[] sortesCal = (Calendar[]) nixDate.sortTimesFromLowToHight(calendars);
//    for (int i = 0; i < sortesCal.length; i++) {
//      System.out.println(sortesCal[i].time);
//    }
//    Calendar[] sortesCalw = (Calendar[]) nixDate.sortTimesFromHightToLow(calendars);
//    for (int i = 0; i < sortesCalw.length; i++) {
//      System.out.println(sortesCalw[i].time);
//    }
////))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
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
