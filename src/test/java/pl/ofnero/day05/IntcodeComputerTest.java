package pl.ofnero.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntcodeComputerTest {
    @Test
    void shouldCorrectlyChangePositions() {
        int[] program = {3, 0, 4, 0, 99};
        IntcodeComputer.process(program, 1);
        assertArrayEquals(new int[] {1, 0, 4, 0, 99}, program);
    }
    
    @Test
    void shouldCorrectlyChangePositionsWithParametersIncluded() {
        int[] program = {1002,4,3,4,33};
        IntcodeComputer.process(program, 1);
        
        assertArrayEquals(new int[] {1002, 4, 3, 4, 99}, program);
    }
    
}