package io.github.furnapso.numberstowordsbackend.model;

import java.util.HashMap;
import java.util.Map;

public class NumbersToWordsConstants {
    private NumbersToWordsConstants() {
    }

    public static final Map<Float, String> BASE_NUMBER_LOOKUP;
    public static final Map<Character, String> BASE_CHAR_LOOKUP;
    // Base
    public static final String ZERO = "ZERO";
    public static final String ONE = "ONE";
    public static final String TWO = "TWO";
    public static final String THREE = "THREE";
    public static final String FOUR = "FOUR";
    public static final String FIVE = "FIVE";
    public static final String SIX = "SIX";
    public static final String SEVEN = "SEVEN";
    public static final String EIGHT = "EIGHT";
    public static final String NINE = "NINE";

    // Teens
    public static final String ELEVEN = "ELEVEN";
    public static final String TWELVE = "TWELVE";
    public static final String THIRTEEN = "THIRTEEN";
    public static final String FOURTEEN = "FOURTEEN";
    public static final String FIFTEEN = "FIFTEEN";
    public static final String SIXTEEN = "SIXTEEN";
    public static final String SEVENTEEN = "SEVENTEEN";
    public static final String EIGHTEEN = "EIGHTEEN";
    public static final String NINETEEN = "NINETEEN";

    // Tens
    public static final Map<Character, String> TENS_CHAR_LOOKUP;
    public static final String TEN = "TEN";
    public static final String TWENTY = "TWENTY";
    public static final String THIRTY = "THIRTY";
    public static final String FORTY = "FORTY";
    public static final String FIFTY = "FIFTY";
    public static final String SIXTY = "SIXTY";
    public static final String SEVENTY = "SEVENTY";
    public static final String EIGHTY = "EIGHTY";
    public static final String NINETY = "NINETY";

    // Bigger
    public static final String HUNDRED = "HUNDRED";
    public static final String THOUSAND = "THOUSAND";
    public static final String MILLIARD = "MILLIARD";
    public static final String BILLION = "BILLION";

    static {
        BASE_NUMBER_LOOKUP = new HashMap<>();
        BASE_NUMBER_LOOKUP.put(0f, ZERO);
        BASE_NUMBER_LOOKUP.put(1f, ONE);
        BASE_NUMBER_LOOKUP.put(2f, TWO);
        BASE_NUMBER_LOOKUP.put(3f, THREE);
        BASE_NUMBER_LOOKUP.put(4f, FOUR);
        BASE_NUMBER_LOOKUP.put(5f, FIVE);
        BASE_NUMBER_LOOKUP.put(6f, SIX);
        BASE_NUMBER_LOOKUP.put(7f, SEVEN);
        BASE_NUMBER_LOOKUP.put(8f, EIGHT);
        BASE_NUMBER_LOOKUP.put(9f, NINE);
        BASE_NUMBER_LOOKUP.put(10f, TEN);
        BASE_NUMBER_LOOKUP.put(11f, ELEVEN);
        BASE_NUMBER_LOOKUP.put(12f, TWELVE);
        BASE_NUMBER_LOOKUP.put(13f, THIRTEEN);
        BASE_NUMBER_LOOKUP.put(14f, FOURTEEN);
        BASE_NUMBER_LOOKUP.put(15f, FIFTEEN);
        BASE_NUMBER_LOOKUP.put(16f, SIXTEEN);
        BASE_NUMBER_LOOKUP.put(17f, SEVENTEEN);
        BASE_NUMBER_LOOKUP.put(18f, EIGHTEEN);
        BASE_NUMBER_LOOKUP.put(19f, NINETEEN);
        BASE_NUMBER_LOOKUP.put(20f, TWENTY);
        BASE_NUMBER_LOOKUP.put(30f, THIRTY);
        BASE_NUMBER_LOOKUP.put(40f, FORTY);
        BASE_NUMBER_LOOKUP.put(50f, FIFTY);
        BASE_NUMBER_LOOKUP.put(60f, SIXTY);
        BASE_NUMBER_LOOKUP.put(70f, SEVENTY);
        BASE_NUMBER_LOOKUP.put(80f, EIGHTY);
        BASE_NUMBER_LOOKUP.put(90f, NINETY);
        BASE_NUMBER_LOOKUP.put(100f, HUNDRED);
        BASE_NUMBER_LOOKUP.put(1_000f, THOUSAND);
        BASE_NUMBER_LOOKUP.put(1_000_000_000f, MILLIARD);
        BASE_NUMBER_LOOKUP.put(1_000_000_000_000f, BILLION);

        BASE_CHAR_LOOKUP = new HashMap<>();
        BASE_CHAR_LOOKUP.put('0', ZERO);
        BASE_CHAR_LOOKUP.put('1', ONE);
        BASE_CHAR_LOOKUP.put('2', TWO);
        BASE_CHAR_LOOKUP.put('3', THREE);
        BASE_CHAR_LOOKUP.put('4', FOUR);
        BASE_CHAR_LOOKUP.put('5', FIVE);
        BASE_CHAR_LOOKUP.put('6', SIX);
        BASE_CHAR_LOOKUP.put('7', SEVEN);
        BASE_CHAR_LOOKUP.put('8', EIGHT);
        BASE_CHAR_LOOKUP.put('9', NINE);

        TENS_CHAR_LOOKUP = new HashMap<>();
        TENS_CHAR_LOOKUP.put('2', TWENTY);
        TENS_CHAR_LOOKUP.put('3', THIRTY);
        TENS_CHAR_LOOKUP.put('4', FORTY);
        TENS_CHAR_LOOKUP.put('5', FIFTY);
        TENS_CHAR_LOOKUP.put('6', SIXTY);
        TENS_CHAR_LOOKUP.put('7', SEVENTY);
        TENS_CHAR_LOOKUP.put('8', EIGHTY);
        TENS_CHAR_LOOKUP.put('9', NINETY);
    }

    public static String getBaseWordFromChar(Character c) {
        return BASE_CHAR_LOOKUP.get(c);
    }

    public static String getBaseWordFromString(String s) {
        var c = s.charAt(0);
        return BASE_CHAR_LOOKUP.get(c);
    }

    public static String getTensWordFromString(String s) {
        var c = s.charAt(0);
        return TENS_CHAR_LOOKUP.get(c);
    }
}
