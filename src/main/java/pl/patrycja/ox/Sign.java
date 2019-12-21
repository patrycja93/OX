package pl.patrycja.ox;

import java.util.HashMap;
import java.util.Map;

public enum Sign {
    CROSS("X"), NAUGHT("O");

    String sign;

    static Map<String, Sign> signMap = new HashMap<>(){{
        put("O", NAUGHT);
        put("X", CROSS);
    }};

    static Sign getSign(String s){
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