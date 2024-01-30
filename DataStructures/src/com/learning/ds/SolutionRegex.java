package com.learning.ds;

public class SolutionRegex {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));  // false
        System.out.println(isMatch("aa", "a*")); // true
        System.out.println(isMatch("maabyc", "ma*b.c"));  // true
    }

    public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean firstMatch = false;
        if (!text.isEmpty() &&
                (isCharacterAtIndexSame(text, pattern) || doesPatternStartsWithDot(pattern))) {
            firstMatch = true;
        }

        if (pattern.length() >= 2 && doesPatternHasStar(pattern)) {
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        }

        return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }

    private static boolean isCharacterAtIndexSame(String text, String pattern) {
        return text.charAt(0) == pattern.charAt(0);
    }

    private static boolean doesPatternStartsWithDot(String pattern) {
        return pattern.charAt(0) == '.';
    }

    private static boolean doesPatternHasStar(String pattern) {
        return pattern.charAt(1) == '*';
    }
}