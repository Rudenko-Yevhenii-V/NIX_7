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
  void checkParserddmmyy() {
    final Calendar calendar = (Calendar) Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat("04-07-2008 03:05:55:777",
            "dd/mm/yy hh:mm:ss:msmsms");

    Assertions.assertEquals(calendar.days, 4);
    Assertions.assertEquals(calendar.mounths, 7);
    Assertions.assertEquals(calendar.years, 2008);
    Assertions.assertEquals(calendar.hours, 3);
    Assertions.assertEquals(calendar.minutes, 5);
    Assertions.assertEquals(calendar.seconds, 55);
    Assertions.assertEquals(calendar.milliseconds, 777);
  }
  @Test
  void checkParsermmddyy() {
    final Calendar calendar = (Calendar) Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat("04-07-2008 03:05:55:777",
            "mm/dd/yy hh:mm:ss:msmsms");

    Assertions.assertEquals(calendar.days, 7);
    Assertions.assertEquals(calendar.mounths, 4);
    Assertions.assertEquals(calendar.years, 2008);
    Assertions.assertEquals(calendar.hours, 3);
    Assertions.assertEquals(calendar.minutes, 5);
    Assertions.assertEquals(calendar.seconds, 55);
    Assertions.assertEquals(calendar.milliseconds, 777);
  }
  @Test
  void checkParsermmmddyy() {
    final Calendar calendar = (Calendar) Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat("july-04-2008 03:05:55:777",
            "mmm/dd/yy hh:mm:ss:msmsms");
    System.out.println("calendar = " + calendar);
    Assertions.assertEquals(calendar.days, 4);
    Assertions.assertEquals(calendar.mounths, 7);
    Assertions.assertEquals(calendar.years, 2008);
    Assertions.assertEquals(calendar.hours, 3);
    Assertions.assertEquals(calendar.minutes, 5);
    Assertions.assertEquals(calendar.seconds, 55);
    Assertions.assertEquals(calendar.milliseconds, 777);
  }
  @Test
  void checkParserddmmmyy() {
    final Calendar calendar = (Calendar) Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat("04-july-2008 03:05:55:777",
            "dd/mmm/yy hh:mm:ss:msmsms");

    Assertions.assertEquals(calendar.days, 4);
    Assertions.assertEquals(calendar.mounths, 7);
    Assertions.assertEquals(calendar.years, 2008);
    Assertions.assertEquals(calendar.hours, 3);
    Assertions.assertEquals(calendar.minutes, 5);
    Assertions.assertEquals(calendar.seconds, 55);
    Assertions.assertEquals(calendar.milliseconds, 777);
  }

  @Test
  void checkConvertnext() {
    boolean check = true;
    for (int i = 1; i < 1000; i++) {
      Calendar calendar1 = new Calendar(777, 55, 5, 3, 4,
          7, 100 + i);
      Calendar calendar2 = new Calendar(calendar1.getTime());
      if (!(calendar1.days == calendar2.days)) {
        System.out.println("calendar1 = " + calendar1);
        System.out.println("calendar2 = " + calendar2);
        System.out.println("__________________________");
        check = false;
      }
      if (!(calendar1.mounths == calendar2.mounths)) {
        System.out.println("calendar1 = " + calendar1);
        System.out.println("calendar2 = " + calendar2);
        System.out.println("__________________________");
        check = false;
      }
      if (!(calendar1.years == calendar2.years)) {
        System.out.println("calendar1 = " + calendar1);
        System.out.println("calendar2 = " + calendar2);
        System.out.println("__________________________");
        check = false;
      }
      if (!(calendar1.hours == calendar2.hours)) {
        System.out.println("calendar1 = " + calendar1);
        System.out.println("calendar2 = " + calendar2);
        System.out.println("__________________________");
        check = false;
      }
      if (!(calendar1.minutes == calendar2.minutes)) {
        System.out.println("calendar1 = " + calendar1);
        System.out.println("calendar2 = " + calendar2);
        System.out.println("__________________________");
        check = false;
      }
    }
    Assertions.assertTrue(check);
  }
}

