package ru.rudenko.nix;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.controllers.Controller;


public class Unit7Main {
  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  public static void main(String[] args) {
    LOGGER_INFO.info("Start!");
    System.out.println("\n\n\n\n");
    System.out.println(" Hi USER!."
        + "This program is designed to work with time and dates ...\n"
        + "First you need to choose a format: \n"
        + "-dd/mm/yy hh:mm:ss:msmsms\n"
        + "-mm/dd/yy hh:mm:ss:msmsms\n"
        + "-mmm/dd/yy hh:mm:ss:msmsms\n"
        + "-dd/mmm/yy hh:mm:ss:msmsms\n"
        + "the program looks for dates and times in the text only 1 date 1 time ...\n"
        + "example (Some text 01-03-2001 Some text 00:00:55:777 Some text)\n"
        + "you can use to split the date (dd.mm.yy)(dd mm yy)(dd/mm/yy)(dd-mm-yy) ...\n"
        + "for time only : (hh:mm:ss:msmsms)\n"
        + "month in form: января февраля марта апреля мая июня июля августа сентября октября ноября декабря\n"
        + "or january february march april may june july august september october november december\n"
        + "example: 01.february.2003 05:50:25:254 or 01.февраля.2003 05:50:25:254\n"
        + "case doesn't matter ...\n"
        + "Methods:\n"
        + "- Change input format setFormat \n"
        + "- The result of the difference between two dates differenceDates \n"
        + "- add to the time year month day and so on.  addToTimeDate \n"
        + "- Subtraction from date timeSubtractTime \n"
        + "- compare list of dates in descending order sortTimesFromHightToLow \n"
        + "- compare list of dates in ascending ordersortTimesFromLowToHight \n"
        + "- ADDITIONAL FUNCTIONS!!! \n"
        + "   --Check if it's a leap year      \n"
        + "   --How many days in a month       \n"
        + "   --Convert milliseconds to date   \n"
        + "   --Convert date to milliseconds   \n\n\n"
        + "Click to continue ENTER\n");
  Scanner scaner = new Scanner(System.in);
  scaner.nextLine();
    new Controller().start();
  }
}
