package ru.rudenko.nix.utill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 2:47 PM
 * @project NIX_7
 */
public class NixDate {

  public Time findDifferenceBetweenDates(Time timeStart, Time timeEnd) {
    long year = Math.abs(timeEnd.years - timeStart.years)+1;
    long mounth = Math.abs(timeEnd.mounths - timeStart.mounths) +1;
    long day = Math.abs(timeEnd.days - timeStart.days);
    long hour = Math.abs(timeEnd.hours - timeStart.hours);
    long minute = Math.abs(timeEnd.minutes - timeStart.minutes);
    long second = Math.abs(timeEnd.seconds - timeStart.seconds);
    long millisecond = Math.abs(timeEnd.milliseconds - timeStart.milliseconds);
    Time time = new Calendar(millisecond, second, minute, hour, day, mounth, year);

    return time;
  }

  public Time timeAddTime(Time timeStart, Time timeEnd) {

    long year = Math.abs(timeEnd.years + timeStart.years);
    long mounth = Math.abs(timeEnd.mounths + timeStart.mounths) ;
    long day = Math.abs(timeEnd.days + timeStart.days);
    long hour = Math.abs(timeEnd.hours + timeStart.hours);
    long minute = Math.abs(timeEnd.minutes + timeStart.minutes);
    long second = Math.abs(timeEnd.seconds + timeStart.seconds);
    long millisecond = Math.abs(timeEnd.milliseconds + timeStart.milliseconds);
    Time time = new Calendar(millisecond, second, minute, hour, day, mounth, year);
    return time;

  }

  public Time timeSubtractTime(Time timeEnd, Time  timeStart) {
    long year = timeEnd.years - timeStart.years;
    long mounth = timeEnd.mounths - timeStart.mounths ;
    long day = timeEnd.days - timeStart.days;
    long hour = timeEnd.hours - timeStart.hours;
    long minute = timeEnd.minutes - timeStart.minutes;
    long second = timeEnd.seconds - timeStart.seconds;
    long millisecond = timeEnd.milliseconds - timeStart.milliseconds;
    Time time = new Calendar(millisecond, second, minute, hour, day, mounth, year);
    return time;
  }

  public Time[] sortTimesFromLowToHight(Time[] times) {
    boolean isSorted = false;
    Time buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < times.length - 1; i++) {
        if (times[i].getTime() > times[i + 1].getTime()) {
          isSorted = false;
          buf = times[i];
          times[i] = times[i + 1];
          times[i + 1] = buf;
        }
      }
    }
    return times;

  }

  public Time[] sortTimesFromHightToLow(Time[] times) {
    boolean isSorted = false;
    Time buf;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < times.length - 1; i++) {
        if (times[i].getTime() < times[i + 1].getTime()) {
          isSorted = false;
          buf = times[i];
          times[i] = times[i + 1];
          times[i + 1] = buf;
        }
      }
    }
    return times;

  }
}
