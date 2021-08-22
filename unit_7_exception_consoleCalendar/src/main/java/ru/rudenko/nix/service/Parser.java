package ru.rudenko.nix.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;

public class Parser {

  private long time;
  private long milliseconds;
  private long seconds;
  private long minutes;
  private long hours;
  private long days;
  private long mounths = 1;
  private long years;
  private boolean isHaveDate = false;
  private final boolean isHaveTime = false;
  private String format = "";
  private static final Parser instance = new Parser();

  public static Parser getInstance() {
    return instance;
  }

  private Parser() {
  }

  public Time ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(String ddMmYyyyHhMmSsMSms,
      String format) {
    this.format = format;
    String check = ddMmYyyyHhMmSsMSms.toLowerCase();
    ddMmYyyyHhMmSsMSms = check.replaceAll("( )+", " ");
    parseTimeFromDdMmYyyyHhMmSsMSms(ddMmYyyyHhMmSsMSms);
    ddMmYyyyHhMmSsMSms = formatStrindCastToDateFormat(ddMmYyyyHhMmSsMSms);
    parseDateFromDdMmYyyyHhMmSsMSms(ddMmYyyyHhMmSsMSms);
    return new Calendar(milliseconds, seconds, minutes, hours, days, mounths, years);
  }

  private String formatStrindCastToDateFormat(String ddMmYyyyHhMmSsMSms) {
    if (format.equals("dd/mm/yy hh:mm:ss:msmsms")) {
      Matcher takeDate = Pattern.compile("(\\d\\d|\\d| )"
          + "[- /.]"
          + "(\\d\\d)"
          + "[- /.]"
          + "(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
          + "").matcher(ddMmYyyyHhMmSsMSms);
      char spliter = '/';
      if (takeDate.find()) {
        String castDate = takeDate.group();
        if (!String.valueOf(castDate.charAt(0)).matches("\\d")) {
          spliter = castDate.charAt(0);
        }
        if (!String.valueOf(castDate.charAt(1)).matches("\\d")) {
          spliter = castDate.charAt(1);
        }
        if (!String.valueOf(castDate.charAt(2)).matches("\\d")) {
          spliter = castDate.charAt(2);
        }
        System.out.println(castDate + " eto data mm/dd/yyyy-" + spliter + "-spliter");
        String[] splitArray = castDate.split(String.valueOf(spliter));
        String outPut = splitArray[0] + "/" + splitArray[1] + "/" + splitArray[2];
        System.out.println("outPut = " + outPut);
        return outPut;
      }
    }

    if (format.equals("mm/dd/yy hh:mm:ss:msmsms")) {
      Matcher takeDate = Pattern.compile("(\\d\\d|\\d| )"
          + "[- /.]"
          + "(\\d\\d)"
          + "[- /.]"
          + "(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
          + "").matcher(ddMmYyyyHhMmSsMSms);
      char spliter = '/';
      if (takeDate.find()) {
        String castDate = takeDate.group();
        if (!String.valueOf(castDate.charAt(0)).matches("\\d")) {
          spliter = castDate.charAt(0);
        }
        if (!String.valueOf(castDate.charAt(1)).matches("\\d")) {
          spliter = castDate.charAt(1);
        }
        if (!String.valueOf(castDate.charAt(2)).matches("\\d")) {
          spliter = castDate.charAt(2);
        }
        System.out.println(castDate + " eto data mm/dd/yyyy-" + spliter + "-spliter");
        String[] splitArray = castDate.split(String.valueOf(spliter));
        String[] outPutSplitArray = new String[splitArray.length];
        outPutSplitArray[0] = splitArray[1];
        outPutSplitArray[1] = splitArray[0];
        outPutSplitArray[2] = splitArray[2];
        String outPut = outPutSplitArray[0] + "/" + outPutSplitArray[1] + "/" + outPutSplitArray[2];
        System.out.println("outPut = " + outPut);
        return outPut;
      }
    }
    if (format.equals("mmm/dd/yy hh:mm:ss:msmsms")) {
      System.out.println("mmm/dd/yy");
      Matcher takeDate = Pattern.compile(
          "(янв(?:аря)?|фев(?:раля)?|мар(?:та)?|апр(?:еля)?|мая|июн(?:я)?|июл(?:я)?|авг(?:уста)?|сен(?:тября)?|окт(?:ября)?|ноя(?:бря)?|дек(?:абря)?|"
              + "january?|february?|march?|april?|may|june?|july?|august?|september?|october?|november?|december?)"
              + "[- /.]"
              + "(\\d\\d)"
              + "[- /.]"
              + "(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
              + "").matcher(ddMmYyyyHhMmSsMSms);
      char spliter = '/';
      if (takeDate.find()) {
        String castDate = takeDate.group();
        System.out.println("castDate = " + castDate);
        char[] charsOfCastDate = castDate.toCharArray();
        for (int i = 0; i < charsOfCastDate.length; i++) {
          if (String.valueOf(charsOfCastDate[i]).matches("([/]|[ ]|[.]|[-])")){
            System.out.println(charsOfCastDate[i] + " charsOfCastDate[i]");
            spliter = charsOfCastDate[i];
            break;
          }
        }
        System.out.println(castDate + " eto data mm/dd/yyyy-" + spliter + "-spliter");
        String[] splitArray = castDate.split(String.valueOf(spliter));
        switch (splitArray[0]){
          case "января": splitArray[0] ="01";
          break;
          case "февраля": splitArray[0] ="02";
            break;
          case "марта": splitArray[0] ="03";
            break;
          case "апреля": splitArray[0] ="04";
            break;
          case "мая": splitArray[0] ="05";
            break;
          case "июня": splitArray[0] ="06";
            break;
          case "июля": splitArray[0] ="07";
            break;
          case "августа": splitArray[0] ="08";
            break;
          case "сентября": splitArray[0] ="09";
            break;
          case "октября": splitArray[0] ="10";
            break;
          case "ноября": splitArray[0] ="11";
            break;
          case "декабря": splitArray[0] ="12";
            break;
        }
        String[] outPutSplitArray = new String[splitArray.length];
        outPutSplitArray[0] = splitArray[1];
        outPutSplitArray[1] = splitArray[0];
        outPutSplitArray[2] = splitArray[2];
        String outPut = outPutSplitArray[0] + "/" + outPutSplitArray[1] + "/" + outPutSplitArray[2];
        System.out.println("outPut = " + outPut);
        return outPut;
      }
    }
    if (format.equals("dd/mmm/yy hh:mm:ss:msmsms")) {
      System.out.println("mmm/dd/yy");
      Matcher takeDate = Pattern.compile("(\\d\\d|\\d| )"
          + "[- /.]"
          + "(янв(?:аря)?|фев(?:раля)?|мар(?:та)?|апр(?:еля)?|мая|июн(?:я)?|июл(?:я)?|авг(?:уста)?|сен(?:тября)?|окт(?:ября)?|ноя(?:бря)?|дек(?:абря)?|"
          + "january?|february?|march?|april?|may|june?|july?|august?|september?|october?|november?|december?)"
          + "[- /.]"
          + "(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
          + "").matcher(ddMmYyyyHhMmSsMSms);
      char spliter = '/';
      if (takeDate.find()) {
        String castDate = takeDate.group();
        System.out.println("castDate = " + castDate);
        char[] charsOfCastDate = castDate.toCharArray();
        for (int i = 0; i < charsOfCastDate.length; i++) {
          if (String.valueOf(charsOfCastDate[i]).matches("([/]|[ ]|[.]|[-])")){
            System.out.println(charsOfCastDate[i] + " charsOfCastDate[i]");
            spliter = charsOfCastDate[i];
            break;
          }
        }
        System.out.println(castDate + " eto data mm/dd/yyyy-" + spliter + "-spliter");
        String[] splitArray = castDate.split(String.valueOf(spliter));
        if (splitArray[1].matches("\\w{3,10}")){
          switch (splitArray[1]){
            case "january": splitArray[1] ="01";
              break;
            case "february": splitArray[1] ="02";
              break;
            case "march": splitArray[1] ="03";
              break;
            case "april": splitArray[1] ="04";
              break;
            case "may": splitArray[1] ="05";
              break;
            case "june": splitArray[1] ="06";
              break;
            case "july": splitArray[1] ="07";
              break;
            case "august": splitArray[1] ="08";
              break;
            case "september": splitArray[1] ="09";
              break;
            case "october": splitArray[1] ="10";
              break;
            case "november": splitArray[1] ="11";
              break;
            case "december": splitArray[1] ="12";
              break;
          }
        }else {
          switch (splitArray[1]){
            case "января": splitArray[1] ="01";
              break;
            case "февраля": splitArray[1] ="02";
              break;
            case "марта": splitArray[1] ="03";
              break;
            case "апреля": splitArray[1] ="04";
              break;
            case "мая": splitArray[1] ="05";
              break;
            case "июня": splitArray[1] ="06";
              break;
            case "июля": splitArray[1] ="07";
              break;
            case "августа": splitArray[1] ="08";
              break;
            case "сентября": splitArray[1] ="09";
              break;
            case "октября": splitArray[1] ="10";
              break;
            case "ноября": splitArray[1] ="11";
              break;
            case "декабря": splitArray[1] ="12";
              break;
          }

        }

        String outPut = splitArray[0] + "/" + splitArray[1] + "/" + splitArray[2];
        System.out.println("outPut = " + outPut);
        return outPut;
      }
    }
    return ddMmYyyyHhMmSsMSms;
  }

  private void parseTimeFromDdMmYyyyHhMmSsMSms(String ddMmYyyyHhMmSsMSms) {

    Matcher matcherTimeNumbers = Pattern
        .compile(
            "([0-9]|0[0-9]|1[0-9]|2[0-3]|)[:]([0-9]|[0-5][0-9]|)[:]([0-9]|[0-5][0-9]|)[:](\\d\\d\\d|\\d\\d|\\d| )")
        .matcher(ddMmYyyyHhMmSsMSms);

    if (matcherTimeNumbers.find()) {
      isHaveDate = true;
      String buf = matcherTimeNumbers.group();
      System.out.println("buf time = " + buf);

      if (!buf.matches("\\d\\d:\\d\\d:\\d\\d:\\d\\d\\d")) {
        String[] split = buf.split("\\:");
        buf = "";
        for (int i = 0; i < split.length; i++) {
          if (split[i].matches("")) {
            split[i] = "00";
          }
          if (split[i].matches("\\d")) {
            split[i] = "0" + split[i];
          }
          if (i == split.length - 1) {
            if (split[i].matches(" ")) {
              split[i] = "000";
            }
            if (split[i].matches("\\d")) {
              split[i] = "00" + split[i];
            }

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
            hours = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 2:
            minutes = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 3:
            seconds = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
          case 4:
            milliseconds = Long.parseLong(ddMmYyyyHhMmSsMSmsArray[i]);
            break;
        }

      }
    }
  }

  //  (00|20)[0-9][0-9]|[0-9][0-9][0-9]|[0-9][0-9]|[0-9]|
  private void parseDateFromDdMmYyyyHhMmSsMSms(String ddMmYyyyHhMmSsMSms) {

    String regexHyphen = "(0[1-9]|[12][0-9]|3[01]|[0-9]|)"
        + "([/])(0[1-9]|1[012]|[1-9]|)"
        + "([/])(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )";
    Matcher matcherDateNumbers = Pattern.compile(regexHyphen)
        .matcher(ddMmYyyyHhMmSsMSms);
    if (matcherDateNumbers.find()) {
      isHaveDate = true;
      StringBuilder buf = new StringBuilder(matcherDateNumbers.group());
      char charSplitDate = '/';
      char[] charBufArrays = buf.toString().toCharArray();
      for (char charBufArray : charBufArrays) {
        if (!(String.valueOf(charBufArray).matches("[0-9]"))) {
          charSplitDate = charBufArray;
          break;
        }
      }
      if (!buf.toString().matches("\\d\\d[/]\\d\\d[/]\\d\\d\\d\\d")) {
        String[] split = buf.toString().split(String.valueOf(charSplitDate));
        buf = new StringBuilder();
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
            buf.append(split[i]);
            break;
          }
          buf.append(split[i]).append("/");

        }
      }
      String[] ddMmYyyyHhMmSsMSmsArray = buf.toString().split("/");

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
