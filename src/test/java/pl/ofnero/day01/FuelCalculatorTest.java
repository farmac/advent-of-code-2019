package pl.ofnero.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuelCalculatorTest {
    
    @Test
    void shouldCalculateFuelProperly() {
        assertEquals(2, FuelCalculator.calculateRequiredFuel(14));
        assertEquals(966, FuelCalculator.calculateRequiredFuel(1969));
        assertEquals(50346, FuelCalculator.calculateRequiredFuel(100756));
    }
}