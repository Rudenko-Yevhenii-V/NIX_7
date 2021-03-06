package ru.rudenko.nix.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;

public class Parser {

  private long milliseconds;
  private long seconds;
  private long minutes;
  private long hours;
  private long days;
  private long mounths = 1;
  private long years;
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
        String[] splitArray = castDate.split(String.valueOf(spliter));
        return splitArray[0] + "/" + splitArray[1] + "/" + splitArray[2];
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
        String[] splitArray = castDate.split(String.valueOf(spliter));
        String[] outPutSplitArray = new String[splitArray.length];
        outPutSplitArray[0] = splitArray[1];
        outPutSplitArray[1] = splitArray[0];
        outPutSplitArray[2] = splitArray[2];
        return outPutSplitArray[0] + "/" + outPutSplitArray[1] + "/" + outPutSplitArray[2];
      }
    }
    if (format.equals("mmm/dd/yy hh:mm:ss:msmsms")) {
      Matcher takeDate = Pattern.compile(
          "(??????(?:??????)?|??????(?:????????)?|??????(?:????)?|??????(?:??????)?|??????|??????(?:??)?|??????(?:??)?|??????(?:????????)?|??????(?:??????????)?|??????(?:????????)?|??????(?:??????)?|??????(?:????????)?|"
              + "january?|february?|march?|april?|may|june?|july?|august?|september?|october?|november?|december?)"
              + "[- /.]"
              + "(\\d\\d)"
              + "[- /.]"
              + "(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
              + "").matcher(ddMmYyyyHhMmSsMSms);
      char spliter = '/';
      if (takeDate.find()) {
        String castDate = takeDate.group();
        char[] charsOfCastDate = castDate.toCharArray();
        for (char c : charsOfCastDate) {
          if (String.valueOf(c).matches("([/]|[ ]|[.]|[-])")) {
            spliter = c;
            break;
          }
        }
        String[] splitArray = castDate.split(String.valueOf(spliter));
        if (splitArray[0].matches("\\w{3,10}")){
          switch (splitArray[0]){
            case "january": splitArray[0] ="01";
              break;
            case "february": splitArray[0] ="02";
              break;
            case "march": splitArray[0] ="03";
              break;
            case "april": splitArray[0] ="04";
              break;
            case "may": splitArray[0] ="05";
              break;
            case "june": splitArray[0] ="06";
              break;
            case "july": splitArray[0] ="07";
              break;
            case "august": splitArray[0] ="08";
              break;
            case "september": splitArray[0] ="09";
              break;
            case "october": splitArray[0] ="10";
              break;
            case "november": splitArray[0] ="11";
              break;
            case "december": splitArray[0] ="12";
              break;
          }
        }else {
          switch (splitArray[0]){
            case "????????????": splitArray[0] ="01";
              break;
            case "??????????????": splitArray[0] ="02";
              break;
            case "??????????": splitArray[0] ="03";
              break;
            case "????????????": splitArray[0] ="04";
              break;
            case "??????": splitArray[0] ="05";
              break;
            case "????????": splitArray[0] ="06";
              break;
            case "????????": splitArray[0] ="07";
              break;
            case "??????????????": splitArray[0] ="08";
              break;
            case "????????????????": splitArray[0] ="09";
              break;
            case "??????????????": splitArray[0] ="10";
              break;
            case "????????????": splitArray[0] ="11";
              break;
            case "??????????????": splitArray[0] ="12";
              break;
          }
        }
        String[] outPutSplitArray = new String[splitArray.length];
        outPutSplitArray[0] = splitArray[1];
        outPutSplitArray[1] = splitArray[0];
        outPutSplitArray[2] = splitArray[2];
        return outPutSplitArray[0] + "/" + outPutSplitArray[1] + "/" + outPutSplitArray[2];
      }
    }
    if (format.equals("dd/mmm/yy hh:mm:ss:msmsms")) {
      Matcher takeDate = Pattern.compile("(\\d\\d|\\d| )"
          + "[- /.]"
          + "(??????(?:??????)?|??????(?:????????)?|??????(?:????)?|??????(?:??????)?|??????|??????(?:??)?|??????(?:??)?|??????(?:????????)?|??????(?:??????????)?|??????(?:????????)?|??????(?:??????)?|??????(?:????????)?|"
          + "january?|february?|march?|april?|may|june?|july?|august?|september?|october?|november?|december?)"
          + "[- /.]"
          + "(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
          + "").matcher(ddMmYyyyHhMmSsMSms);
      char spliter = '/';
      if (takeDate.find()) {
        String castDate = takeDate.group();
        char[] charsOfCastDate = castDate.toCharArray();
        for (char c : charsOfCastDate) {
          if (String.valueOf(c).matches("([/]|[ ]|[.]|[-])")) {
            spliter = c;
            break;
          }
        }
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
            case "????????????": splitArray[1] ="01";
              break;
            case "??????????????": splitArray[1] ="02";
              break;
            case "??????????": splitArray[1] ="03";
              break;
            case "????????????": splitArray[1] ="04";
              break;
            case "??????": splitArray[1] ="05";
              break;
            case "????????": splitArray[1] ="06";
              break;
            case "????????": splitArray[1] ="07";
              break;
            case "??????????????": splitArray[1] ="08";
              break;
            case "????????????????": splitArray[1] ="09";
              break;
            case "??????????????": splitArray[1] ="10";
              break;
            case "????????????": splitArray[1] ="11";
              break;
            case "??????????????": splitArray[1] ="12";
              break;
          }

        }

        return splitArray[0] + "/" + splitArray[1] + "/" + splitArray[2];
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
      StringBuilder buf = new StringBuilder(matcherTimeNumbers.group());

      if (!buf.toString().matches("\\d\\d:\\d\\d:\\d\\d:\\d\\d\\d")) {
        String[] split = buf.toString().split(":");
        buf = new StringBuilder();
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
            buf.append(split[i]);
            break;
          }
          buf.append(split[i]).append(":");

        }
      }

      String ddMmYyyyHhMmSsMSmsFirstElem = String.valueOf(buf.charAt(0));
      if (ddMmYyyyHhMmSsMSmsFirstElem.equals(":")) {
        buf.insert(0, "00");
      }
      if (ddMmYyyyHhMmSsMSmsFirstElem.equals(":")) {
        buf.append("0000");
      }
      char[] charsBuf = buf.toString().toCharArray();
      for (int i = 0; i < charsBuf.length; i++) {
        if (String.valueOf(charsBuf[i]).equals(":")) {
          if (String.valueOf(charsBuf[i + 1]).equals(":")) {
            buf = new StringBuilder(
                buf.substring(0, i + 1) + "01" + buf.substring(i + 1, buf.length()));
          }
        }
      }
      Character charSplit = buf.toString().toCharArray()[2];
      String[] ddMmYyyyHhMmSsMSmsArray;
      if (charSplit.equals('.')) {
        ddMmYyyyHhMmSsMSmsArray = buf.toString().split("\\.");
      } else {
        ddMmYyyyHhMmSsMSmsArray = buf.toString().split(String.valueOf(charSplit));
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
