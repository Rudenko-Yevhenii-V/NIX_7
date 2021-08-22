package ru.rudenko.nix;

import ru.rudenko.nix.controllers.Controller;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;
import ru.rudenko.nix.exceptionsC.SimulatedException;
import ru.rudenko.nix.service.Parser;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 12:41 PM
 * @project NIX_7
 */
public class Unit7Main {

  public static void main(String[] args) {
//    new Controller().start();
//
//  try {
//    throw new SimulatedException(" some wrong");
//  } catch (SimulatedException e) {
//    e.printStackTrace();
//  }

    Time timeStart = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "ome text 10-12-2001 Some text 20:21:55: Some tex",


//        "coming from the 1-july-034 to 10:55:44:689 the 30.11.2009",
        "dd/mm/yy hh:mm:ss:msmsms");
new Calendar().print((Calendar) timeStart);
//    Some text 12-22-001 Some text 20:21:55:567 Some tex


//  new Calendar().print((Calendar) timeStart);
//
// Calendar calendar = new Calendar(888888888888888l);
// calendar.print(calendar);

  }
}
