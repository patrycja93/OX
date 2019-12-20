package pl.patrycja.ox.winnerchecker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.patrycja.ox.GameSettings;
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

    @BeforeMethod
    public void setEndMatchOnFalse(){
        GameSettings.END_MATCH = false;
    }

    @Test(dataProvider = "boardContainHorizontalUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnTrue(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = GameSettings.builder()
                .unbrokenLine(2)
                .matchesNumber(3)
                .boardSize(size)
                .build();

        Judge judge = new Judge(ui, gameSettings);
        int lastShot = 5;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = GameSettings.END_MATCH;

        //then
        assertTrue(existsUnbrokenHorizontalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingHorizontalUnbrokenLineAndReturnFalse(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = GameSettings.builder()
                .unbrokenLine(2)
                .matchesNumber(3)
                .boardSize(size)
                .build();

        Judge judge = new Judge(ui, gameSettings);
        int lastShot = 2;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenHorizontalLine = GameSettings.END_MATCH;
        System.out.println(existsUnbrokenHorizontalLine);

        //then
        assertFalse(existsUnbrokenHorizontalLine, "You have unbroken line.");
    }

    @Test(dataProvider = "boardContainVerticalUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnTrue(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = GameSettings.builder()
                .unbrokenLine(2)
                .matchesNumber(3)
                .boardSize(size)
                .build();

        Judge judge = new Judge(ui, gameSettings);
        int lastShot = 5;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = GameSettings.END_MATCH;

        //then
        assertTrue(existsUnbrokenVerticalLine, "You haven't two unbroken line.");
    }

    @Test(dataProvider = "boardNotContainUnbrokenLine")
    public void testCheckingVerticalUnbrokenLineAndReturnFalse(int size, Map<Integer, Sign> fields) {
        //given
        UI ui = new ConsoleUI();
        GameSettings gameSettings = GameSettings.builder()
                .unbrokenLine(2)
                .matchesNumber(3)
                .boardSize(size)
                .build();

        Judge judge = new Judge(ui, gameSettings);
        int lastShot = 2;

        //when
        judge.lookAtBoard(fields, gameSettings.boardSize, lastShot);
        boolean existsUnbrokenVerticalLine = GameSettings.END_MATCH;

        //then
        assertFalse(existsUnbrokenVerticalLine, "You have unbroken line.");
    }
}