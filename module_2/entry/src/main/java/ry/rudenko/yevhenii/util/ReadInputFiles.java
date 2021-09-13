package ry.rudenko.yevhenii.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReadInputFiles {

  public String getStringFromFile(String INPUT_FILE) {
    try {
      try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
        return br.lines().collect(Collectors.joining(System.lineSeparator()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
