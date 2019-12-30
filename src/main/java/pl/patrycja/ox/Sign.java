package pl.patrycja.ox;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum Sign contains two sign - O and X.
 * */

public enum Sign {
    CROSS("X"), NAUGHT("O");

    String sign;

    static Map<String, Sign> signMap = new HashMap<>() {{
        put("O", NAUGHT);
        put("X", CROSS);
    }};

    /**
     * This method return Sign.
     *
     * @param s is a key in hashmap
     * */
    public static Sign getSign(String s) {
        return signMap.get(s);
    }

    Sign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}