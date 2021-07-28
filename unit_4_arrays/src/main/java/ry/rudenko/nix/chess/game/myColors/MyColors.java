package ry.rudenko.nix.chess.game.myColors;

/**
 * MyColors
 * цвета текста в консоли
 */
public class MyColors {
    private static String shell = "";
    public static String ansiReset;
    public static String ansiBlack;
    public static String ansiRed;
    public static String ansiGreen;
    public static String ansiYellow;
    public static String ansiBlue;
    public static String ansiPurple;
    public static String ansiCyan;
    public static String ansiWhite;
    public static String ansiBlackBackground;
    public static String ansiRedBackground;
    public static String ansiGreenBackground;
    public static String ansiYellowBackground;
    public static String ansiBlueBackground;
    public static String ansiPurpleBackground;
    public static String ansiCyanBackground;
    public static String ansiWhiteBackground;

    public void setShell(String shell) {
        this.shell = shell;
    }

    public static String getShell() {
        return shell;
    }

    public MyColors() {

        if (!(shell.equals("shell"))) {
            ansiReset = "";
            ansiBlack = "";
            ansiRed = "";
            ansiGreen = "";
            ansiYellow = "";
            ansiBlue = "";
            ansiPurple = "";
            ansiCyan = "";
            ansiWhite = "";
            ansiBlackBackground = "";
            ansiRedBackground = "";
            ansiGreenBackground = "";
            ansiYellowBackground = "";
            ansiBlueBackground = "";
            ansiPurpleBackground = "";
            ansiCyanBackground = "";
            ansiWhiteBackground = "";
        } else {
            ansiReset = "\u001B[0m";
            ansiBlack = "\u001B[30m";
            ansiRed = "\u001B[31m";
            ansiGreen = "\u001B[32m";
            ansiYellow = "\u001B[33m";
            ansiBlue = "\u001B[34m";
            ansiPurple = "\u001B[35m";
            ansiCyan = "\u001B[36m";
            ansiWhite = "\u001B[37m";
            ansiBlackBackground = "\u001B[40m";
            ansiRedBackground = "\u001B[41m";
            ansiGreenBackground = "\u001B[42m";
            ansiYellowBackground = "\u001B[43m";
            ansiBlueBackground = "\u001B[44m";
            ansiPurpleBackground = "\u001B[45m";
            ansiCyanBackground = "\u001B[46m";
            ansiWhiteBackground = "\u001B[47m";
        }
    }


}
