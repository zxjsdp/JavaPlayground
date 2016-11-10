package com.moflying.playground;

import com.moflying.playground.entities.ArgCarrier;

public class SysPlayground {
    private static void playMethodArgs(Object... args) {
        System.out.println("args: " + args);
        System.out.println("args length: " + args.length);
        System.out.println("args[0]: " + args[0]);
    }

    private static void playVariableNumberOfArgs(ArgCarrier... args) {
        System.out.println("Arg length: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Now: " + i);
            System.out.println("Class: " + args[i].getaClass());
            Class c = args[i].getaClass();
            System.out.println(c.equals(Integer.class));
        }
    }

    public static void main(String[] args) {
//        playMethodArgs(2, "play", 3.2, "ground", 9, true);
        playVariableNumberOfArgs(new ArgCarrier(Integer.class, "3"), new ArgCarrier(Double.class, "4"));
    }
}
