package announcement;

import indata.ScannerConsole;
import customcolors.MyColors;
import someLogic.ProcessingTheResultOfTask;

public class AnnouncNextStep {

    public void sayAboutNextStep() {
        MyColors myColors = new MyColors();
        System.out.printf("%30s", "what task do solve?");
        System.out.println("");
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-the first about  sum of numbers in a line?   ", myColors.ANSI_RED + "Enter 1" + myColors.ANSI_RESET);
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-the second about counter characters in a line?   " , myColors.ANSI_RED + "Enter 2" + myColors.ANSI_RESET);
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-the third about  end of the lesson?   " , myColors.ANSI_RED + "Enter 3" + myColors.ANSI_RESET);
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-EXIT?   " , myColors.ANSI_RED + "Enter any" + myColors.ANSI_RESET);

        new ProcessingTheResultOfTask(new ScannerConsole().getOutConsoleScanner());
    }
}
