package io.github.furnapso.numberstowordsbackend;

import io.github.furnapso.numberstowordsbackend.parse.NumberToWordParser;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        System.out.println(new NumberToWordParser(BigDecimal.valueOf(384934.52)).parse());
    }
}
