package com.moflying.playground;

import com.moflying.playground.entities.Gender;

public class ControlFlowPlayground {
    /**
     * Make sure value is not null if we need switch
     */
    private static void switchNullValue() {
        Gender gender = null;

        try {
            // Result: NotPointerException
            switch (gender) {
                case MALE:
                    System.out.println("MALE!");
                    break;
                case FEMAIL:
                    System.out.println("FEMALE!");
                    break;
                default:
                    System.out.println("Not sure!");
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        switchNullValue();
    }
}
