package ru.rudenko.nix;

import java.util.Scanner;
import ru.rudenko.nix.controllers.Controller;
import ru.rudenko.nix.data.Calendar;
import ru.rudenko.nix.data.Time;
import ru.rudenko.nix.exceptionsC.SimulatedException;
import ru.rudenko.nix.service.Parser;

/**
 * @author Rudenko Yevhenii
 * @created 19/08/2021 - 12:41 PM
 * @project NIX_7
 */
public class Unit7Main {

  public static void main(String[] args) {
    System.out.println("\n\n\n\n");

    System.out.println(" Привет ПОЛЬЗОВАТЕЛЬ!."
        + "Данная программа предназначена для работы со временем и датами...\n"
        + "Для начала надо выбрать формат: \n"
        + "-dd/mm/yy hh:mm:ss:msmsms\n"
        + "-mm/dd/yy hh:mm:ss:msmsms\n"
        + "-mmm/dd/yy hh:mm:ss:msmsms\n"
        + "-dd/mmm/yy hh:mm:ss:msmsms\n"
        + "программа ищет даты и время в тексте только 1 дата 1 время...\n"
        + "пример (Some text 01-03-2001 Some text 00:00:55:777 Some text)\n"
        + "для разделения даты можно ипользовать (dd.mm.yy)(dd mm yy)(dd/mm/yy)(dd-mm-yy) ...\n"
        + "для времени только : (hh:mm:ss:msmsms)\n"
        + "месяц в форме января февраля марта апреля мая июня июля августа сентября октября ноября декабря\n"
        + "или january february march april may june july august september october november december\n"
        + "Пример: 01.february.2003 05:50:25:254 или 01.февраля.2003 05:50:25:254\n"
        + "регистр не имеет значения...\n"
        + "Методы:\n"
        + "- Смена форматта ввода setFormat \n"
        + "- Результат разници двух дат differenceDates \n"
        + "- прибавить к времени год мес день и тд. , что не надо {0} addToTimeDate \n"
        + "- Результат вычетания с даты  timeSubtractTime \n"
        + "- сравнивать перечень дат по убыванию sortTimesFromHightToLow \n"
        + "- сравнивать перечень дат по возрастанию sortTimesFromLowToHight \n"
        + "- ДОПОЛНИТЕЛЬНЫЕ ФУНКЦИИ!!! \n"
        + "   --Проверить высокосный ли год      \n"
        + "   --Сколько дней в месяце             \n"
        + "   --Перевести милесекунды в дату    \n"
        + "   --Перевести дату в милесекунды    \n\n\n"
        + "Для продолжения нажми ENTER\n");
  Scanner scaner = new Scanner(System.in);
  String in = scaner.nextLine();
    new Controller().start();
//    for (int i = 1; i < 100; i++) {
////      Calendar calendar = new Calendar(111, 11,51,5,i,2,1002);
//      Calendar calendar = new Calendar(0, 0,0,0,i,i+1,i+1);
//      Calendar calendar1 = new Calendar(calendar.time);
//      System.out.println("calendar = " + calendar);
//      System.out.println("calendar1 = " + calendar1);
//      System.out.println("_______________________________________________________________________________");
//
//    }
  }
}
