package io.github.furnapso.numberstowordsbackend.parse

import spock.lang.Specification

class NumberToWordParserUnitTest extends Specification {

    def "should convert 100 to 'one hundred'"() {
        given:
        def parser = new NumberToWordParser(100)

        when:
        def result = parser.parse()

        then:
        result == "one hundred"
    }

    def "should convert 25 to 'twenty five'"() {
        given:
        def parser = new NumberToWordParser(25)

        when:
        def result = parser.parse()

        then:
        result == "twenty five"
    }

    def "should convert 123 to 'one hundred twenty three'"() {
        given:
        def parser = new NumberToWordParser(123)

        when:
        def result = parser.parse()

        then:
        result == "one hundred twenty three"
    }

    def "should convert 0 to 'zero'"() {
        given:
        def parser = new NumberToWordParser(0)

        when:
        def result = parser.parse()

        then:
        result == "zero"
    }

    def "should convert 101 to 'one hundred one'"() {
        given:
        def parser = new NumberToWordParser(101)

        when:
        def result = parser.parse()

        then:
        result == "one hundred one"
    }

    def "should convert 1000 to 'one thousand'"() {
        given:
        def parser = new NumberToWordParser(1000)

        when:
        def result = parser.parse()

        then:
        result == "one thousand"
    }

    def "should convert 2500.50 to 'two thousand five hundred DOLLARS and fifty cents'"() {
        given:
        def parser = new NumberToWordParser(2500.50)

        when:
        def result = parser.parse()

        then:
        result == "two thousand five hundred DOLLARS and fifty cents"
    }
}
