package com.codineerdigital.tugscript.classes;

public class Console {

    public static void log(String input) {
        System.out.println(input);
    }
    public static void log(Integer input) {
        log(String.valueOf(input));
    }

}
