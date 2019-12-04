package pl.ofnero.day04;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PasswordValidator {
    public static boolean validate(int password) {
        boolean correctPassword = false;
        
        int[] digits = Arrays.stream(Integer.toString(password)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        if (digits.length != 6) {
            return false;
        }
        
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] == digits[i + 1]) {
                correctPassword = true;
            }
            if (digits[i] > digits[i + 1]) {
                return false;
            }
        }
        
        return correctPassword;
    }
    
    public static boolean validatePartTwo(int password) {
        int[] digits = Arrays.stream(Integer.toString(password)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        if (digits.length != 6) {
            return false;
        }
        
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] > digits[i + 1]) {
                return false;
            }
        }
        for (int i = 1; i < digits.length - 2; i++) {
            if (digits[i] == digits[i + 1] && digits[i] != digits[i - 1] && digits[i] != digits[i + 2]) {
                return true;
            }
        }
        return digits[0] == digits[1] && digits[0] != digits[2]
                || digits[digits.length - 2] == digits[digits.length - 1] && digits[digits.length - 2] != digits[digits.length - 3];
    }
    
    public static int countGoodPasswordWithinRange(int start, int end, IntPredicate predicate) {
        return (int) IntStream.rangeClosed(start, end)
                .filter(predicate)
                .count();
    }
}
