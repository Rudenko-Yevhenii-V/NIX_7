package ru.rudenko.nix;

import ru.rudenko.nix.controllers.Controller;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;
import ru.rudenko.nix.service.Parser;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 12:41 PM
 * @project NIX_7
 */
public class Unit7Main {

  public static void main(String[] args) {
//    new Controller().start();
//    format = "dd/mm/yy hh:mm:ss:msmsms";
//    format = "mm/dd/yy hh:mm:ss:msmsms";
//    format = "mmm/dd/yy hh:mm:ss:msmsms";
//    format = "dd/mmm/yy hh:mm:ss:msmsms";
    Time timeStart = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "coming from the 1 july 34 to 10:55:44:689 the 30.11.2009",
        "dd/mmm/yy hh:mm:ss:msmsms");
  new Calendar().print((Calendar) timeStart);


  }
}
