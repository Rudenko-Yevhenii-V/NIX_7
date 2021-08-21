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
  public long days = 1;
  public long mounths = 1;
  public long years;

  public abstract boolean isLeapYear(long years);
  public abstract long daysInYear(long years);
  public abstract long getTime();
  public abstract long getMounthsFromMiliseconds(long milliseconds);
  public abstract long getYearsFromMiliseconds(long milliseconds);
  public abstract long getDaysFromMiliseconds(long milliseconds);
  public abstract long getHoursFromMiliseconds(long milliseconds);
  public abstract long getMinutesFromMiliseconds(long milliseconds);
  public abstract long getSecondsFromMiliseconds(long milliseconds);
  public abstract long getMillisecondsFromMiliseconds(long milliseconds);
  public abstract long daysInMounth(long numberOfMouth, long years);
  public abstract void addMilliseconds(long milliseconds);
  public abstract void subtractMilliseconds(long milliseconds);

}
