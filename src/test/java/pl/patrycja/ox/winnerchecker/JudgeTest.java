package pl.patrycja.ox.winnerchecker;

import org.testng.annotations.Test;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class JudgeTest {

    @Test
    public void checkHorizontalShouldReturnTrueForUnbrokenLineEqualsTwo() {
        //given
        int unbrokenLine = 2;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
            put(5, Sign.CROSS);
        }};
        int size = 3;
        int lastShoot = 5;

        //when
        boolean existsUnbrokenHorizontalLine = judge.checkHorizontal(fields, size, lastShoot);

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't two unbroken line.");
    }

    @Test
    public void checkHorizontalShouldReturnTrueForUnbrokenLineEqualsFour() {
        //given
        int unbrokenLine = 4;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(4, Sign.CROSS);
            put(5, Sign.CROSS);
            put(6, Sign.CROSS);
            put(7, Sign.CROSS);
        }};
        int size = 4;
        int lastShoot = 7;

        //when
        boolean existsUnbrokenHorizontalLine = judge.checkHorizontal(fields, size, lastShoot);

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't four unbroken line.");
    }

    @Test
    public void checkHorizontalShouldReturnFalseForUnbrokenLineEqualsTwo() {
        //given
        int unbrokenLine = 2;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
        }};
        int size = 3;
        int lastShoot = 2;

        //when
        boolean existsUnbrokenHorizontalLine = judge.checkHorizontal(fields, size, lastShoot);

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test
    public void checkHorizontalShouldReturnFalseForUnbrokenLineEqualsFour() {
        //given
        int unbrokenLine = 4;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(1, Sign.CROSS);
            put(2, Sign.CROSS);
            put(7, Sign.CROSS);
        }};
        int size = 4;
        int lastShoot = 7;

        //when
        boolean existsUnbrokenHorizontalLine = judge.checkHorizontal(fields, size, lastShoot);

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test
    public void checkVerticalShouldReturnTrueForUnbrokenLineEqualsTwo() {
        //given
        int unbrokenLine = 2;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
            put(5, Sign.CROSS);
        }};
        int size = 3;
        int lastShoot = 5;

        //when
        boolean existsUnbrokenVerticalLine = judge.checkVertical(fields, size, lastShoot);

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't two unbroken line.");
    }

    @Test
    public void checkVerticalShouldReturnTrueForUnbrokenLineEqualsFour() {
        //given
        int unbrokenLine = 4;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(3, Sign.CROSS);
            put(7, Sign.CROSS);
            put(11, Sign.CROSS);
            put(15, Sign.CROSS);
        }};
        int size = 4;
        int lastShoot = 15;

        //when
        boolean existsUnbrokenVerticalLine = judge.checkVertical(fields, size, lastShoot);

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't four unbroken line.");
    }


    @Test
    public void checkVerticalShouldReturnFalseForUnbrokenLineEqualsTwo() {
        //given
        int unbrokenLine = 2;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
        }};
        int size = 3;
        int lastShoot = 2;

        //when
        boolean existsUnbrokenVerticalLine = judge.checkVertical(fields, size, lastShoot);

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }

    @Test
    public void checkVerticalShouldReturnFalseForUnbrokenLineEqualsFour() {
        //given
        int unbrokenLine = 4;
        UI ui = new ConsoleUI();
        Judge judge = new Judge(unbrokenLine, ui);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(1, Sign.CROSS);
            put(2, Sign.CROSS);
            put(7, Sign.CROSS);
        }};
        int size = 4;
        int lastShoot = 7;

        //when
        boolean existsUnbrokenVerticalLine = judge.checkVertical(fields, size, lastShoot);

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }
}