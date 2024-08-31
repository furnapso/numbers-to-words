package io.github.furnapso.numberstowordsbackend.parse;

import java.util.HashMap;
import java.util.Map;

public enum NodeType {
    DECIMAL, ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;
    private static final Map<String, NodeType> MAP;

    public static NodeType fromString(String s) {
        return MAP.get(s);
    }

    static {
        MAP = new HashMap<>();
        MAP.put(".", DECIMAL);
        MAP.put("0", ZERO);
        MAP.put("1", ONE);
        MAP.put("2", TWO);
        MAP.put("3", THREE);
        MAP.put("4", FOUR);
        MAP.put("5", FIVE);
        MAP.put("6", SIX);
        MAP.put("7", SEVEN);
        MAP.put("8", EIGHT);
        MAP.put("9", NINE);
    }
}
