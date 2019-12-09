package pl.ofnero.aoc2019.day04;

import java.util.function.IntPredicate;

public class Main {
    private static final int START = 246515;
    private static final int END = 739105;
    
    public static void main(String[] args) {
        IntPredicate firstPart = PasswordValidator::validate;
        IntPredicate secondPart = PasswordValidator::validatePartTwo;
        System.out.println(PasswordValidator.countGoodPasswordWithinRange(START, END, firstPart));
        System.out.println(PasswordValidator.countGoodPasswordWithinRange(START, END, secondPart));
    }
}
