package ru.rudenko.nix;

import ru.rudenko.nix.data.Calendar;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 12:41 PM
 * @project NIX_7
 */
public class Unit7Main {

  public static void main(String[] args) {
    System.out.println("main ");
    Calendar calendar = new Calendar();
    System.out.println(calendar.daysInMounth(2, 2019));
    System.out.println(calendar.isLeapYear(2000) + " y");//1
    System.out.println(calendar.isLeapYear(2004)+ " y");//1
    System.out.println(calendar.isLeapYear(2008)+ " y");//1
    System.out.println(calendar.isLeapYear(2012)+ " y");//1
    System.out.println(calendar.isLeapYear(2020)+ " y");//1
    System.out.println(calendar.isLeapYear(2024)+ " y");//1
    System.out.println(calendar.isLeapYear(1764)+ " y");//1
    System.out.println(calendar.isLeapYear(1763)+ " n");//0
    System.out.println(calendar.isLeapYear(2001)+ " n");//0
    System.out.println(calendar.isLeapYear(2002)+ " n");//0
    System.out.println(calendar.isLeapYear(2003)+ " n");//0
    System.out.println(calendar.isLeapYear(2005)+ " n");//0
    System.out.println(calendar.isLeapYear(2006)+ " n");//0
  }

}
