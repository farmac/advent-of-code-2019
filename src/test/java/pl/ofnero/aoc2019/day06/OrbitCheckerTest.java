package pl.ofnero.aoc2019.day06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrbitCheckerTest {
    @Test
    void shouldCorrectlyCalculateNumberOfOrbits() {
        String[] map = {"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"};
        assertEquals(42, OrbitChecker.countOrbits(map));
    }
    
    @Test
    void shouldCorrectlyCalculateTheMinimumNumberOfOrbitalTransfers() {
        String[] map = {"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L", "K)YOU", "I)SAN"};
        assertEquals(4, OrbitChecker.calculateMinimumNumberOfSteps(map));
    }
    
    
}
