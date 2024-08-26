package io.github.furnapso.numberstowordsbackend.service

import spock.lang.Specification

class NumbersToWordsServiceSpec extends Specification {

    def numbersToWordsService = new NumbersToWordsService()

    def "convertNumbersToWords should correctly convert single-digit numbers"() {
        expect:
        numbersToWordsService.convertNumbersToWords(input) == expected

        where:
        input | expected
        0     | "ZERO"
        1     | "ONE"
        5     | "FIVE"
        9     | "NINE"
    }

    def "convertNumbersToWords should correctly convert two-digit numbers"() {
        expect:
        numbersToWordsService.convertNumbersToWords(input) == expected

        where:
        input | expected
        10    | "TEN"
        11    | "ELEVEN"
        20    | "TWENTY"
        25    | "TWENTY FIVE"
        99    | "NINETY NINE"
    }

    def "convertNumbersToWords should correctly convert three-digit numbers"() {
        expect:
        numbersToWordsService.convertNumbersToWords(input) == expected

        where:
        input | expected
        100   | "ONE HUNDRED"
        101   | "ONE HUNDRED AND ONE"
        250   | "TWO HUNDRED AND FIFTY"
        999   | "NINE HUNDRED AND NINETY NINE"
    }

    def "convertNumbersToWords should correctly handle decimal numbers"() {
        expect:
        numbersToWordsService.convertNumbersToWords(input) == expected

        where:
        input   | expected
        10.5f   | "TEN POINT FIVE"
        25.75f  | "TWENTY FIVE POINT SEVENTY FIVE"
        100.01f | "ONE HUNDRED POINT ZERO ONE"
    }
}
