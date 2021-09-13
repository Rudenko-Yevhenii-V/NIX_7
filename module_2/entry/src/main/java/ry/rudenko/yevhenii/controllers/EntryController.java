package ry.rudenko.yevhenii.controllers;


import java.io.File;
import ry.rudenko.yevhenii.FindFirstUniqueName;
import ry.rudenko.yevhenii.MostProfitableWay;
import ry.rudenko.yevhenii.ReturnListOfDates;
import ry.rudenko.yevhenii.util.ReadInputFiles;
import ry.rudenko.yevhenii.util.WriteOutputFiles;

public class EntryController {

  private static final String INPUT_FILE_NAMES = "../inputFiles" + File.separator + "names.txt";

  public void run() {
    FindFirstUniqueName findFirstUniqueName = new FindFirstUniqueName();
    final String firstUniqueName = findFirstUniqueName
        .findFirstUniqueName(new ReadInputFiles().getStringFromFile(INPUT_FILE_NAMES));
    System.out.println("firstUniqueName = " + firstUniqueName);
    new WriteOutputFiles().writeFileFromString(firstUniqueName, "outputName");

//    MostProfitableWay mostProfitableWay = new MostProfitableWay();
//    mostProfitableWay.mostProfitableWay();
//
//    ReturnListOfDates returnListOfDates = new ReturnListOfDates();
//    returnListOfDates.returnListOfDates();
  }

}
