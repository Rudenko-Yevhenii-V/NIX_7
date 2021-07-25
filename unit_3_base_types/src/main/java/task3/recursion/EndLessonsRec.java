package task3.recursion;

import customcolors.MyColors;

public class EndLessonsRec {

    private int lesson;
    private int startLessons = 9 * 60;
    private final int SHORT_PAUSE = 5;
    private final int LONG_PAUSE = 15;
    private final int TIME_ONE_LESSON = 45;
    private  static int endOfLessons=0;
    MyColors myColors = new MyColors();

    public EndLessonsRec(int lesson) {
        this.lesson = lesson;
        endOfLessons = startLessons + TIME_ONE_LESSON;
        calculateTimeOfLastLesson(lesson);
    }

    public void calculateTimeOfLastLesson(int lesson) {
        try {
            lesson--;
            int error = 5/lesson;
            endOfLessons =endOfLessons + TIME_ONE_LESSON + SHORT_PAUSE + (LONG_PAUSE-SHORT_PAUSE) - ((lesson%2)*(LONG_PAUSE - SHORT_PAUSE));
            calculateTimeOfLastLesson(lesson);
        } catch (Exception e) {
            System.out.println("*********************************************************");
            System.out.println("");
            System.out.println(myColors.ANSI_WHITE_BACKGROUND + myColors.ANSI_BLACK +"SOLUTION with Recursion!!!:" + myColors.ANSI_RESET);

            System.out.println(endOfLessons/60 + ":" + endOfLessons%60);
        }
    }
}
