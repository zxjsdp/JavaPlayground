package com.moflying.playground;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class StringPlayground {
    private static final String SPECIAL_CHARS = "aaaauccpbbgdd";
    private static final String STRING_TO_CHECK = "ufptg";

    /**
     * Convert string to a list of chars
     *
     * reference: http://stackoverflow.com/questions/15590675/converting-char-array-to-list-in-java
     */
    private static void stringToCharListPlayground() {
        List<Character> out = STRING_TO_CHECK.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        List<Character> aa = out.stream()
                .filter(c -> SPECIAL_CHARS.indexOf(c) > 0)
                .collect(Collectors.toList());

        System.out.println(aa);
        System.out.println(aa.size());
    }

    public static boolean stringContainsAnyChar(String stringToBeChecked, String stringMadeOfChars) {
        if (StringUtils.isEmpty(stringToBeChecked) || StringUtils.isEmpty(stringMadeOfChars)) {
            return false;
        }

        List<Character> charsInString =
                stringMadeOfChars.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        List<Character> charsPresent = charsInString.stream()
                .filter(c -> stringToBeChecked.indexOf(c) >= 0)
                .collect(Collectors.toList());

        return charsPresent.size() > 0;
    }

    /**
     * Display the String representation of Boolean true
     *
     * Result: "true"
     */
    private static void stringValueOf() {
        // true
        System.out.println(String.valueOf(true));
        // class java.lang.String
        System.out.println(String.valueOf(true).getClass());
    }

    /**
     * Try use null as parameter of String.format
     *
     * Result: display null
     */
    private static void playStringFormatNullParameter() {
        // This is null parameter: null
        System.out.println(
                String.format("This is null parameter: %s", null)
        );
    }

    public static void main(String[] args) {
//        stringToCharListPlayground();
//        System.out.println(stringContainsAnyChar(STRING_TO_CHECK, SPECIAL_CHARS));
//        System.out.println(stringContainsAnyChar(STRING_TO_CHECK, "*%$ "));
//        stringValueOf();
        playStringFormatNullParameter();
    }
}
