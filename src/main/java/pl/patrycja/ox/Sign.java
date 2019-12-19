package pl.patrycja.ox;

enum Sign {
    CROSS("X"), NAUGHT("O"), EMPTY("| |");

    String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}