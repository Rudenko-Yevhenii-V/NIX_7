package ru.rudenko.nix.data;



/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 2:18 PM
 * @project NIX_7
 */
public class Calendar extends Time {

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
  }

  public Calendar(long milliseconds) {
    super.time = milliseconds;
    super.milliseconds = getMilliseconds(milliseconds);
    super.seconds = getSeconds(milliseconds);
    super.minutes = getMinutes(milliseconds);
    super.hours = getHours(milliseconds);
    super.days = getDays(milliseconds);
    super.mounths = getMounths(milliseconds);
    super.years = getYears(milliseconds);
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
  public long getMounths(long milliseconds) {
    numberOfMounth = 0;
    int fourYears = (365 * 3 + 366);
    long daysInThisYear = ((milliseconds / 1000 / 60 / 60 / 24) % fourYears) % 365;
    long nowYear = getYears(milliseconds);
    for (int i = 0; i < 12; i++) {
      if (daysInThisYear > daysInMounth(i + 1, nowYear)) {
        numberOfMounth++;
        daysInThisYear = daysInThisYear - daysInMounth(i + 1, nowYear);
      } else {
        break;
      }
    }
    // super.days = daysInThisYear;
    return numberOfMounth;
  }

  @Override
  public long getYears(long milliseconds) {
    numberOfYears = 0;
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
  public long getDays(long milliseconds) {
    numberOfMounth = 0;
    int fourYears = (365 * 3 + 366);
    long daysInThisYear = ((milliseconds / 1000 / 60 / 60 / 24) % fourYears) % 365;
    long nowYear = getYears(milliseconds);
    for (int i = 0; i < 12; i++) {
      if (daysInThisYear > daysInMounth(i + 1, nowYear)) {
        numberOfMounth++;
        daysInThisYear = daysInThisYear - daysInMounth(i + 1, nowYear);
      } else {
        break;
      }
    }
    return daysInThisYear;
  }


  @Override
  public long getHours(long milliseconds) {
    return (milliseconds % (86400000))/1000/60/60;
  }

  @Override
  public long getMinutes(long milliseconds) {
    return (milliseconds % (3600000))/1000/60;
  }

  @Override
  public long getSeconds(long milliseconds) {
    return (milliseconds % (60000))/1000;
  }

  @Override
  public long getMilliseconds(long milliseconds) {
    return (milliseconds % (1000));

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
    super.milliseconds = getMilliseconds(super.time);
    super.seconds = getSeconds(super.time);
    super.minutes = getMinutes(super.time);
    super.hours = getHours(super.time);
    super.days = getDays(super.time);
    super.mounths = getMounths(super.time);
    super.years = getYears(super.time);

  }

  @Override
  public void subtractMilliseconds(long milliseconds) {
    super.time = time - milliseconds;
    super.milliseconds = getMilliseconds(super.time);
    super.seconds = getSeconds(super.time);
    super.minutes = getMinutes(super.time);
    super.hours = getHours(super.time);
    super.days = getDays(super.time);
    super.mounths = getMounths(super.time);
    super.years = getYears(super.time);
  }
  public void print(Calendar calendar){
    System.out.print(calendar.years + " = years; ");
    System.out.print(calendar.mounths + " = mounths; ");
    System.out.print(calendar.days + " = days; ");
    System.out.print(calendar.hours + " = hours; ");
    System.out.print(calendar.minutes + " = minutes; ");
    System.out.print(calendar.seconds + " = seconds; ");
    System.out.print(calendar.milliseconds + " = milliseconds; ");
    System.out.println();
  }
}
