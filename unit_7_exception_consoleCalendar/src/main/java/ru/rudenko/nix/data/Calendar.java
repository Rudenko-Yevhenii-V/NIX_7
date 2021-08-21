package ru.rudenko.nix.data;


import java.io.Serializable;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 2:18 PM
 * @project NIX_7
 */
public class Calendar extends Time implements Serializable {

  static long numberOfMounth;
  static long numberOfYears;

  public Calendar() {
  }

  public Calendar(long millisecond,
      long second,
      long minute,
      long hour,
      long day,
      long mounth,
      long year) {
    super.milliseconds = millisecond;
    super.seconds = second;
    super.minutes = minute;
    super.hours = hour;
    super.days = day;
    super.mounths = mounth;
    super.years = year;
    super.time = (millisecond) + (second * 1000) + (minute * 1000 * 60) + (hour * 1000 * 60 * 60)
        + (day * 1000 * 60 * 60 * 24) + (getMillisecondsInMounths(mounth, year))
        + (getMillisecondsInYear(year));
  }

  private long getMillisecondsInYear(long year) {
    long time = 0;
    for (int i = 0; i < year; i++) {
      time = time + (daysInYear(i) * 24 * 60 * 60 * 1000);
    }
    return time;
  }

  private long getMillisecondsInMounths(long mounth, long year) {
    long time = 0;
    for (int i = 1; i <= mounth; i++) {
      time = time + (daysInMounth(i, year) * 24 * 60 * 60 * 1000);
    }
    return time;
  }

  public Calendar(long milliseconds) {
    if (milliseconds < 0) {
      throw new RuntimeException("Exception: milliseconds cant be < 0");
    }
    super.time = milliseconds;
    super.milliseconds = getMillisecondsFromMiliseconds(milliseconds);
    super.seconds = getSecondsFromMiliseconds(milliseconds);
    super.minutes = getMinutesFromMiliseconds(milliseconds);
    super.hours = getHoursFromMiliseconds(milliseconds);
    super.days = getDaysFromMiliseconds(milliseconds);
    super.mounths = getMounthsFromMiliseconds(milliseconds);
    super.years = getYearsFromMiliseconds(milliseconds);
  }

  @Override
  public boolean isLeapYear(long years) {
    return (years % 400 == 0) || ((years % 4 == 0) && (years % 100 != 0));
  }

  @Override
  public long daysInYear(long year) {
    if (isLeapYear(year)) {
      return 366;
    }
    return 365;
  }

  @Override
  public long getTime() {
    return super.time;
  }

  public long getMounthsFromMiliseconds(long milliseconds) {
    long daus = milliseconds/1000/60/60/24;
    numberOfMounth = 0;
    int fourYears = (365 * 3 + 366);
    long daysInThisYear = ((daus) % fourYears) % 365;
    long nowYear = getYearsFromMiliseconds(milliseconds);
    for (int i = 0; i < 12; i++) {
      if (daysInThisYear > daysInMounth(i + 1, nowYear)) {
        numberOfMounth++;
        daysInThisYear = daysInThisYear - daysInMounth(i + 1, nowYear);
      } else {
        break;
      }
    }
    return numberOfMounth;
  }

  @Override
  public long getYearsFromMiliseconds(long milliseconds) {
    numberOfYears = 1;
    int count = 0;
    long days = milliseconds / 24 / 60 / 60 / 1000;
    while (true) {
      if (days > 366) {
        switch (++count) {
          case 1:
          case 2:
          case 3: {
            numberOfYears++;
            days = days - 365;
            break;
          }
          case 4: {
            numberOfYears++;
            days = days - 366;
            count = 0;
            break;
          }
        }
      } else {
        break;
      }
    }

    return numberOfYears;
  }

  @Override
  public long getDaysFromMiliseconds(long milliseconds) {

    int fourYears = (365 * 3 + 366);
    long daysInThisYear = ((milliseconds / 1000 / 60 / 60 / 24) % fourYears) % 365;
    long nowYear = getYearsFromMiliseconds(milliseconds);
    for (int i = 0; i < 12; i++) {
      if (daysInThisYear > daysInMounth(i + 1, nowYear)) {
        daysInThisYear = daysInThisYear - daysInMounth(i + 1, nowYear);
      } else {
        break;
      }
    }
    return daysInThisYear;
  }


  @Override
  public long getHoursFromMiliseconds(long milliseconds) {
    return (milliseconds % (86400000)) / 1000 / 60 / 60;
  }

  @Override
  public long getMinutesFromMiliseconds(long milliseconds) {
    return (milliseconds % (3600000)) / 1000 / 60;
  }

  @Override
  public long getSecondsFromMiliseconds(long milliseconds) {
    return (milliseconds % (60000)) / 1000;
  }

  @Override
  public long getMillisecondsFromMiliseconds(long millisecondsAll) {
    return (millisecondsAll % (1000));

  }

  @Override
  public long daysInMounth(long numberOfMouth, long years) {
    return (long) (
        28 + ((numberOfMouth + Math.floor(numberOfMouth / 8)) % 2) + 2 % numberOfMouth + Math
            .floor((1 + (1 - (years % 4 + 2) % (years % 4 + 1)) * ((years % 100 + 2) % (years % 100
                + 1)) + (1
                - (years % 400 + 2) % (years % 400 + 1))) / numberOfMouth) + Math
            .floor(1 / numberOfMouth)
            - Math.floor(
            ((1 - (years % 4 + 2) % (years % 4 + 1)) * ((years % 100 + 2) % (years % 100 + 1)) + (1
                - (years % 400 + 2) % (
                years % 400 + 1))) / numberOfMouth));
  }

  @Override
  public void addMilliseconds(long milliseconds) {
    super.time = time + milliseconds;
    super.milliseconds = getMillisecondsFromMiliseconds(super.time);
    super.seconds = getSecondsFromMiliseconds(super.time);
    super.minutes = getMinutesFromMiliseconds(super.time);
    super.hours = getHoursFromMiliseconds(super.time);
    super.days = getDaysFromMiliseconds(super.time);
    super.mounths = getMounthsFromMiliseconds(super.time);
    super.years = getYearsFromMiliseconds(super.time);

  }

  @Override
  public void subtractMilliseconds(long milliseconds) {
    super.time = time - milliseconds;
    super.milliseconds = getMillisecondsFromMiliseconds(super.time);
    super.seconds = getSecondsFromMiliseconds(super.time);
    super.minutes = getMinutesFromMiliseconds(super.time);
    super.hours = getHoursFromMiliseconds(super.time);
    super.days = getDaysFromMiliseconds(super.time);
    super.mounths = getMounthsFromMiliseconds(super.time);
    super.years = getYearsFromMiliseconds(super.time);
  }

  public void print(Calendar calendar) {
    System.out.print(calendar.days + " - days; ");
    switch ((int) calendar.mounths) {
      case 1 : {
        System.out.print(" 01 Январь/January  - mounths; ");
      }
      break;
      case 2 : {
        System.out.print(" 02 Февраль/February  - mounths; ");
      }
      break;
      case 3 : {
        System.out.print(" 03 Март/March  - mounths; ");
      }
      break;
      case 4 : {
        System.out.print(" 04 Апрель/April  - mounths; ");
      }
      break;
      case 5 : {
        System.out.print(" 05 Май/May  - mounths; ");
      }
      break;
      case 6 : {
        System.out.print(" 06 Июнь/June  - mounths; ");
      }
      break;
      case 7 : {
        System.out.print(" 07 Июль/July  - mounths; ");
      }
      break;
      case 8 : {
        System.out.print(" 08 Август/August  - mounths; ");
      }
      break;
      case 9 : {
        System.out.print(" 09 Сентябрь/September  - mounths; ");
      }
      break;
      case 10 : {
        System.out.print(" 10  Октябрь/October  - mounths; ");
      }
      break;
      case 11 : {
        System.out.print(" 11  Ноябрь/November  - mounths; ");
      }
      break;
      case 12 : {
        System.out.print(" 12 Декабрь/December  - mounths; ");
      }
      break;
    }
    System.out.print(calendar.years + " - years; ");
    System.out.print(calendar.hours + " - hours; ");
    System.out.print(calendar.minutes + " - minutes; ");
    System.out.print(calendar.seconds + " - seconds; ");
    System.out.print(calendar.milliseconds + " - milliseconds; ");
    System.out.println();
  }
}
