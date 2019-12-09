package pl.ofnero.aoc2019.day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntcodeComputerTest {
    
    @Test
    void shouldCalculateThrusterSignal() {
        assertEquals(43210, IntcodeComputer.calculateThrusterSignal(new int[] {4, 3, 2, 1, 0},
                new int[]{3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0}));
        assertEquals(54321, IntcodeComputer.calculateThrusterSignal(new int[] {0, 1, 2, 3, 4},
                new int[]{3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
                        101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0}));
        assertEquals(65210, IntcodeComputer.calculateThrusterSignal(new int[] {1, 0, 4, 3, 2},
                new int[]{3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
                        1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0}));
                        
    }
    
    @Test
    void shouldCalculateMaximumThrusterSignal() {
        assertEquals(43210, IntcodeComputer.calculateMaximumThrusterSignal(
                new int[]{3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0}));
        assertEquals(54321, IntcodeComputer.calculateMaximumThrusterSignal(
                new int[]{3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23,
                        101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0}));
        assertEquals(65210, IntcodeComputer.calculateMaximumThrusterSignal(
                new int[]{3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
                        1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0}));
    }
    
}
