package ru.rudenko.nix.data;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 2:18 PM
 * @project NIX_7
 */
public class Calendar extends Time {

  @Override
  public boolean isLeapYear(long years) {
    return (years % 400 == 0) || ((years % 4 == 0) && (years % 100 != 0));
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
}
