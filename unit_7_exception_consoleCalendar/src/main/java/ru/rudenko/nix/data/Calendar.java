package ru.rudenko.nix.data;


import java.io.Serializable;
import ru.rudenko.nix.exceptionsC.SimulatedException;

public class Calendar extends Time implements Serializable {

  static long numberOfMounth;
  static long numberOfYears;

  public Calendar() {
  }

  public Calendar(long millisecond, long second, long minute, long hour, long day, long mounth,
      long year) {
    super.milliseconds = millisecond;
    super.seconds = second;
    super.minutes = minute;
    super.hours = hour;
    super.days = day;
    if (mounth == 0) {
      try {
        throw new SimulatedException(" mounth start with 1");
      } catch (SimulatedException e) {
        e.printStackTrace();
      }
      super.mounths = 1;
    } else {
      super.mounths = mounth;
    }
    if (year == 0) {
      try {
        throw new SimulatedException(" year start with 1 ");
      } catch (SimulatedException e) {
        year = 1;
        e.printStackTrace();
      }
    }
    super.years = year;
    super.time = (millisecond) + (second * 1000L) + (minute * 1000 * 60L) + (hour * 1000 * 60 * 60L)
        + (day * 1000 * 60 * 60 * 24L) + (getMillisecondsInMounths(mounth, year))
        + (getMillisecondsInYear(year));
  }

  public Calendar(long milliseconds) {
    if (milliseconds < 0) {
      try {
        throw new SimulatedException("Exception: milliseconds cant be < 0");
      } catch (SimulatedException e) {
        e.printStackTrace();
      }
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

  private long getMillisecondsInYear(long year) {
    long time = 0;
    for (int i = 1; i < year; i++) {
      final long lIterat = daysInYear(i);
      long test = lIterat * 86400000L;
      time = time + (test);
    }
    for (int i = 1; i <= year/100; i++) {
      if (year >= ((100*i)+1)) {
        time += (1000 * 60 * 60 * 24L);
      }
      if (year >= ((400*i)+1)) {
        time -= (1000 * 60 * 60 * 24L);
      }
    }
    return time;
  }

  public long getMillisecondsInMounths(long mounth, long year) {
    long time = 0;
    if (mounth == 1) {
      return 0;
    }
    for (int i = 1; i < mounth; i++) {
      time = time + (daysInMounth(i, year) * 24 * 60 * 60 * 1000);
    }
    return time;
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
    long daus = milliseconds / 1000 / 60 / 60 / 24;
    numberOfMounth = 1;
    final long yearsFromMiliseconds = getYearsFromMiliseconds(milliseconds);
    long daysInThisYear = daus;
    for (int i = 1; i < yearsFromMiliseconds; i++) {
      daysInThisYear = daysInThisYear - (daysInYear(i));
    }
    long nowYear = getYearsFromMiliseconds(milliseconds);
    for (int i = 0; i < 12; i++) {
      if (daysInThisYear >= daysInMounth(i + 1, nowYear)) {
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
      if (days >= 365) {
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
    if (nowYear == 0) {
      nowYear = 1;
    }
    for (int i = 0; i < 12; i++) {
      if (daysInThisYear >= daysInMounth(i + 1, nowYear)) {
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
    System.out.print(calendar.days + " |");
    switch ((int) calendar.mounths) {
      case 1: {
        System.out.print("  Январь January     |");
      }
      break;
      case 2: {
        System.out.print("  Февраль February   |");
      }
      break;
      case 3: {
        System.out.print("  Март March         |");
      }
      break;
      case 4: {
        System.out.print("  Апрель April       |");
      }
      break;
      case 5: {
        System.out.print("  Май May            |");
      }
      break;
      case 6: {
        System.out.print("  Июнь June          |");
      }
      break;
      case 7: {
        System.out.print("  Июль July          |");
      }
      break;
      case 8: {
        System.out.print("  Август August      |");
      }
      break;
      case 9: {
        System.out.print("  Сентябрь September |");
      }
      break;
      case 10: {
        System.out.print("   Октябрь October   |");
      }
      break;
      case 11: {
        System.out.print("   Ноябрь November |");
      }
      break;
      case 12: {
        System.out.print("  Декабрь December |");
      }
      break;
    }
    System.out.printf(" %04d ", calendar.years);
    System.out.print(calendar.hours + " : ");
    System.out.print(calendar.minutes + " : ");
    System.out.print(calendar.seconds + " : ");
    System.out.print(calendar.milliseconds);
    System.out.println();
  }

  @Override
  public String toString() {
    return "Calendar{" +
        "time=" + time +
        ", milliseconds=" + milliseconds +
        ", seconds=" + seconds +
        ", minutes=" + minutes +
        ", hours=" + hours +
        ", days=" + days +
        ", mounths=" + mounths +
        ", years=" + years +
        '}';
  }
}
