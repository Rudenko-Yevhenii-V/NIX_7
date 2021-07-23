package task3;

import static org.junit.Assert.*;

public class EndLessonsTest {

    @org.junit.Test
    public void mathematicalSolution() {
        EndLessons endLessons = new EndLessons(3);
        String actual = endLessons.MathematicalSolution(3);
        String expected = "11:35";
        assertEquals(actual, expected);
    }


    @org.junit.Test
    public void stupidDecision() {
        EndLessons endLessons = new EndLessons(3);
        String actual = endLessons.StupidDecision(3);
        String expected = "11:35";
        assertEquals(actual, expected);
    }
}