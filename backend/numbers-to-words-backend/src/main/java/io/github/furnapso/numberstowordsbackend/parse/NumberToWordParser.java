package io.github.furnapso.numberstowordsbackend.parse;

import io.github.furnapso.numberstowordsbackend.util.ThousandsContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsUtil.getBelowTwenty;
import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsUtil.getTens;

public class NumberToWordParser {
    private final int dollars;
    private final int cents;
    private BigDecimal number;

    public NumberToWordParser(BigDecimal number) {
        this.number = number.setScale(2, RoundingMode.HALF_UP);
        var elements = number.abs().toString().split("\\.");
        dollars = NumberUtils.toInt(elements[0]);
        cents = NumberUtils.toInt(elements[1]);
    }

    public String parse() {
        var stack = new ArrayList<String>();
        if (dollars > 0) {
            stack.add(convertToWords(dollars));
            stack.add(dollars == 1 ? "DOLLAR" : "DOLLARS");
            if (cents > 0) {
                stack.add("AND");
            }
        } else if (cents == 0) {
            stack.add("ZERO DOLLARS");
        }

        if (cents > 0) {
            stack.add(convertToWords(cents));
            stack.add(cents == 1 ? "CENT" : "CENTS");
        }

        if (!number.abs().equals(number)) {
            stack.addFirst("NEGATIVE");
        }

        return StringUtils.normalizeSpace(String.join(" ", stack));
    }

    private String convertToWords(int number) {
        var thousandsContext = new ThousandsContext();
        var stack = new ArrayList<String>();
        while (number > 0) {
            if (number % 1000 != 0) {
                stack.addFirst(convertBelowThousand(number % 1000) + " " + thousandsContext);
            }
            thousandsContext.increment();
            number = number / 1000;
        }

        return String.join(" ", stack);
    }

    private String convertBelowThousand(int number) {
        if (number < 20) {
            return getBelowTwenty(number);
        } else if (number < 100) {
            return getTens(number / 10) + " " + getBelowTwenty(number % 10);
        } else {
            return getBelowTwenty(number / 100) + " HUNDRED " + convertBelowThousand(number % 100);
        }
    }
}
