package task3;

import myColors.MyColors;

import java.util.Date;

/**
 * EndLessons
 * решение задачи:
 * В некоторой школе занятия начинаются в 9:00. Продолжительность урока — 45 минут,
 * после 1-го, 3-го, 5-го и т.д. уроков перемена 5 минут, а после 2-го, 4-го, 6-го и т.д. — 15
 * минут.
 * Определите, когда заканчивается указанный урок.
 * Данные вводятся с консоли
 * Входные данные: Дан номер урока (число от 1 до 10).
 * Выходные данные: Выведите два целых числа: время окончания урока в часах и минутах.
 * При решении этой задачи нельзя пользоваться циклами и условными
 * инструкциями!!!!!!!!!!!!!!!!!
 * Примеры:
 * Входные данные: 3
 * Выходные данные:11 35
 * Входные данные: 2
 * Выходные данные: 10 35
 */
public class EndLessons {
    MyColors myColors = new MyColors();
    private int lesson;
    private int lessons = 10;
    private int startLessons = 9 * 60;
    private int shortPause = 5;
    private int longPause = 15;
    private int timeOneLesson = 45;
    private int counter = 0;

    public EndLessons(int lesson) {
        this.lesson = lesson;
        StupidDecision(lesson);
        MathematicalSolution(lesson);
    }
    public  void  MathematicalSolution(int i){
        Date date = new Date();
        long start = 21600000;
        long  oneMinutes = 60000;
        long timeEndLesson = start + ((timeOneLesson * oneMinutes) * i) + ((shortPause * oneMinutes) * (i-1)) + (((longPause-shortPause) * oneMinutes) * ((i-1)/2));
        System.out.println(myColors.ANSI_YELLOW_BACKGROUND + myColors.ANSI_BLACK +"MathematicalSolution:" + myColors.ANSI_RESET);
        date.setTime(timeEndLesson);
        System.out.printf("%tR%n", date);

    }
    public void StupidDecision(int i){

        int[] timeTableArray= new int[11];
        timeTableArray[0] = (startLessons + timeOneLesson);
        timeTableArray[1] = (timeTableArray[0] + timeOneLesson + shortPause);
        timeTableArray[2] = (timeTableArray[1] + timeOneLesson + longPause);
        timeTableArray[3] = (timeTableArray[2] + timeOneLesson + shortPause);
        timeTableArray[4] = (timeTableArray[3] + timeOneLesson + longPause);
        timeTableArray[5] = (timeTableArray[4] + timeOneLesson + shortPause);
        timeTableArray[6] = (timeTableArray[5] + timeOneLesson + longPause);
        timeTableArray[7] = (timeTableArray[6] + timeOneLesson + shortPause);
        timeTableArray[8] = (timeTableArray[7] + timeOneLesson + longPause);
        timeTableArray[9] = (timeTableArray[8] + timeOneLesson + shortPause);
        System.out.println(myColors.ANSI_YELLOW_BACKGROUND + myColors.ANSI_BLACK +"StupidDecision:" + myColors.ANSI_RESET);
        System.out.printf("%02d:%02d%n",timeTableArray[i-1]/60, timeTableArray[i-1]%60 );
    }
}



