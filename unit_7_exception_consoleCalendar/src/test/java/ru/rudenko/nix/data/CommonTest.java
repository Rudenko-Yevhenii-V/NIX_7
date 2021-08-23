package ru.rudenko.nix.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.rudenko.nix.service.Parser;

public class CommonTest {

  @Test
  void createTime() {
    Calendar calendar1;
    Calendar calendar2 = new Calendar(1, 0, 0, 0, 1, 1, 1);
    Calendar calendar3 = new Calendar(1000 * 60 * 60 * 24 + 1);
    calendar1 = (Calendar) Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "ome text 01-01-0001 Some text 00:00:00:001 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Assertions.assertEquals(calendar2.getTime(), calendar3.getTime());
    Assertions.assertEquals(calendar1.getTime(), calendar2.getTime());
  }

  @Test
  void checkConvert() {
    Calendar calendar1 = new Calendar(0, 0, 0, 0, 0, 3, 1);
    Calendar calendar2 = new Calendar(calendar1.getTime());
    Assertions.assertEquals(calendar1.mounths, calendar2.mounths);
  }
  @Test
  void checkConvertnext() {
    boolean check = true;
//    for (int i = 1; i < 1000; i++) {
      Calendar calendar11 = new Calendar(777,55,5,3,4,7,8);
    Calendar calendar12 = (Calendar) Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat("04-07-2008 03:05:55:777", "dd/mm/yy hh:mm:ss:msmsms");
      Calendar calendar2 = new Calendar(calendar11.getTime());//63350910355777
    System.out.println("calendar11 = " + calendar11);
    System.out.println("calendar12 = " + calendar12);
    System.out.println("calendar2 = " + calendar2);
    System.out.println("__________________________");
//      if (!(calendar1.days == calendar2.days)){
//        System.out.println("calendar1 = " + calendar1);
//        System.out.println("calendar2 = " + calendar2);
//        System.out.println("__________________________");
//        check = false;
//      }
//      if (!(calendar1.mounths == calendar2.mounths)){
//        System.out.println("calendar1 = " + calendar1);
//        System.out.println("calendar2 = " + calendar2);
//        System.out.println("__________________________");
//        check = false;
//      }
//      if (!(calendar1.years == calendar2.years)){
//        System.out.println("calendar1 = " + calendar1);
//        System.out.println("calendar2 = " + calendar2);
//        System.out.println("__________________________");
//        check = false;
//      }
//      if (!(calendar1.hours == calendar2.hours)){
//        System.out.println("calendar1 = " + calendar1);
//        System.out.println("calendar2 = " + calendar2);
//        System.out.println("__________________________");
//        check = false;
//      }
//      if (!(calendar1.minutes == calendar2.minutes)){
//        System.out.println("calendar1 = " + calendar1);
//        System.out.println("calendar2 = " + calendar2);
//        System.out.println("__________________________");
//        check = false;
//      }
    }
//   Assertions.assertTrue(check);
//  }
}

