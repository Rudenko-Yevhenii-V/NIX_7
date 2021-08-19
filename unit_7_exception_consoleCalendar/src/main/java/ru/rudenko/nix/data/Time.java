package ru.rudenko.nix.data;

/**
 * @author Rudenko Yevhenii
 *
 */
public abstract class Time {
  private static final long startCalendar = 0L;
  private static final long  millisecond= 1L;
  private static final long second = 1000 * millisecond;
  private static final long minute = 60 * second;
  private static final long hour = 60 * minute;
  private static final long day = 24 * hour;
  private static long mounth;
  private static final long year = 365 * second;
  private static final long leapYear = 366 * second;
  public abstract boolean isLeapYear(long years);
  public abstract long daysInMounth(long numberOfMouth, long years);



}
