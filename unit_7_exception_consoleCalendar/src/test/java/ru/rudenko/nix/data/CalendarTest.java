package ru.rudenko.nix.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Rudenko Yevhenii
 * @created 20/08/2021 - 5:38 PM
 * @project NIX_7
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalendarTest {
  Calendar calendar = new Calendar();

  @Test
  @Order(1)
  void isLeapYear() {
    Assertions.assertFalse(calendar.isLeapYear(2003));
    Assertions.assertTrue(calendar.isLeapYear(2004));
  }

  @Test
  @Order(2)
  void daysInYear() {
    Assertions.assertEquals(365, calendar.daysInYear(1));
    Assertions.assertEquals(366, calendar.daysInYear(4));
  }

  @Test
  @Order(3)
  void getTime() {
    calendar = new Calendar(200, 20, 50, 01, 5, 7, 2012);
    Assertions.assertEquals(63477136220200l,  calendar.getTime());
  }

  @Test
  @Order(4)
  void getMounthsFromMiliseconds() {

    Assertions.assertEquals(2,  calendar.getMounthsFromMiliseconds
        (3024000000l));
    Assertions.assertEquals(1,  calendar.getMounthsFromMiliseconds
        (0l));
    Assertions.assertEquals(1,  calendar.getMounthsFromMiliseconds
        (1000*60*60*24*31*12l));

  }

  @Test
  @Order(5)
  void getYearsFromMiliseconds() {
    Assertions.assertEquals(1,  calendar.getYearsFromMiliseconds
        (5529600000l));
    Assertions.assertEquals(2,  calendar.getYearsFromMiliseconds
        (1000*60*60*24*370l));
  }

  @Test
  @Order(6)
  void getDaysFromMiliseconds() {
    Assertions.assertEquals(1,  calendar.getDaysFromMiliseconds
        (1000*60*60*24));
    Assertions.assertEquals(2,  calendar.getDaysFromMiliseconds
        (1000*60*60*24*2));
    Assertions.assertEquals(30,  calendar.getDaysFromMiliseconds
        (1000*60*60*24*30l));

  }
  @Test
  @Order(7)
  void exchangeTimeOneDayAndMax() {
    Calendar calendar1 = new Calendar(0,0,0,0,1,1,1);
    Calendar calendar2 = new Calendar(1000*60*60*24);
        Assertions.assertEquals(calendar1.time, calendar2.time);
    Assertions.assertEquals(calendar1.years, calendar2.years);
    Assertions.assertEquals(calendar1.mounths, calendar2.mounths);
    Assertions.assertEquals(calendar1.days, calendar2.days);
    Assertions.assertEquals(calendar1.hours, calendar2.hours);
    Assertions.assertEquals(calendar1.minutes, calendar2.minutes);
    Assertions.assertEquals(calendar1.seconds, calendar2.seconds);
    Assertions.assertEquals(calendar1.milliseconds, calendar2.milliseconds);

    Calendar calendar3 = new Calendar(0,0,0,0,31,1,1);
    Calendar calendar4 = new Calendar(1000*60*60*24*31L);
    Assertions.assertEquals(calendar3.time, calendar4.time);
    Assertions.assertEquals(calendar3.years, calendar4.years);
    Assertions.assertEquals(2, calendar4.mounths);
    Assertions.assertEquals(0, calendar4.days);
    Assertions.assertEquals(calendar3.hours, calendar4.hours);
    Assertions.assertEquals(calendar3.minutes, calendar4.minutes);
    Assertions.assertEquals(calendar3.seconds, calendar4.seconds);
    Assertions.assertEquals(calendar3.milliseconds, calendar4.milliseconds);


  }
  @Test
  @Order(8)
  void exchangeTimeOneMounth() {
    Calendar calendar1 = new Calendar(0,0,0,0,1,2,1);
    Calendar calendar2 = new Calendar(1000*60*60*24*32L);
       Assertions.assertEquals(calendar1.time, calendar2.time);
    Assertions.assertEquals(calendar1.years, calendar2.years);
    Assertions.assertEquals(calendar1.mounths, calendar2.mounths);
    Assertions.assertEquals(calendar1.days, calendar2.days);
    Assertions.assertEquals(calendar1.hours, calendar2.hours);
    Assertions.assertEquals(calendar1.minutes, calendar2.minutes);
    Assertions.assertEquals(calendar1.seconds, calendar2.seconds);
    Assertions.assertEquals(calendar1.milliseconds, calendar2.milliseconds);
  }
  @Test
  @Order(9)
  void exchangeTimeOneYear() {
    Calendar calendarYear1 = new Calendar(0,0,0,0,0,1,2);
    Calendar calendarYear2 = new Calendar(31536000000l);
    Assertions.assertEquals(calendarYear1.time, calendarYear2.time);
    Assertions.assertEquals(calendarYear1.years, calendarYear2.years);
    Assertions.assertEquals(calendarYear1.mounths, calendarYear2.mounths);
    Assertions.assertEquals(calendarYear1.days, calendarYear2.days);
    Assertions.assertEquals(calendarYear1.hours, calendarYear2.hours);
    Assertions.assertEquals(calendarYear1.minutes, calendarYear2.minutes);
    Assertions.assertEquals(calendarYear1.seconds, calendarYear2.seconds);
    Assertions.assertEquals(calendarYear1.milliseconds, calendarYear2.milliseconds);
  }

}