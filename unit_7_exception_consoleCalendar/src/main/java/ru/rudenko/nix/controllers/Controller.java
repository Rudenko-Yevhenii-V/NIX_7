package ru.rudenko.nix.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;
import ru.rudenko.nix.service.Parser;
import ru.rudenko.nix.utill.NixDate;


public class Controller {

  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private String format = "dd/mm/yy hh:mm:ss:msmsms";

  public void start() {
    System.out.println("select your option");
    String position;
    try {
      runNavigation();
      while ((position = reader.readLine()) != null) {
        crud(position, reader);
        position = reader.readLine();
        if (position.equals("0")) {
          System.exit(0);
        }
        crud(position, reader);
      }
    } catch (IOException e) {
      System.out.println("problem: = " + e.getMessage());
    }
  }

  private void runNavigation() {
    System.out.println();
    System.out.println(
        "default format(" + format + "), if you want change format, please enter 1");
    System.out.println("if you want to find the difference between dates, please enter 2");
    System.out.println("if you want add To Date Time , please enter 3");
    System.out.println("if you want format dd/mm/yy hh:mm:ss:msmsms, please enter 4");
    System.out.println("if you want findById user, please enter 5");
    System.out.println("if you want findAll user, please enter 6");
    System.out.println("if you want exit, please enter 0");
    System.out.println();
  }

  private void crud(String position, BufferedReader reader) {
    switch (position) {
      case "1":
        setFormat();
        break;
      case "2":
        differenceDates();
        break;
      case "3":
       addToTimeDate();
        break;
      case "4":
        //  delete(reader);
        break;
      case "5":
        //  findById(reader);
        break;
      case "6":
        //  findAll(reader);
        break;
      case "0":
        System.exit(0);

    }
    runNavigation();
  }

  private void addToTimeDate() {
    System.out
        .println("enter date ex: Some text 01-03-2001 Some text 00:00:55:777 Some text");
    System.out.println("(default format only) if you want date from ex, enter 1 or 2 if custom date");
    String firstDate = "Some text 01-03-2001 Some text 00:00:55:777 Some text";
    try {
      String choise = reader.readLine();
      if (!(choise.equals("1"))) {
        System.out.println("Enter date:");
        firstDate = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out
        .println("enter add date ex: Some text 04-02-2008 Some text 00:00:00:000 Some text");
    System.out.println("(default format only) if you want date from ex, enter 1 or else if custom date");
    String secondDate = "Some text 04-02-2008 Some text 00:00:00:000 Some text";
    try {
      String choise = reader.readLine();
      if (!(choise.equals("1"))) {
        System.out.println("Enter add date:");
        secondDate = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Time timeStart = Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(firstDate, format);
    Time timeStop = Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(secondDate, format);

    new Calendar().print((Calendar) new NixDate().timeAddTime(timeStart, timeStop));
  }

  private void differenceDates() {
    System.out
        .println("enter first date ex: Some text 01-03-2001 Some text 00:00:55:777 Some text");
    System.out.println("(default format only) if you want date from ex, enter 1 or 2 if custom date");
    String firstDate = "Some text 01-03-2001 Some text 00:00:55:777 Some text";
    try {
      String choise = reader.readLine();
      if (!(choise.equals("1"))) {
        System.out.println("Enter first date:");
        firstDate = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out
        .println("enter second date ex: Some text 05-07-2004 Some text 01:10:55:777 Some text");
    System.out.println("(default format only) if you want date from ex, enter 1 or else if custom date");
    String secondDate = "Some text 05-07-2004 Some text 01:10:55:777 Some text";
    try {
      String choise = reader.readLine();
      if (!(choise.equals("1"))) {
        System.out.println("Enter second date:");
        secondDate = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Time timeStart = Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(firstDate, format);
    Time timeStop = Parser.getInstance()
        .ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(secondDate, format);
    Time differenceBetweenDates = new NixDate().findDifferenceBetweenDates(timeStart, timeStop);
    new Calendar().print((Calendar) timeStart);
    new Calendar().print((Calendar) timeStop);
    new Calendar().print((Calendar) differenceBetweenDates);
  }
  private void setFormat() {
    String choice = "1";
    System.out.println("if you want format dd/mm/yy hh:mm:ss:msmsms, please enter 1");
    System.out.println("if you want format mm/dd/yy hh:mm:ss:msmsms, please enter 2");
    System.out.println("if you want format mmm/dd/yy hh:mm:ss:msmsms, please enter 3");
    System.out.println("if you want format dd/mmm/yy hh:mm:ss:msmsms, please enter 4");
    try {
      choice = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    switch (choice) {
      case "1":
        format = "dd/mm/yy hh:mm:ss:msmsms";
        break;
      case "2":
        format = "mm/dd/yy hh:mm:ss:msmsms";
        break;
      case "3":
        format = "mmm/dd/yy hh:mm:ss:msmsms";
        break;
      case "4":
        format = "dd/mmm/yy hh:mm:ss:msmsms";
        break;
      default:
        return;

    }
  }
}
