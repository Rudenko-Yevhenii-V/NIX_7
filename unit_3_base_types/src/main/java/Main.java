import announcement.AnnouncEnter;
import indata.ScannerConsole;
import customcolors.MyColors;
import someLogic.ProcessingTheResultOfTask;

public class Main {

    public static void main(String[] args) {
        for(String arg : args)
        {
            new MyColors().setShell(arg);
        }
        new AnnouncEnter().sayChoiseTask();
        ScannerConsole scannerConsole = new ScannerConsole();
        new ProcessingTheResultOfTask(scannerConsole.getOutConsoleScanner());
    }
}
