package io.github.furnapso.numberstowordsbackend.model;

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
    private float number;
    private Float wholeNumber;
    private Float decimal;
    private int wholeNumberLength;

    public WordBuilder(float number) {
        this.number = number;
        this.hasDecimals = number != Math.floor(number);
        this.numAsString = String.valueOf(number);
        this.wholeNumberLength = numAsString.length();

        if (hasDecimals) {
            var parts = numAsString.split("\\.");
            this.wholeNumber = NumberUtils.toFloat(parts[0]);
            this.decimal = NumberUtils.toFloat(parts[1]);
            this.wholeNumberLength = parts[0].length();
        }
    }

    public WordBuilder addElement(String element) {
        elements.add(element);
        return this;
    }

    public Float getWholeNumber() {
        Preconditions.checkState(hasDecimals, "Number does not have decimals");
        return wholeNumber;
    }

    public Float getDecimal() {
        Preconditions.checkState(hasDecimals, "Number does not have decimals");
        return decimal;
    }

    public String build() {
        return "";
    }
}
