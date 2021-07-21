package announcement;

import myColors.MyColors;

/**
 * AnnouncEnter
 * вывод приглашения пользователя
 */
public class AnnouncEnter {
    public void sayChoiseTask(){
        MyColors myColors = new MyColors();
        System.out.printf("%30s", myColors.ANSI_GREEN + "HOMEWORK 3!" + myColors.ANSI_RESET);
        System.out.println();
        System.out.printf("%30s", "what task do solve first?");
        System.out.println("");
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-the first about  sum of numbers in a line?   ", myColors.ANSI_RED + "Enter 1" + myColors.ANSI_RESET);
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-the second about counter characters in a line?   " , myColors.ANSI_RED + "Enter 2" + myColors.ANSI_RESET);
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-the third about  end of the lesson?   " , myColors.ANSI_RED + "Enter 3" + myColors.ANSI_RESET);
        System.out.printf("%-58s | %10s%n",myColors.ANSI_PURPLE + "-EXIT?   " , myColors.ANSI_RED + "Enter any" + myColors.ANSI_RESET);


    }
}
