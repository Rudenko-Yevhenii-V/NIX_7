package ru.rudenko.nix.data;


/**
 * @author Rudenko Yevhenii
 */

public abstract class Time {
  public long time;
  public long milliseconds;
  public long seconds;
  public long minutes;
  public long hours;
  public long days;
  public long mounths = 1;
  public long years;

  public abstract boolean isLeapYear(long years);
  public abstract long daysInYear(long years);
  public abstract long getTime();
  public abstract long getMounths(long milliseconds);
  public abstract long getYears(long milliseconds);
  public abstract long getDays(long milliseconds);
  public abstract long getHours(long milliseconds);
  public abstract long getMinutes(long milliseconds);
  public abstract long getSeconds(long milliseconds);
  public abstract long getMilliseconds(long milliseconds);
  public abstract long daysInMounth(long numberOfMouth, long years);
  public abstract void addMilliseconds(long milliseconds);
  public abstract void subtractMilliseconds(long milliseconds);

}