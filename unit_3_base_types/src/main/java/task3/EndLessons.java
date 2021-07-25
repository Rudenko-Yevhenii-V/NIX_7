package task3;

import customcolors.MyColors;
import task3.recursion.EndLessonsRec;

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
    private final int LESSONS = 10;
    private int startLessons = 9 * 60;
    private final int SHORT_PAUSE = 5;
    private final int LONG_PAUSE = 15;
    private final int TIME_ONE_LESSON = 45;

    public EndLessons(int lesson) {
        this.lesson = lesson;
        stupidDecision(lesson);
        mathematicalSolution(lesson);
        new EndLessonsRec(lesson);
    }

    public String mathematicalSolution(int i) {
        String result;
        long timeEndLesson = startLessons + ((TIME_ONE_LESSON) * i) + ((SHORT_PAUSE) * (i - 1)) + (((LONG_PAUSE - SHORT_PAUSE)) * ((i - 1) / 2));
        System.out.println(myColors.ANSI_WHITE_BACKGROUND + myColors.ANSI_BLACK + "MathematicalSolution:" + myColors.ANSI_RESET);
        result = (timeEndLesson / 60 + ":" + timeEndLesson % 60);
        System.out.println(result);
        return result;
    }

    public String stupidDecision(int i) {
        int[] timeTableArray = new int[11];
        timeTableArray[0] = (startLessons + TIME_ONE_LESSON);
        timeTableArray[1] = (timeTableArray[0] + TIME_ONE_LESSON + SHORT_PAUSE);
        timeTableArray[2] = (timeTableArray[1] + TIME_ONE_LESSON + LONG_PAUSE);
        timeTableArray[3] = (timeTableArray[2] + TIME_ONE_LESSON + SHORT_PAUSE);
        timeTableArray[4] = (timeTableArray[3] + TIME_ONE_LESSON + LONG_PAUSE);
        timeTableArray[5] = (timeTableArray[4] + TIME_ONE_LESSON + SHORT_PAUSE);
        timeTableArray[6] = (timeTableArray[5] + TIME_ONE_LESSON + LONG_PAUSE);
        timeTableArray[7] = (timeTableArray[6] + TIME_ONE_LESSON + SHORT_PAUSE);
        timeTableArray[8] = (timeTableArray[7] + TIME_ONE_LESSON + LONG_PAUSE);
        timeTableArray[9] = (timeTableArray[8] + TIME_ONE_LESSON + SHORT_PAUSE);
        System.out.println(myColors.ANSI_WHITE_BACKGROUND + myColors.ANSI_BLACK + "StupidDecision:" + myColors.ANSI_RESET);
        System.out.printf("%02d:%02d%n", timeTableArray[i - 1] / 60, timeTableArray[i - 1] % 60);
        return String.format("%02d:%02d", timeTableArray[i - 1] / 60, timeTableArray[i - 1] % 60);
    }
}



