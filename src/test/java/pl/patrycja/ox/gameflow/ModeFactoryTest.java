package pl.patrycja.ox.gameflow;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ModeFactoryTest {

    @Test
    public void setModeCreateGame() {
        //given
        String[] args = {"5", "4"};
        ModeFactory modeFactory = new ModeFactory(args);

        //when
        Mode mode = modeFactory.setMode();

        //then
        assertTrue(mode instanceof Game);
    }

    @Test
    public void setModeCreateAutomaticTests() {
        //given
        String[] args = {};
        ModeFactory modeFactory = new ModeFactory(args);

        //when
        Mode mode = modeFactory.setMode();

        //then
        assertTrue(mode instanceof ComputerWithUser);
    }

    @Test
    public void setModeCreateComputerWithUser() {
        //given
        String[] args = {"5", "4", "2"};
        ModeFactory modeFactory = new ModeFactory(args);

        //when
        Mode mode = modeFactory.setMode();

        //then
        assertTrue(mode instanceof AutomaticTests);
    }
}