package io.github.furnapso.numberstowordsbackend.util;

import java.util.List;

public class ThousandsContext {
    private int currentIndex = 0;
    private static final List<String> LOOKUP = List.of("", "THOUSAND", "MILLION", "BILLION", "TRILLION");

    public void increment() {
        currentIndex++;
    }

    public String toString() {
        return LOOKUP.get(currentIndex);
    }

    public String getLast() {
        return LOOKUP.get(currentIndex - 1);
    }
}
