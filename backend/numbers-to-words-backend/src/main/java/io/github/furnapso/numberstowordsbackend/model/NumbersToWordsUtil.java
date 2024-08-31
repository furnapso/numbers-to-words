package io.github.furnapso.numberstowordsbackend.model;

import java.util.HashMap;
import java.util.Map;

public class NumbersToWordsUtil {
    private NumbersToWordsUtil() {
    }
    private static final Map<Long, String> BELOW_TWENTY;
    private static final Map<Long, String> TENS;

    static {
        BELOW_TWENTY = new HashMap<>();
        BELOW_TWENTY.put(0L, "");
        BELOW_TWENTY.put(1L, "ONE");
        BELOW_TWENTY.put(2L, "TWO");
        BELOW_TWENTY.put(3L, "THREE");
        BELOW_TWENTY.put(4L, "FOUR");
        BELOW_TWENTY.put(5L, "FIVE");
        BELOW_TWENTY.put(6L, "SIX");
        BELOW_TWENTY.put(7L, "SEVEN");
        BELOW_TWENTY.put(8L, "EIGHT");
        BELOW_TWENTY.put(9L, "NINE");
        BELOW_TWENTY.put(10L, "TEN");
        BELOW_TWENTY.put(11L, "ELEVEN");
        BELOW_TWENTY.put(12L, "TWELVE");
        BELOW_TWENTY.put(13L, "THIRTEEN");
        BELOW_TWENTY.put(14L, "FOURTEEN");
        BELOW_TWENTY.put(15L, "FIFTEEN");
        BELOW_TWENTY.put(16L, "SIXTEEN");
        BELOW_TWENTY.put(17L, "SEVENTEEN");
        BELOW_TWENTY.put(18L, "EIGHTEEN");
        BELOW_TWENTY.put(19L, "NINETEEN");

        TENS = new HashMap<>();
        TENS.put(2L, "TWENTY");
        TENS.put(3L, "THIRTY");
        TENS.put(4L, "FORTY");
        TENS.put(5L, "FIFTY");
        TENS.put(6L, "SIXTY");
        TENS.put(7L, "SEVENTY");
        TENS.put(8L, "EIGHTY");
        TENS.put(9L, "NINETY");
    }

    public static String getBelowTwenty(long number) {
        return BELOW_TWENTY.get(number);
    }

    public static String getTens(long number) {
        return TENS.get(number);
    }
}
