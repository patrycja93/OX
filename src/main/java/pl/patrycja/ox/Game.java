package pl.patrycja.ox;

public class Game {

    public static void main(String[] args) {

        //TODO: get input from user
        GameSettings gameSettings = GameSettings.builder()
                .boardSize(6)
                .unbrokenLine(3)
                .build();

        Match.init(gameSettings).play();
    }
}
