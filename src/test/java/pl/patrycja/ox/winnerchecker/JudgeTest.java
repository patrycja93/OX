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
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, 3);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        int lastShot = 5;
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
            put(5, Sign.CROSS);
        }};

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = judge.isFinishMatch();

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't two unbroken line.");
    }

    @Test
    public void checkHorizontalShouldReturnTrueForUnbrokenLineEqualsFour() {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(4, 3, 4);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(9, Sign.CROSS);
            put(15, Sign.CROSS);
            put(4, Sign.CROSS);
            put(5, Sign.CROSS);
            put(6, Sign.CROSS);
            put(7, Sign.CROSS);
        }};
        int lastShot = 7;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = judge.isFinishMatch();

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't four unbroken line.");
    }

    @Test
    public void checkHorizontalShouldReturnFalseForUnbrokenLineEqualsTwo() {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, 3);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
        }};
        int lastShot = 2;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = judge.isFinishMatch();

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test
    public void checkHorizontalShouldReturnFalseForUnbrokenLineEqualsFour() {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(4, 3, 4);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(1, Sign.CROSS);
            put(2, Sign.CROSS);
            put(7, Sign.CROSS);
        }};
        int lastShot = 7;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = judge.isFinishMatch();

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test
    public void checkVerticalShouldReturnTrueForUnbrokenLineEqualsTwo() {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, 3);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
            put(5, Sign.CROSS);
        }};
        int lastShot = 5;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = judge.isFinishMatch();

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't two unbroken line.");
    }

    @Test
    public void checkVerticalShouldReturnTrueForUnbrokenLineEqualsFour() {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(4, 3, 4);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(3, Sign.CROSS);
            put(4, Sign.CROSS);
            put(9, Sign.CROSS);
            put(12, Sign.CROSS);
            put(7, Sign.CROSS);
            put(11, Sign.CROSS);
            put(15, Sign.CROSS);
        }};
        int lastShot = 15;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = judge.isFinishMatch();

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't four unbroken line.");
    }


    @Test
    public void checkVerticalShouldReturnFalseForUnbrokenLineEqualsTwo() {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, 3);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(4, Sign.CROSS);
            put(2, Sign.CROSS);
        }};
        int lastShot = 2;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = judge.isFinishMatch();

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }

    @Test
    public void checkVerticalShouldReturnFalseForUnbrokenLineEqualsFour() {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(4, 3, 4);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        Map<Integer, Sign> fields = new HashMap<>() {{
            put(0, Sign.CROSS);
            put(1, Sign.CROSS);
            put(2, Sign.CROSS);
            put(7, Sign.CROSS);
        }};
        int lastShot = 7;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = judge.isFinishMatch();

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }
}