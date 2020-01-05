package pl.patrycja.ox;

/**
 * Enum Sign contains two sign - O and X.
 */

public enum Sign {
    X("X"), O("O");

    String sign;

    /**
     * This method return Sign.
     *
     * @param s is a key in hashmap
     */
    public static Sign getNextSign(Sign s) {
        Sign next = null;
        for (int i = 0; i < values().length; i++) {
            if (values()[i].equals(s)) {
                next = values()[(i + 1) % values().length];
                break;
            }
        }
        return next;
    }

    Sign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}