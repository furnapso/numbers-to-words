package io.github.furnapso.numberstowordsbackend.util;

public class ThousandsContext {
    private String current = "";
    public void increment() {
        switch (current) {
            case "" -> current = "THOUSAND";
            case "THOUSAND" -> current = "MILLION";
            case "MILLION" -> current = "BILLION";
            case "BILLION" -> current = "TRILLION";
        }
    }

    public String toString() {
        return current;
    }

    public void reset() {
        current = "";
    }
}
