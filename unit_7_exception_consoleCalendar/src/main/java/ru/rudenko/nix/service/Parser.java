package ru.rudenko.nix.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 1:00 PM
 * @project NIX_7
 */
public class Parser {

  private long time;
  private long milliseconds;
  private long seconds;
  private long minutes;
  private long hours;
  private long days;
  private long mounths = 1;
  private long years;
  private Character charSplitDate;
  boolean isHaveDate = false;
  boolean isHaveTime = false;

  public Time ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(String ddMmYyyyHhMmSsMSms) {
    String check = ddMmYyyyHhMmSsMSms;
    ddMmYyyyHhMmSsMSms = check.replaceAll("( )+", " ");
//    System.out.println(isHaveDate + " isHaveDate");
//    System.out.println("isHaveTime = " + isHaveTime);
    ParseDateFromDdMmYyyyHhMmSsMSms(ddMmYyyyHhMmSsMSms);
    ParseTimeFromDdMmYyyyHhMmSsMSms(ddMmYyyyHhMmSsMSms);

//    System.out.println(isHaveDate+ " isHaveDate");
//    System.out.println("isHaveTime = " + isHaveTime);

    return new Calendar(milliseconds, seconds, minutes, hours, days, mounths, years);
  }

  private void ParseTimeFromDdMmYyyyHhMmSsMSms(String ddMmYyyyHhMmSsMSms) {
    Matcher matcherTimeNumbers = Pattern
        .compile(
            "([0-9]|0[0-9]|1[0-9]|2[0-3]|)[:]([0-9]|[0-5][0-9]|)[:]([0-9]|[0-5][0-9]|)[:]([0-9]|[0-9][0-9]|([0-9][0-9][0-9])|)")
        .matcher(ddMmYyyyHhMmSsMSms);

    if (matcherTimeNumbers.find()) {
      isHaveDate = true;
      String buf = matcherTimeNumbers.group();
      System.out.println("buf1 =" + buf);
      if (!buf.matches("\\d\\d:\\d\\d:\\d\\d:\\d\\d\\d")) {
        String[] split = buf.split("\\:");
        buf = "";
        System.out.println(
            "split.length = " + split.length + " ---" + split[0] + " + " + split[split.length - 1]);
        for (int i = 0; i < split.length; i++) {
          System.out.println(split[i]);
          if (split[i].matches("")) {
            split[i] = "00";
          }
          if (split[i].matches("\\d")) {
            split[i] = "0" + split[i];
          }
          if (i == split.length - 1) {
            if (split[i].matches("\\d\\d")) {
              split[i] = "0" + split[i];
            }
          }
          if (i == split.length - 1) {
            buf = buf + split[i];
            break;
          }
          buf = buf + split[i] + ":";

        }
      }
      System.out.println("buf2 = " + buf);

      String ddMmYyyyHhMmSsMSmsFirstElem = String.valueOf(buf.charAt(0));
      if (ddMmYyyyHhMmSsMSmsFirstElem.equals(":")) {
        buf = "00" + buf;
      }
      String ddMmYyyyHhMmSsMSmsLastElem = String.valueOf(buf.charAt(buf.length() - 1));
      if (ddMmYyyyHhMmSsMSmsFirstElem.equals(":")) {
        buf = buf + "0000";
      }
      char[] charsBuf = buf.toCharArray();
      for (int i = 0; i < charsBuf.length; i++) {
        if (String.valueOf(charsBuf[i]).equals(":")) {
          if (String.valueOf(charsBuf[i + 1]).equals(":")) {
            buf = buf.substring(0, i + 1) + "01" + buf.substring(i + 1, buf.length());
          }
        }
      }

      Character charSplit = buf.toCharArray()[2];
      String[] ddMmYyyyHhMmSsMSmsArray;
      if (charSplit.equals('.')) {
        ddMmYyyyHhMmSsMSmsArray = buf.split("\\.");
      } else {
        ddMmYyyyHhMmSsMSmsArray = buf.split(String.valueOf(charSplit));
      }
      for (int i = 0; i < ddMmYyyyHhMmSsMSmsArray.length; i++) {
        switch (i + 1) {
          case 1:
            System.out.println(ddMmYyyyHhMmSsMSmsArray[i] + " hours");
            hours = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 2:
            System.out.println(ddMmYyyyHhMmSsMSmsArray[i] + " minutes");
            minutes = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 3:
            System.out.println(ddMmYyyyHhMmSsMSmsArray[i] + " seconds");
            seconds = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 4:
            System.out.println(ddMmYyyyHhMmSsMSmsArray[i] + " milliseconds");
            milliseconds = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
        }

      }
    }
  }

  //  (00|20)[0-9][0-9]|[0-9][0-9][0-9]|[0-9][0-9]|[0-9]|
  private void ParseDateFromDdMmYyyyHhMmSsMSms(String ddMmYyyyHhMmSsMSms) {
    String regexHyphen = "(0[1-9]|[12][0-9]|3[01]|[0-9]|)"
        + "([-])(0[1-9]|1[012]|[1-9]|)"
        + "([-])((19|20)\\d\\d|\\d\\d\\d|\\d\\d|\\d| )";
    String regexMinus = "(0[1-9]|[12][0-9]|3[01])[−](0[1-9]|1[012])[−](19|20)\\d\\d";
    String regexDot = "(0[1-9]|[12][0-9]|3[01])[\\.](0[1-9]|1[012])[\\.](19|20)\\d\\d";
    String regexBackslash = "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d";
    String regexSpase = "(0[1-9]|[12][0-9]|3[01])[ ](0[1-9]|1[012])[ ](19|20)\\d\\d";
    System.out.println("ddMmYyyyHhMmSsMSms = " + ddMmYyyyHhMmSsMSms);
    Matcher matcherDateNumbers = Pattern.compile(regexHyphen)
        .matcher(ddMmYyyyHhMmSsMSms);
    if (matcherDateNumbers.find()) {
      isHaveDate = true;
      String buf = matcherDateNumbers.group();
      System.out.println("buf1 =" + buf);
      charSplitDate = '/';
      char[] charBufArrays = buf.toCharArray();
      for (int i = 0; i < charBufArrays.length; i++) {
        if (!(String.valueOf(charBufArrays[i]).matches("[0-9]"))) {
          charSplitDate = charBufArrays[i];
          break;
        }
      }
      if (!buf.matches("\\d\\dcharSplit\\d\\dcharSplit\\d\\d\\d\\d")) {
        String[] split = buf.split(String.valueOf(charSplitDate));
        buf = "";
        for (int i = 0; i < split.length; i++) {

          if (split[i].matches("")) {
            split[i] = "00";
          }
          if (split[i].matches("\\d")) {
            split[i] = "0" + split[i];
          }

          if (i == split.length - 1) {
            if (split[i].matches("\\d\\d\\d")) {
              split[i] = "0" + split[i];
            }
            if (split[i].matches("\\d\\d")) {
              split[i] = "00" + split[i];
            }
            if (split[i].matches("\\d")) {
              split[i] = "000" + split[i];
            }
            if (split[i].matches("")) {
              split[i] = "0000" + split[i];
            }
          }
          if (i == split.length - 1) {
            buf = buf + split[i];
            break;
          }
          buf = buf + split[i] + "/";

        }
      }
      System.out.println("buf2 = " + buf);

      String[] ddMmYyyyHhMmSsMSmsArray = buf.split("/");

      for (int i = 0; i < ddMmYyyyHhMmSsMSmsArray.length; i++) {
        switch (i + 1) {
          case 1:
            days = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 2:
            mounths = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 3:
            years = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
        }
      }
    }
  }
}
