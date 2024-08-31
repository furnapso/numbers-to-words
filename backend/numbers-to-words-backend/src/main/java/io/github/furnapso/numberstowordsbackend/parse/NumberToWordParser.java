package io.github.furnapso.numberstowordsbackend.parse;

import io.github.furnapso.numberstowordsbackend.util.ThousandsContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsUtil.getBelowTwenty;
import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsUtil.getTens;

public class NumberToWordParser {
    private int dollars;
    private int cents;
    private ArrayList<String> wordStack = new ArrayList<>();

    public NumberToWordParser(BigDecimal number) {
        var elements = number.toString().split("\\.");
        dollars = NumberUtils.toInt(elements[0]);
        cents = NumberUtils.toInt(elements[1]);
    }

    public String parse() {
        if (dollars > 0) {
            wordStack.addFirst(convertToWords(dollars));
            wordStack.add(dollars == 1 ? "DOLLAR" : "DOLLARS");
            if (cents > 0) {
                wordStack.add("AND");
            }
        }

        if (cents > 0) {
            wordStack.add(convertToWords(cents));
            wordStack.add(cents == 1 ? "CENT" : "CENTS");
        }

        return StringUtils.normalizeSpace(String.join(" ", wordStack));
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
