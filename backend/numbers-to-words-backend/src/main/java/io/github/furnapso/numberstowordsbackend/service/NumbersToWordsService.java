package io.github.furnapso.numberstowordsbackend.service;

import io.github.furnapso.numberstowordsbackend.model.WordBuilder;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsConstants.BASE_NUMBER_LOOKUP;
import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsConstants.TENS_CHAR_LOOKUP;

@Service
public class NumbersToWordsService {
    public String convertNumbersToWords(float number) {
        // Base cases
        if (BASE_NUMBER_LOOKUP.containsKey(number)) {
            return BASE_NUMBER_LOOKUP.get(number);
        }

        var wordBuilder = new WordBuilder(number);
        if (wordBuilder.isHasDecimals()) {
            wordBuilder.addElement(convertNumbersToWords(wordBuilder.getDecimal()));
        }

        var numAsString = wordBuilder.getNumAsString();
        var wholeNumberLength = wordBuilder.getWholeNumberLength();
        var baseNumber = NumberUtils.toFloat(String.valueOf(numAsString.charAt(wholeNumberLength - 1)));
        wordBuilder.addElement(convertNumbersToWords(baseNumber));

        if (wholeNumberLength == 2) {
            wordBuilder.addElement(TENS_CHAR_LOOKUP.get(numAsString.charAt(0)));
        } else if (wholeNumberLength == 3) {
            wordBuilder.addElement(convertNumbersToWords(NumberUtils.toFloat(numAsString.substring(0, 2))));
        }

        return wordBuilder.build();
    }
}
