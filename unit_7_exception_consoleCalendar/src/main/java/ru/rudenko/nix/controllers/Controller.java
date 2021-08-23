package ru.rudenko.nix.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
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
        "default format(" + format + "),\nif you want change format,      please enter 1");
    System.out.println("if you want to find the difference between dates, please enter 2");
    System.out.println("if you want add To Date Time ,                    please enter 3");
    System.out.println("if you want subtract Time from Date ,             please enter 4");
    System.out.println("if you want sort Times From Hight To Low,         please enter 5");
    System.out.println("if you want sort Times From Low To Hight,         please enter 6");
    System.out.println("if you want additional functions                  please enter 7");
    System.out.println("if you want exit,                                 please enter 0");
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
        subtract();
        break;
      case "5":
        sortTimesFromHightToLow();
        break;
      case "6":
        sortTimesFromLowToHight();
        break;
      case "7":
        additional();
        break;
      case "0":
        System.exit(0);
      default:
        System.out.println("wrong choise!!!");

    }
    runNavigation();
  }

  private void additional() {
  }

  private void sortTimesFromLowToHight() {
    System.out.println("if you want manual: enter 1 or 2 if you want AUTO GENERATE");
    Time[] times = new Time[1];

    try {
      String choise = reader.readLine();
      if (choise.equals("1")) {
        System.out.println("enter time and date exempl: 04-07-2008 03:05:55:777");
        boolean status = true;
        int caunter = 0;
        times[caunter] = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
            reader.readLine(), format);
        while (status){
          caunter++;
          System.out.println("enter next time and date exempl: 04-07-2008 03:05:55:777");
          times = Arrays.copyOf(times, caunter+1);
          times[caunter] = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
              reader.readLine(), format);
          System.out.println("if you watn stop add dates, enter 1 any else to cantinue");
          if(reader.readLine().equals("1")){
            status = false;
          }
        }

      }
      if (choise.equals("2")) {
        System.out.println("enter the number of random dates:");
        final char[] chars = reader.readLine().toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
          if (String.valueOf(chars[i]).matches("\\d")){
            result = result + chars[i];
          }
        }
        int numbers = Integer.parseInt(result);
        for (int i = 0; i < numbers; i++) {
          int dd = (new Random().nextInt((31) + 1));
          int mm = (new Random().nextInt((12 - 1) + 1) + 1);
          int yyyy = (new Random().nextInt((3000 - 1) + 1) + 1);
          int hh = (new Random().nextInt((23) + 1));
          int mi = (new Random().nextInt((59) + 1));
          int ss = (new Random().nextInt((59) + 1));
          int msm = (new Random().nextInt((999) + 1));
          times = Arrays.copyOf(times, i+1);
          times[i] = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
              dd + "-" + mm + "-" + yyyy + " " + hh + ":" + mi + ":" + ss + ":" + msm , format);
        }
      }
      final Time[] timesSorted = new NixDate().sortTimesFromLowToHight(times);
      for (int i = 0; i < timesSorted.length; i++) {
        new Calendar().print((Calendar) timesSorted[i]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void sortTimesFromHightToLow() {
    System.out.println("if you want manual: enter 1 or 2 if you want AUTO GENERATE");
    Time[] times = new Time[1];

    try {
      String choise = reader.readLine();
      if (choise.equals("1")) {
        System.out.println("enter time and date exempl: 04-07-2008 03:05:55:777");
        boolean status = true;
        int caunter = 0;
        times[caunter] = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
            reader.readLine(), format);
        while (status){
          caunter++;
          System.out.println("enter next time and date exempl: 04-07-2008 03:05:55:777");
          times = Arrays.copyOf(times, caunter+1);
          times[caunter] = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
              reader.readLine(), format);
          System.out.println("if you watn stop add dates, enter 1 any else to cantinue");
          if(reader.readLine().equals("1")){
            status = false;
          }
        }

      }
      if (choise.equals("2")) {
        System.out.println("enter the number of random dates:");
        final char[] chars = reader.readLine().toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
          if (String.valueOf(chars[i]).matches("\\d")){
            result = result + chars[i];
          }
        }
        int numbers = Integer.parseInt(result);
        for (int i = 0; i < numbers; i++) {
          int dd = (new Random().nextInt((31) + 1));
          int mm = (new Random().nextInt((12 - 1) + 1) + 1);
          int yyyy = (new Random().nextInt((3000 - 1) + 1) + 1);
          int hh = (new Random().nextInt((23) + 1));
          int mi = (new Random().nextInt((59) + 1));
          int ss = (new Random().nextInt((59) + 1));
          int msm = (new Random().nextInt((999) + 1));
          times = Arrays.copyOf(times, i+1);
          times[i] = Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
              dd + "-" + mm + "-" + yyyy + " " + hh + ":" + mi + ":" + ss + ":" + msm , format);
        }
      }
      final Time[] timesSorted = new NixDate().sortTimesFromHightToLow(times);
      for (int i = 0; i < timesSorted.length; i++) {
        new Calendar().print((Calendar) timesSorted[i]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void subtract() {
    System.out
        .println("enter date exempl: Some text 04-07-2008 Some text 03:05:55:777 Some text");
    System.out
        .println("(default format only) if you want date from exempl, enter 1 or 2 if custom date");
    String firstDate = "Some text 04-07-2008 Some text 03:05:55:777 Some text";
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
        .println(
            "enter  date for subtract  exempl: Some text 01-02-0008 Some text 01:01:01:111 Some text");
    System.out.println(
        "(default format only) if you want date from exempl, enter 1 or else if custom date");
    String secondDate = "Some text 01-01-0008 Some text 01:02:01:111 Some text";
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
    new Calendar().print((Calendar) timeStart);
    new Calendar().print((Calendar) timeStop);
    new Calendar().print((Calendar) new NixDate().timeSubtractTime(timeStart, timeStop));
  }

  private void addToTimeDate() {
    System.out
        .println("enter date exempl: Some text 01-03-2002 Some text 00:00:55:777 Some text");
    System.out
        .println("(default format only) if you want date from exempl, enter 1 or 2 if custom date");
    String firstDate = "Some text 01-03-2002 Some text 00:00:55:777 Some text";
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
        .println("enter add date exempl: 04-02-2007 07:05:00:000 ");
    System.out.println(
        "(default format only) if you want date from exempl, enter 1 or else if custom date");
    String secondDate = " 04-02-2007  07:05:00:000 ";
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
    new Calendar().print((Calendar) timeStart);
    new Calendar().print((Calendar) timeStop);
    new Calendar().print((Calendar) new NixDate().timeAddTime(timeStart, timeStop));
  }

  private void differenceDates() {
    System.out
        .println("enter first date exempl:  09-10-2008 00:00:55:777 ");
    System.out
        .println("(default format only) if you want date from exempl, enter 1 or 2 if custom date");
    String firstDate = "09-10-2008 00:00:55:777 ";
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
        .println("enter second date exempl: 05-07-2004 01:10:55:777");
    System.out.println(
        "(default format only) if you want date from exempl, enter 1 or else if custom date");
    String secondDate = "05-07-2004 01:10:55:777 ";
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
    System.out.println("if you want result millisecond, enter 1");
    System.out.println("if you want result second,      enter 2");
    System.out.println("if you want result minute,      enter 3");
    System.out.println("if you want result hour,        enter 4");
    System.out.println("if you want result day,         enter 5");
    System.out.println("if you want result mounth,      enter 6");
    System.out.println("if you want result year,        enter 7");
    new Calendar().print((Calendar) timeStart);
    new Calendar().print((Calendar) timeStop);
    try {
      String answ = reader.readLine();
      switch (answ) {
        case "1":
          System.out.println(differenceBetweenDates.getTime() + " millisecond");
          break;
        case "2":
          System.out.println(differenceBetweenDates.getTime()/1000 + " second");
          break;
        case "3":
          System.out.println(differenceBetweenDates.getTime()/1000/60 + " minute");
          break;
        case "4":
          System.out.println(differenceBetweenDates.getTime()/1000/60/60 + " hour");
          break;
        case "5":
          System.out.println(differenceBetweenDates.getTime()/1000/60/60/24 + " day");
          break;
        case "6":
          System.out.println(new Calendar().getMounthsFromMiliseconds(differenceBetweenDates.getTime()) + " mounth");
          break;
        case "7":
          System.out.println(new Calendar().getYearsFromMiliseconds(differenceBetweenDates.getTime()) + " year");
          break;
        default:
          System.out.println("wrong choise!");
          break;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
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
        System.out.println("wrong choise!");

    }
  }
}
