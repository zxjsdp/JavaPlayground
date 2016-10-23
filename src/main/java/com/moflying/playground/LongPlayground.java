package com.moflying.playground;

public class LongPlayground {
    /**
     * How to convert Long to Integer
     *
     * References:
     * - http://stackoverflow.com/questions/5804043/convert-long-into-integer
     */
    private static void playConvertLongToInteger() {
        Long longNumber = (long) 8.33723;
        Long longNullNumber = null;

        // The following way won't work:
        //     inconvertible types: cannot cast 'java.lang.Long' to 'int'
        // Integer intNumber1 = (int) number;

        // In both methods, we might run into overflows,
        // because a Long can store a wider range than an Integer.

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Method 1 (Recommended)
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Recommended
        Integer intNullOrNotNumber = longNullNumber != null ?
                longNullNumber.intValue() :
                null;
        System.out.println(intNullOrNotNumber);

        // Cannot deal with null Long value
        Integer intNumber1 = longNumber.intValue();
        System.out.println(intNumber1);

        // NullPointerException when Long is null
        try {
            Integer intNullNumber = longNullNumber.intValue();
            System.out.println(intNullNumber);
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Method 2 (Not recommended)
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Integer intNumber2 = (int) (long) longNumber;
        System.out.println(intNumber2);
    }

    public static void main(String[] args) {
        playConvertLongToInteger();
    }
}
