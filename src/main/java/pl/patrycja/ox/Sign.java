package pl.patrycja.ox;

/**
 * Enum Sign contains two sign - O and X.
 */

public enum Sign {
    X("X"), O("O");

    String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}