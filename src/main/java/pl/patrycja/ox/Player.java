package pl.patrycja.ox;

import java.util.Objects;

public class Player {
    private String name;
    private Sign sign;

    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name) &&
                sign == player.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sign);
    }

    public String getName() {
        return name;
    }

    public Sign getSign() {
        return sign;
    }
}
