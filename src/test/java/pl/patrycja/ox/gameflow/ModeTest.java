package pl.patrycja.ox.gameflow;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import pl.patrycja.ox.Player;
import pl.patrycja.ox.Sign;
import pl.patrycja.ox.ui.UI;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class ModeTest {

    UI ui = Mockito.mock(UI.class);

    @Test
    public void askWhichPlayerShouldStart() {
        //given
        Sign signX = Sign.X;
        Sign signO = Sign.O;
        Mode mode = new AutomaticTests(ui);
        String get_initial_sign = "get_initial_sign";
        List<Player> players = List.of(
                new Player("A", signX),
                new Player("B", signO));

        //when
        when(ui.getSign()).thenReturn(signX);
        Player player = mode.askWhichPlayerStarts(players);

        //then
        verify(ui).display(get_initial_sign);
        assertEquals(player.getSign(), Sign.X);
    }
}