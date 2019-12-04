package pl.ofnero.day04;

import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) {
        IntPredicate firstPart = PasswordValidator::validate;
        IntPredicate secondPart = PasswordValidator::validatePartTwo;
        System.out.println(PasswordValidator.countGoodPasswordWithinRange(246515, 739105, firstPart));
        System.out.println(PasswordValidator.countGoodPasswordWithinRange(246515, 739105, secondPart));
    }
}
