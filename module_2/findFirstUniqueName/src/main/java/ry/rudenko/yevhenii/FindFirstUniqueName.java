package ry.rudenko.yevhenii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class FindFirstUniqueName {

  public String findFirstUniqueName(String names) {
    final List<String> list = Arrays.asList(names.split("\n"));
    Set<String> setOfNames = new HashSet<>();
    List<String> temp = new ArrayList<>();
    for (String s : list) {
      if (!checkName(s)) {
        continue;
      }
      if (setOfNames.add(s)) {
        temp.add(s);
      } else {
        temp.remove(s);
      }
    }
    return temp.get(0);
  }

  public boolean checkName(String name) {
    if (!Character.isUpperCase(name.charAt(0))) {
      return false;
    }
    return Pattern.matches("^[\\p{L} .'-]*$", name);
  }
}
