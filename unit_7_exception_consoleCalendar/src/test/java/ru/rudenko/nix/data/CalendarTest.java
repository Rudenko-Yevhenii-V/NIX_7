package ru.rudenko.nix.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


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
    calendar = new Calendar(200, 20, 50, 1, 5, 7, 2012);
    Assertions.assertEquals(63478432220200L, calendar.getTime());
  }

  @Test
  @Order(4)
  void getMounthsFromMiliseconds() {
    Assertions.assertEquals(1, calendar.getMounthsFromMiliseconds
        (0L));
    Assertions.assertEquals(2, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 32L));
    Assertions.assertEquals(3, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 63L));
    Assertions.assertEquals(4, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 93L));
    Assertions.assertEquals(5, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 124L));
    Assertions.assertEquals(6, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 155L));
    Assertions.assertEquals(7, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 186L));
    Assertions.assertEquals(1, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 365L));
    Assertions.assertEquals(2, calendar.getMounthsFromMiliseconds
        (1000 * 60 * 60 * 24 * 397L));

  }

  @Test
  @Order(5)
  void getYearsFromMiliseconds() {
    Assertions.assertEquals(1, calendar.getYearsFromMiliseconds
        (5529600000L));
    Assertions.assertEquals(2, calendar.getYearsFromMiliseconds
        (1000 * 60 * 60 * 24 * 370L));
  }

  @Test
  @Order(6)
  void getDaysFromMiliseconds() {
    Assertions.assertEquals(1, calendar.getDaysFromMiliseconds
        (1000 * 60 * 60 * 24));
    Assertions.assertEquals(2, calendar.getDaysFromMiliseconds
        (1000 * 60 * 60 * 24 * 2));
    Assertions.assertEquals(30, calendar.getDaysFromMiliseconds
        (1000 * 60 * 60 * 24 * 30L));
  }

  @Test
  @Order(7)
  void exchangeTimeOneDayAndMax() {
    Calendar calendar1 = new Calendar(0, 0, 0, 0, 1, 1, 1);
    Calendar calendar2 = new Calendar(1000 * 60 * 60 * 24);
    Assertions.assertEquals(calendar1.time, calendar2.time);
    Assertions.assertEquals(calendar1.years, calendar2.years);
    Assertions.assertEquals(calendar1.mounths, calendar2.mounths);
    Assertions.assertEquals(calendar1.days, calendar2.days);
    Assertions.assertEquals(calendar1.hours, calendar2.hours);
    Assertions.assertEquals(calendar1.minutes, calendar2.minutes);
    Assertions.assertEquals(calendar1.seconds, calendar2.seconds);
    Assertions.assertEquals(calendar1.milliseconds, calendar2.milliseconds);

    Calendar calendar3 = new Calendar(0, 0, 0, 0, 31, 1, 1);
    Calendar calendar4 = new Calendar(1000 * 60 * 60 * 24 * 31L);
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
    Calendar calendar1 = new Calendar(0, 0, 0, 0, 1, 2, 1);
    Calendar calendar2 = new Calendar(1000 * 60 * 60 * 24 * 32L);
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
    Calendar calendarYear1 = new Calendar(0, 0, 0, 0, 0, 1, 2);
    Calendar calendarYear2 = new Calendar(31536000000L);
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