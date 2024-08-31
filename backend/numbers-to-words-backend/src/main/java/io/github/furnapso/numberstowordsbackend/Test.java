package io.github.furnapso.numberstowordsbackend;

import io.github.furnapso.numberstowordsbackend.parse.NumberToWordParser;

public class Test {
    public static void main(String[] args) {
        System.out.println(new NumberToWordParser(384934.52f).parse());
    }
}
