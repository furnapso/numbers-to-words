package io.github.furnapso.numberstowordsbackend.service;

import io.github.furnapso.numberstowordsbackend.model.WordBuilder;
import org.springframework.stereotype.Service;

import static io.github.furnapso.numberstowordsbackend.model.NumbersToWordsConstants.BASE_NUMBER_LOOKUP;

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
    }
}
