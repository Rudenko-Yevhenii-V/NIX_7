package ry.rudenko.yevhenii.controllers;


import java.io.File;
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
    FindFirstUniqueName findFirstUniqueName = new FindFirstUniqueName();
    final String firstUniqueName = findFirstUniqueName
        .findFirstUniqueName(new ReadInputFiles().getStringFromFile(INPUT_FILE_NAMES));
    System.out.println("firstUniqueName = " + firstUniqueName);
    new WriteOutputFiles().writeFileFromString(firstUniqueName, "outputName");

    ReturnListOfDates returnListOfDates = new ReturnListOfDates();
    final String stringFromFileDates = new ReadInputFiles().getStringFromFile(INPUT_FILE_DATES);
    final String returnDates = returnListOfDates.returnListOfDates(stringFromFileDates);
    System.out.println("returnDates = " + returnDates);
    new WriteOutputFiles().writeFileFromString(returnDates, "outputDates");

    MostProfitableWay mostProfitableWay = new MostProfitableWay();
        final String stringFromFileCity = new ReadInputFiles().getStringFromFile(INPUT_FILE_CITY);
    new WriteOutputFiles().writeFileFromString(mostProfitableWay
        .mostProfitableWay(stringFromFileCity), "outputCityPrice");
    System.out.println(
        "mostProfitableWay.mostProfitableWay(stringFromFileCity) = \n" + mostProfitableWay
            .mostProfitableWay(stringFromFileCity));


  }

}
