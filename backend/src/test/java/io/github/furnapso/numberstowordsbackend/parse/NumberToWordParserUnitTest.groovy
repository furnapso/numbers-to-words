package io.github.furnapso.numberstowordsbackend.parse

import spock.lang.Specification
import spock.lang.Unroll

class NumberToWordParserUnitTest extends Specification {

    @Unroll
    def "should correctly parse #number to words"() {
        given:
        def parser = new NumberToWordParser(number)

        expect:
        parser.parse() == expectedWords

        where:
        number                    || expectedWords
        new BigDecimal("123.45")  || "ONE HUNDRED AND TWENTY THREE DOLLARS AND FORTY FIVE CENTS"
        new BigDecimal("1.01")    || "ONE DOLLAR AND ONE CENT"
        new BigDecimal("0.00")    || "ZERO DOLLARS"
        new BigDecimal("1000.00") || "ONE THOUSAND DOLLARS"
        new BigDecimal("200.01")  || "TWO HUNDRED DOLLARS AND ONE CENT"
        new BigDecimal("0.99")    || "NINETY NINE CENTS"
    }

    @Unroll
    def "should handle edge cases for #number"() {
        given:
        def parser = new NumberToWordParser(number)

        expect:
        parser.parse() == expectedWords

        where:
        number                         || expectedWords
        new BigDecimal("100.00")       || "ONE HUNDRED DOLLARS"
        new BigDecimal("999999.99")    || "NINE HUNDRED NINETY NINE THOUSAND, NINE HUNDRED AND NINETY NINE DOLLARS AND NINETY NINE CENTS"
        new BigDecimal("999999999.99") || "NINE HUNDRED NINETY NINE MILLION, NINE HUNDRED NINETY NINE THOUSAND, NINE HUNDRED AND NINETY NINE DOLLARS AND NINETY NINE CENTS"
        new BigDecimal("1000000.00")   || "ONE MILLION DOLLARS"
    }

    def "should handle negative numbers gracefully"() {
        given:
        def parser = new NumberToWordParser(new BigDecimal("-123.45"))

        when:
        def result = parser.parse()

        then:
        result == "NEGATIVE ONE HUNDRED AND TWENTY THREE DOLLARS AND FORTY FIVE CENTS"
    }

    def "should handle the maximum number correctly"() {
        given:
        def parser = new NumberToWordParser(new BigDecimal("999999999999999.99"))

        expect:
        parser.parse() == "NINE HUNDRED NINETY NINE TRILLION, NINE HUNDRED NINETY NINE BILLION, NINE HUNDRED NINETY NINE MILLION, NINE HUNDRED NINETY NINE THOUSAND, NINE HUNDRED AND NINETY NINE DOLLARS AND NINETY NINE CENTS"
    }

    def "should throw an exception for numbers exceeding the maximum limit"() {
        when:
        new NumberToWordParser(new BigDecimal("1000000000000000.00"))

        then:
        thrown(IllegalArgumentException)
    }
}
