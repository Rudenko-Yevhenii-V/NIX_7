package ru.rudenko.nix;

import ru.rudenko.nix.data.Calendar;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 12:41 PM
 * @project NIX_7
 */
public class Unit7Main {

  private static long year = 2024;

  public static void main(String[] args) throws InterruptedException {
    //86400000 day
    //3600000 hour
    //60000 min
    //1000 sec
    long milisek = (long) 2021 * 365 * 86_400_000;
    Calendar calendar = new Calendar(864000001);
    calendar.print(calendar);
    calendar.addMilliseconds(100000000000L);
    calendar.print(calendar);
    while (true) {
      calendar.addMilliseconds(1000);
      Thread.sleep(1000);
      calendar.print(calendar);
    }
  }
}
