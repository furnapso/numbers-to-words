package io.github.furnapso.numberstowordsbackend.parse;

import com.google.common.base.Preconditions;
import lombok.Setter;

public class ZeroesContext {
    private String current;
    @Setter
    private String tensCurrent;

    public void increment() {
        switch (current) {
            case null -> current = "TEN";
            case "TEN" -> current = "HUNDRED";
            case "HUNDRED" -> current = "THOUSAND";
            case "THOUSAND" -> current = "TEN THOUSAND";
            case "TEN THOUSAND" -> current = "HUNDRED THOUSAND";
            case "HUNDRED THOUSAND" -> current = "MILLION";
            case "MILLION" -> current = "TEN MILLION";
            case "TEN MILLION" -> current = "HUNDRED MILLION";
            case "HUNDRED MILLION" -> current = "BILLION";
            case "BILLION" -> current = "TEN BILLION";
            case "TEN BILLION" -> current = "HUNDRED BILLION";
            case "HUNDRED BILLION" -> current = "TRILLION";
            case "TRILLION" -> throw new IllegalStateException("Exceeded maximum tier: TRILLION");
            default -> throw new IllegalStateException("Unexpected value: " + current);
        }
    }

    public String toString() {
        Preconditions.checkNotNull(current);

        if (current.equals("TEN")) {
            return tensCurrent;
        }

        return current;
    }

    public boolean hasCurrentContext() {
        return current != null;
    }

    public void reset() {
        current = null;
        tensCurrent = null;
    }
}
