package io.github.furnapso.numberstowordsbackend.parse;

import com.google.common.base.Preconditions;
import io.github.furnapso.numberstowordsbackend.util.ThousandsContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsUtil.getBelowTwenty;
import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsUtil.getTens;

public class NumberToWordParser {
    public static final String AND = " AND ";
    private final long dollars;
    private final long cents;
    private BigDecimal number;
    private static final BigDecimal MAX = new BigDecimal("999999999999999");

    public NumberToWordParser(BigDecimal number) {
        Preconditions.checkArgument(number.compareTo(MAX) < 1, String.format("Maximum supported number is %s", MAX));
        this.number = number.setScale(2, RoundingMode.HALF_UP);
        var elements = this.number.abs().toString().split("\\.");
        dollars = NumberUtils.toLong(elements[0]);
        cents = NumberUtils.toLong(elements[1]);
    }

    public String parse() {
        var stack = new ArrayList<String>();

        if (number.signum() == -1) {
            stack.add("NEGATIVE");
        }

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

        return StringUtils.normalizeSpace(String.join(" ", stack));
    }

    private String convertToWords(long number) {
        var thousandsContext = new ThousandsContext();
        var stack = new ArrayList<String>();
        while (number > 0) {
            if (number % 1000 != 0) {
                stack.addFirst(convertBelowThousand(number % 1000) + " " + thousandsContext);
            }
            thousandsContext.increment();
            number = number / 1000;
        }

        if (StringUtils.isNotBlank(thousandsContext.getLast())) {
            var last = stack.getLast();
            stack.remove(last);
            var first = String.join(", ", stack).replace(AND, "");
            return stack.isEmpty() ? last : String.join(", ", first, last);
        } else {
            return String.join(AND, stack);
        }
    }

    private String convertBelowThousand(long number) {
        if (number < 20) {
            return getBelowTwenty(number);
        } else if (number < 100) {
            return getTens(number / 10) + " " + getBelowTwenty(number % 10);
        } else {
            var stringBuilder = new StringBuilder()
                    .append(getBelowTwenty(number / 100))
                    .append(" HUNDRED ");
            var belowThousand = convertBelowThousand(number % 100);
            if (StringUtils.isNotBlank(belowThousand)) {
                stringBuilder.append(AND);
            }
            return stringBuilder
                    .append(belowThousand)
                    .toString();
        }
    }
}
