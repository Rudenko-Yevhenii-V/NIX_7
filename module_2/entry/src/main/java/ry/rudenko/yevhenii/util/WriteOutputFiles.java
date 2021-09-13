package ry.rudenko.yevhenii.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOutputFiles {
  public void writeFileFromString(String inputString, String nameOfFile) {

    File file = new File("../outputFiles" + File.separator + nameOfFile + ".txt");
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
    ) {
      bufferedWriter.write(inputString);
    } catch (IOException e) {
      System.out.println("e = " + e.getMessage());
    }
  }
}
