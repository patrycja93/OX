package pl.patrycja.ox;

import java.util.Objects;

/**
 * Keep information about player.
 *
 * @author Patrycja
 */
public class Player {
    private String name;
    private Sign sign;
    private int points;

    /**
     * Create new Player object.
     *
     * @param name name of player
     * @param sign sign of player
     */
    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
        this.points = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return name.equals(player.name)
                && sign == player.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sign);
    }

    /**
     * Return sign.
     */
    public Sign getSign() {
        return sign;
    }

    /**
     * Return points of player.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Add points to player.
     *
     * @param howMuch amount of points which will be add to points of player
     */
    public void addPoints(int howMuch) {
        points += howMuch;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.sign + ")";
    }
}
