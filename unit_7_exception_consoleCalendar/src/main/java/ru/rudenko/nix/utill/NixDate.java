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
        Time time = new Calendar(Math.abs(timeEnd.time - timeStart.time));
    return time;
  }

  public Time timeAddTime(Time timeStart, Time timeEnd) {

    Time time = new Calendar(timeStart.time + timeEnd.time);
    return time;

  }

  public Time timeSubtractTime(Time timeStart, Time timeEnd) {
    Time time = new Calendar(Math.abs(timeStart.time - timeEnd.time));
    return time;
  }

  public Time[] sortTimesFromLowToHight(Time[] times) {
    boolean isSorted = false;
    Time buf;
    while(!isSorted) {
      isSorted = true;
      for (int i = 0; i < times.length-1; i++) {
        if(times[i].getTime() > times[i+1].getTime()){
          isSorted = false;
          buf = times[i];
          times[i] = times[i+1];
          times[i+1] = buf;
        }
      }
    }
    return times;

  }

  public Time[] sortTimesFromHightToLow(Time[] times) {
    boolean isSorted = false;
    Time buf;
    while(!isSorted) {
      isSorted = true;
      for (int i = 0; i < times.length-1; i++) {
        if(times[i].getTime() < times[i+1].getTime()){
          isSorted = false;
          buf = times[i];
          times[i] = times[i+1];
          times[i+1] = buf;
        }
      }
    }
    return times;

  }
}
