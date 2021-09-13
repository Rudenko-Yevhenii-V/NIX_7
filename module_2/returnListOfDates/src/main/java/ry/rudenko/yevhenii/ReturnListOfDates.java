package ry.rudenko.yevhenii;


import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReturnListOfDates {

  public String returnListOfDates(String dates) {
    String output = "";
    Matcher takeDate = Pattern.compile("(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
        + "[-/]"
        + "(\\d\\d)"
        + "[-/]"
        + "(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d| )"
        + "").matcher(dates);
    while (takeDate.find()) {
      String castDate = takeDate.group();
      castDate = castDate.replaceAll("/", "-");
      String regexHyphen = "(\\d\\d\\d\\d)"
          + "([-])(0[1-9]|1[012])"
          + "([-])(0[1-9]|[12][0-9]|3[01])";
      if (castDate.matches("(\\d\\d)"
          + "[-/]"
          + "(\\d\\d)"
          + "[-/]"
          + "(\\d\\d\\d\\d)")) {
        final String[] split = castDate.split("-");
        Collections.reverse(Arrays.asList(split));
        castDate = "";
        for (String s : split) {
          castDate = castDate + s + "-";
        }
        castDate = castDate.substring(0, castDate.length() - 1);
      }
      Matcher matcherTimeNumbers = Pattern
          .compile(regexHyphen)
          .matcher(castDate);
      if (matcherTimeNumbers.find()) {
        final String group = matcherTimeNumbers.group();
        output = output + "\n" + group;
      }
    }
    output = output.replaceAll("-", "");
    return output;
  }
}
