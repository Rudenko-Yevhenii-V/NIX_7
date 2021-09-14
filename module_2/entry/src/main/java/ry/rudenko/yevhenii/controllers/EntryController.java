package ry.rudenko.yevhenii.controllers;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import ry.rudenko.yevhenii.FindFirstUniqueName;
import ry.rudenko.yevhenii.MostProfitableWay;
import ry.rudenko.yevhenii.ReturnListOfDates;
import ry.rudenko.yevhenii.util.ReadInputFiles;
import ry.rudenko.yevhenii.util.WriteOutputFiles;

public class EntryController {

  private static final String INPUT_FILE_NAMES = "../inputFiles" + File.separator + "names.txt";
  private static final String INPUT_FILE_DATES = "../inputFiles" + File.separator + "dates.txt";
  private static final String INPUT_FILE_CITY = "../inputFiles" + File.separator + "input.txt";

  public void run() {
    System.out.println("\n\n\n\nfor task 1 -  enter 1");
    System.out.println("for task 2 -  enter 2");
    System.out.println("for task 3 -  enter 3");
    System.out.println("for EXIT -  enter anyKey");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      String enterLine = br.readLine();
      if (enterLine.equals("1")){
        FindFirstUniqueName findFirstUniqueName = new FindFirstUniqueName();
        final String stringFromFile = new ReadInputFiles().getStringFromFile(INPUT_FILE_NAMES);
        System.out.println(stringFromFile);
        final String firstUniqueName = findFirstUniqueName
            .findFirstUniqueName(stringFromFile);
        System.out.println("first unique name : " + firstUniqueName);
        new WriteOutputFiles().writeFileFromString(firstUniqueName, "outputName");
        System.out.println("press enter to continue!");
        br.readLine();
        run();
      }
      if (enterLine.equals("2")){
        ReturnListOfDates returnListOfDates = new ReturnListOfDates();
        final String stringFromFileDates = new ReadInputFiles().getStringFromFile(INPUT_FILE_DATES);
        System.out.println(stringFromFileDates);
        final String returnDates = returnListOfDates.returnListOfDates(stringFromFileDates);
        System.out.println("valid and formatted dates : " + returnDates);
        new WriteOutputFiles().writeFileFromString(returnDates, "outputDates");
        System.out.println("press enter to continue!");
        br.readLine();
        run();
      }
      if (enterLine.equals("3")){
        MostProfitableWay mostProfitableWay = new MostProfitableWay();
        final String stringFromFileCity = new ReadInputFiles().getStringFromFile(INPUT_FILE_CITY);
        System.out.println(stringFromFileCity);
        new WriteOutputFiles().writeFileFromString(mostProfitableWay
            .mostProfitableWay(stringFromFileCity), "outputCityPrice");
        System.out.println(
            "cost of the ways : \n" + mostProfitableWay
                .mostProfitableWay(stringFromFileCity));
        System.out.println("press enter to continue!");
        br.readLine();
        run();
      }
      System.exit(0);
    } catch (IOException e) {
      e.printStackTrace();
    }





  }
}
