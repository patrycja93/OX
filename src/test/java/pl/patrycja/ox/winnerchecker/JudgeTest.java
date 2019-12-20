package pl.patrycja.ox.winnerchecker;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.ConsoleUI;
import pl.patrycja.ox.ui.UI;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class JudgeTest {

    @DataProvider
    public Object[][] boardContainHorizontalUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(4, Sign.CROSS);
                    put(2, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(7, Sign.CROSS);
                    put(4, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(3, Sign.CROSS);
                    put(4, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(8, Sign.CROSS);
                    put(4, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {4,
                new HashMap<>() {{
                    put(0, Sign.CROSS);
                    put(9, Sign.CROSS);
                    put(15, Sign.CROSS);
                    put(4, Sign.CROSS);
                    put(5, Sign.CROSS);
                    put(6, Sign.CROSS);
                    put(7, Sign.CROSS);
                }}}
        };
    }

    @DataProvider
    public Object[][] boardContainVerticalUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(3, Sign.CROSS);
                    put(2, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(0, Sign.CROSS);
                    put(8, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(6, Sign.CROSS);
                    put(2, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(1, Sign.CROSS);
                    put(8, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}, {4,
                new HashMap<>() {{
                    put(0, Sign.CROSS);
                    put(8, Sign.CROSS);
                    put(15, Sign.CROSS);
                    put(13, Sign.CROSS);
                    put(2, Sign.CROSS);
                    put(9, Sign.CROSS);
                    put(5, Sign.CROSS);
                }}}
        };
    }

    @DataProvider
    public Object[][] boardNotContainUnbrokenLine() {
        return new Object[][]{{3,
                new HashMap<>() {{
                    put(0, Sign.CROSS);
                    put(4, Sign.CROSS);
                    put(2, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(3, Sign.CROSS);
                    put(7, Sign.CROSS);
                    put(2, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(0, Sign.CROSS);
                    put(7, Sign.CROSS);
                    put(2, Sign.CROSS);
                }}}, {3,
                new HashMap<>() {{
                    put(6, Sign.CROSS);
                    put(4, Sign.CROSS);
                    put(2, Sign.CROSS);
                }}}, {4,
                new HashMap<>() {{
                    put(0, Sign.CROSS);
                    put(5, Sign.CROSS);
                    put(10, Sign.CROSS);
                    put(8, Sign.CROSS);
                    put(7, Sign.CROSS);
                    put(13, Sign.CROSS);
                    put(2, Sign.CROSS);
                }}}
        };
    }

    @Test(dataProvider = "boardContainHorizontalUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnTrue(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, size);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        int lastShot = 5;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = judge.isFinishMatch();

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnFalse(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, size);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        int lastShot = 2;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = judge.isFinishMatch();
        System.out.println(existsUnbrokenHorizontalLine);

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test(dataProvider = "boardContainVerticalUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnTrue(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, size);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        int lastShot = 5;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = judge.isFinishMatch();

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnFalse(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = new GameSettings(2, 3, size);
        Judge judge = new Judge(ui);
        judge.checkGameSettings(gameSettings);
        int lastShot = 2;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = judge.isFinishMatch();

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }
}