package pl.ofnero.day06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrbitCheckerTest {
    @Test
    void shouldProperlyCalculateNumberOfOrbits() {
        String[] map = {"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"};
        assertEquals(42, OrbitChecker.countOrbits(map));
        
        
    }
    
}
