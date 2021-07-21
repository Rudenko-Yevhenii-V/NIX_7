import announcement.AnnouncEnter;
import inData.ScannerConsole;
import someLogic.ProcessingTheResultOfTask;

public class Main {

    public static void main(String[] args) {
        new AnnouncEnter().sayChoiseTask();
        ScannerConsole scannerConsole = new ScannerConsole();
        new ProcessingTheResultOfTask(scannerConsole.getOutConsoleScanner());

    }
}
