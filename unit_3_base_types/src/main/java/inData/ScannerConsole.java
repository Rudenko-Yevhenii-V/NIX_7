package inData;

import java.util.Scanner;

/**
 * ScannerConsole
 * ввод с клавиатуры в консоль
 */
public class ScannerConsole {
    private String outConsole;
    Scanner scanner = new Scanner(System.in);
    public String getOutConsoleScanner() {
        outConsole = scanner.nextLine();
        return outConsole;
    }
}
