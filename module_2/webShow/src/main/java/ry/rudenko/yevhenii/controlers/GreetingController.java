package ry.rudenko.yevhenii.controlers;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ry.rudenko.yevhenii.FindFirstUniqueName;
import ry.rudenko.yevhenii.MostProfitableWay;
import ry.rudenko.yevhenii.ReturnListOfDates;
import ry.rudenko.yevhenii.util.ReadInputFiles;
import ry.rudenko.yevhenii.util.WriteOutputFiles;

@Controller
public class GreetingController {

  private static final String INPUT_FILE_NAMES = "../inputFiles" + File.separator + "names.txt";
  private static final String INPUT_FILE_DATES = "../inputFiles" + File.separator + "dates.txt";
  private static final String INPUT_FILE_CITY = "../inputFiles" + File.separator + "input.txt";

  @GetMapping("/")
  public String greeting(
      @RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }

  @GetMapping("/one")
  public String one(
      @RequestParam(name = "nameone", required = false, defaultValue = "one") String name,
      Model model) {
    FindFirstUniqueName findFirstUniqueName = new FindFirstUniqueName();
    final String stringFromFile = new ReadInputFiles().getStringFromFile(INPUT_FILE_NAMES);
    final String firstUniqueName = findFirstUniqueName
        .findFirstUniqueName(stringFromFile);
    String out = "first unique name : " + firstUniqueName;
    new WriteOutputFiles().writeFileFromString(firstUniqueName, "outputName");
    name = stringFromFile;
    model.addAttribute("nameone", name);
    model.addAttribute("firstUniqueName", out);
    model.addAttribute("newLineChar", '\n');
    return "one";
  }

  @GetMapping("/two")
  public String two(
      @RequestParam(name = "nametwo", required = false, defaultValue = "two") String name,
      Model model) {
    ReturnListOfDates returnListOfDates = new ReturnListOfDates();
    final String stringFromFileDates = new ReadInputFiles().getStringFromFile(INPUT_FILE_DATES);
    final String returnDates = returnListOfDates.returnListOfDates(stringFromFileDates);
    String out = "valid and formatted dates : " + returnDates;
    new WriteOutputFiles().writeFileFromString(returnDates, "outputDates");
    name = stringFromFileDates;
    model.addAttribute("nametwo", name);
    model.addAttribute("firstUniqueName", out);
    return "two";
  }

  @GetMapping("/three")
  public String three(
      @RequestParam(name = "namethree", required = false, defaultValue = "three") String name,
      Model model) {
    MostProfitableWay mostProfitableWay = new MostProfitableWay();
    String stringFromFileCity = new ReadInputFiles().getStringFromFile(INPUT_FILE_CITY);
    new WriteOutputFiles().writeFileFromString(mostProfitableWay
        .mostProfitableWay(stringFromFileCity), "outputCityPrice");
    String out = "\ncost of the ways : \n" + mostProfitableWay
        .mostProfitableWay(stringFromFileCity);
    out = out.replaceAll("\n", "<br>");
    stringFromFileCity = stringFromFileCity.replaceAll("\n", "<br>");
    name = stringFromFileCity;
    model.addAttribute("namethree", name);
    model.addAttribute("firstUniqueName", out);
    return "three";
  }

}
