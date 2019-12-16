package pl.farmac.aoc2019.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    @Test
    void shouldReturnTrueIfPasswordIsCorrect() {
        assertTrue(PasswordValidator.validate(111111));
        assertTrue(PasswordValidator.validate(455678));
    }
    
    @Test
    void shouldReturnFalseIfPasswordIsIncorrect() {
        assertFalse(PasswordValidator.validate(223450));
        assertFalse(PasswordValidator.validate(123789));
        assertFalse(PasswordValidator.validate(12289));
    }
    
    @Test
    void shouldReturnTrueIfPasswordIsCorrectInPartTwo() {
        assertTrue(PasswordValidator.validatePartTwo(112233));
        assertTrue(PasswordValidator.validatePartTwo(111122));
        assertTrue(PasswordValidator.validatePartTwo(123455));
    
    }
    
    @Test
    void shouldReturnFalseIfPasswordIsIncorrectInPartTwo() {
        assertFalse(PasswordValidator.validatePartTwo(123444));
        assertFalse(PasswordValidator.validatePartTwo(111234));
        assertFalse(PasswordValidator.validatePartTwo(123444));
    }
}