package io.github.furnapso.numberstowordsbackend.model;

import java.util.HashMap;
import java.util.Map;

public class NumbersToWordsUtil {
    private NumbersToWordsUtil() {
    }
    private static final Map<Integer, String> BELOW_TWENTY;
    private static final Map<Integer, String> TENS;

    static {
        BELOW_TWENTY = new HashMap<>();
        BELOW_TWENTY.put(0, "");
        BELOW_TWENTY.put(1, "ONE");
        BELOW_TWENTY.put(2, "TWO");
        BELOW_TWENTY.put(3, "THREE");
        BELOW_TWENTY.put(4, "FOUR");
        BELOW_TWENTY.put(5, "FIVE");
        BELOW_TWENTY.put(6, "SIX");
        BELOW_TWENTY.put(7, "SEVEN");
        BELOW_TWENTY.put(8, "EIGHT");
        BELOW_TWENTY.put(9, "NINE");
        BELOW_TWENTY.put(10, "TEN");
        BELOW_TWENTY.put(11, "ELEVEN");
        BELOW_TWENTY.put(12, "TWELVE");
        BELOW_TWENTY.put(13, "THIRTEEN");
        BELOW_TWENTY.put(14, "FOURTEEN");
        BELOW_TWENTY.put(15, "FIFTEEN");
        BELOW_TWENTY.put(16, "SIXTEEN");
        BELOW_TWENTY.put(17, "SEVENTEEN");
        BELOW_TWENTY.put(18, "EIGHTEEN");
        BELOW_TWENTY.put(19, "NINETEEN");

        TENS = new HashMap<>();
        TENS.put(2, "TWENTY");
        TENS.put(3, "THIRTY");
        TENS.put(4, "FOURTY");
        TENS.put(5, "FIFTY");
        TENS.put(6, "SIXTY");
        TENS.put(7, "SEVENTY");
        TENS.put(8, "EIGHTY");
        TENS.put(9, "NINETY");
    }

    public static String getBelowTwenty(int number) {
        return BELOW_TWENTY.get(number);
    }

    public static String getTens(int number) {
        return TENS.get(number);
    }
}
