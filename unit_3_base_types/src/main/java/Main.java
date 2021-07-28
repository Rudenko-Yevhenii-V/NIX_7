import announcement.AnnouncEnter;
import inData.ScannerConsole;
import myColors.MyColors;
import someLogic.ProcessingTheResultOfTask;

public class Main {

  public static void main(String[] args) {
    for (String arg : args) {
      new MyColors().setShell(arg);
    }
    new AnnouncEnter().sayChoiseTask();
    ScannerConsole scannerConsole = new ScannerConsole();
    new ProcessingTheResultOfTask(scannerConsole.getOutConsoleScanner());

    System.out.print("\033[H\033[2J");

  }
}
