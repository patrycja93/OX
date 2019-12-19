package pl.patrycja.ox.board;

import pl.patrycja.ox.Sign;

import java.util.Objects;

class Field {

    int number;
    Sign sign = Sign.EMPTY;

    public Field(int number, Sign sign) {
        this.number = number;
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return number == field.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, sign);
    }
}
