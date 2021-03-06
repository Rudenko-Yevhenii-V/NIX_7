package someLogic;

import announcement.AnnouncNextStep;
import indata.ScannerConsole;
import customcolors.MyColors;
import task1.FindNumbersInAString;
import task2.FindAndCountSimbolInAString;
import task3.EndLessons;

/**
 * ProcessingTheResultOfTask
 * выбор задачи и вывод решения
 */
public class ProcessingTheResultOfTask {

    String inChoise;

    public ProcessingTheResultOfTask(String inChoise) {
        MyColors myColors = new MyColors();
        String EnterYourTEXT = myColors.ANSI_PURPLE + "Enter your text:" + myColors.ANSI_RESET;
        this.inChoise = inChoise;
        switch (inChoise) {
            case "1": {
                System.out.println(EnterYourTEXT);
                FindNumbersInAString findNumbersInAString = new FindNumbersInAString(new ScannerConsole().getOutConsoleScanner());
                System.out.println(myColors.ANSI_BLUE + "ANSWER : " + myColors.ANSI_RED + findNumbersInAString.getResult() + myColors.ANSI_RESET);
                new AnnouncNextStep().sayAboutNextStep();
            }
            break;
            case "2": {
                System.out.println(EnterYourTEXT);
                new FindAndCountSimbolInAString(new ScannerConsole().getOutConsoleScanner());
                System.out.println();
                new AnnouncNextStep().sayAboutNextStep();
            }
            break;
            case "3": {
                System.out.println("Enter Nnumber of lesson:");
                ScannerConsole scannerConsole = new ScannerConsole();
                String scaner = scannerConsole.getOutConsoleScanner();
                String exp = "\\d+";
                if (scaner.equals("10")) {
                    new EndLessons(Integer.parseInt(scaner));
                } else if ((scaner).matches(exp)) {
                    char one = scaner.charAt(0);
                    new EndLessons(Integer.parseInt(String.valueOf(one)));
                } else {
                    System.out.println("ENTER NUMBER! Try again");
                    new AnnouncNextStep().sayAboutNextStep();
                }
                new AnnouncNextStep().sayAboutNextStep();

            }
            break;
            default: {
                System.out.println("EXIT!!! ");
                System.exit(0);
            }
            break;
        }
    }
}
