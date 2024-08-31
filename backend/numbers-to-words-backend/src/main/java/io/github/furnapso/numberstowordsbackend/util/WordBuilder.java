package io.github.furnapso.numberstowordsbackend.util;

import com.google.common.base.Preconditions;
import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class WordBuilder {
    private List<String> elements = new ArrayList<>();
    private boolean hasDecimals;
    private String numAsString;
    private Float number;
    private Integer wholeNumber;
    private Integer decimal;
    private String wholeNumberAsString;
    private Integer wholeNumberLength;

    public WordBuilder(Float number) {
        this.number = number;
        this.hasDecimals = number != Math.floor(number);
        this.numAsString = String.valueOf(number);
        this.wholeNumber = number.intValue();
        this.wholeNumberAsString = wholeNumber.toString();
        this.wholeNumberLength = wholeNumberAsString.length();

        if (hasDecimals) {
            var parts = numAsString.split("\\.");
            this.wholeNumber = NumberUtils.toInt(parts[0]);
            this.decimal = NumberUtils.toInt(parts[1]);
            this.wholeNumberLength = parts[0].length();
        }
    }

    public WordBuilder addElement(String element) {
        elements.add(element);
        return this;
    }

    public Integer getWholeNumber() {
        Preconditions.checkState(hasDecimals, "Number does not have decimals");
        return wholeNumber;
    }

    public Integer getDecimal() {
        Preconditions.checkState(hasDecimals, "Number does not have decimals");
        return decimal;
    }

    public String build() {
        Preconditions.checkState(!elements.isEmpty(), "Must have at least one element");

        var length = elements.size();
        var builder = new StringBuilder();
        var reversed = elements.reversed();

        if (length == 1) {
            builder.append(elements.getFirst());
            if (hasDecimals) {
                builder.append(" CENTS");
            } else {
                builder.append(" DOLLARS");
            }
        }

        return builder.toString();
    }
}
