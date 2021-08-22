package ru.rudenko.nix.utill;

import static org.junit.jupiter.api.Assertions.*;

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
    Time timeStart = Parser
        .getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
            "Some text 12-22-001 Some text 20:21:55:567 Some tex", "format");
    Time timeStop = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "Some text 12-12-001 Some text 20:21:55:567 Some tex", "format");
    Time differenceBetweenDates = new NixDate().findDifferenceBetweenDates(timeStart, timeStop);
    new Calendar().print((Calendar) differenceBetweenDates);
  }

  @Test
  void timeAddTime() {
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