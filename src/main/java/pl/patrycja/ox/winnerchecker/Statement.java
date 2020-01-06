package pl.patrycja.ox.winnerchecker;

import pl.patrycja.ox.Player;

import java.util.List;

public class Statement {

    private String message;
    private List<Player> arguments;

    public Statement(String message, List<Player> arguments) {
        this.message = message;
        this.arguments = arguments;
    }

    public String getMessage() {
        return message;
    }

    public List<Player> getArguments() {
        return arguments;
    }
}
