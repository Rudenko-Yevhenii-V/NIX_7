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
    Assertions.assertEquals(63511437020200l,  calendar.getTime());
  }

  @Test
  @Order(4)
  void getMounthsFromMiliseconds() {
    Assertions.assertEquals(2,  calendar.getMounthsFromMiliseconds
        (5529600000l));
  }

  @Test
  @Order(5)
  void getYearsFromMiliseconds() {
    Assertions.assertEquals(1,  calendar.getYearsFromMiliseconds
        (5529600000l));
  }

  @Test
  @Order(6)
  void getDaysFromMiliseconds() {
    Assertions.assertEquals(5,  calendar.getDaysFromMiliseconds
        (5529600000l));
  }
}