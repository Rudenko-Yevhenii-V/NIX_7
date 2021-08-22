package ru.rudenko.nix.exceptionsC;

public class SimulatedException extends Exception {
    private static String message = "hey dude something is wrong... ";

    public SimulatedException(String ex) {
        super(message + ex);
    }
}
