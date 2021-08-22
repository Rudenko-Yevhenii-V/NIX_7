package ru.rudenko.nix.utill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;
import ru.rudenko.nix.service.Parser;

/**
 * @author Rudenko Yevhenii
 * @created 21/08/2021 - 11:25 PM
 * @project NIX_7
 */
class NixDateTest {

  @Test
  void findDifferenceBetweenDates() {
    Time timeStart1 = Parser
        .getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
            "Some text 12-12-2008 Some text 20:21:55:567 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Time timeStop1 = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "Some text 12-12-2008 Some text 20:21:55:567 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Time differenceBetweenDates1 = new NixDate().findDifferenceBetweenDates(timeStart1, timeStop1);
    Assertions.assertEquals(0, differenceBetweenDates1.time);

    Time timeStart2 = Parser
        .getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
            "Some text 12-12-2008 Some text 20:21:55:567 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Time timeStop2 = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "Some text 13-12-2008 Some text 20:21:55:567 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Time differenceBetweenDates2 = new NixDate().findDifferenceBetweenDates(timeStart2, timeStop2);
    Assertions.assertEquals(1000*60*60*24, differenceBetweenDates2.time);
    Time timeStart3 = Parser
        .getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
            "Some text 12-11-2008 Some text 20:21:55:567 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Time timeStop3 = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "Some text 12-12-2008 Some text 20:21:55:567 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Time differenceBetweenDates3 = new NixDate().findDifferenceBetweenDates(timeStart3, timeStop3);
    Assertions.assertEquals(1000*60*60*24*31l, differenceBetweenDates3.time);
  }

  @Test
  void timeAddTime() {
    Calendar calendar1 = new Calendar(0,0, 0, 0, 0, 1,1);
    Calendar calendar2 = new Calendar(1,1,1,1,10,2,2);
    Calendar result = (Calendar) new NixDate().timeAddTime(calendar1, calendar2);
    new Calendar().print(result);
  }

  @Test
  void timeSubtractTime() {
  }

  @Test
  void sortTimesFromLowToHight() {
  }

  @Test
  void sortTimesFromHightToLow() {
  }
}