package pl.patrycja.ox.gameflow;

import pl.patrycja.ox.Sign;

import java.util.Objects;

class Player {
    String name;
    Sign sign;

    Player(String name, Sign sign) {
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
}
