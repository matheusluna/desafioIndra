package com.luna.frontend.services;

public class UrlShoter {
    private static UrlShoter INSTANCE;
    private static String baseCharacters;
    public static final Integer BASE = 62;

    private UrlShoter() {
        initialize();
    }

    public static synchronized UrlShoter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UrlShoter();
        }
        return INSTANCE;
    }

    public String toBase62(String input) {
        Integer inputValue = Integer.valueOf(input);
        if (inputValue == 0) return "0";
        String output = "";
        while (inputValue > 0) {
            int remain = inputValue % BASE;
            output += baseCharacters.charAt(remain);
            inputValue /= BASE;
        }

        while (output.length() < 5) {
            output = "0".concat(output);
        }

        return output;
    }

    public String toBase10(String input) {
        Integer aux = 0;
        for (int i = input.length() - 1, exp = 0; i >= 0; i--, exp++) {
            aux += (int)(Math.pow(62, exp) * baseCharacters.indexOf(input.charAt(i)));
        }
        return String.valueOf(aux);
    }

    private void initialize() {
        baseCharacters = "";
        for (char i = '0'; i <= '9'; i++) baseCharacters += i;
        for (char i = 'a'; i <= 'z'; i++) baseCharacters += i;
        for (char i = 'A'; i <= 'Z'; i++) baseCharacters += i;
    }
}
