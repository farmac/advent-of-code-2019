package pl.farmac.aoc2019.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuelCalculatorTest {
    
    @Test
    void shouldCalculateFuelForFirstStageProperly() {
        assertEquals(2, FuelCalculator.calculateRequiredFuelFirstStage(12));
        assertEquals(2, FuelCalculator.calculateRequiredFuelFirstStage(14));
        assertEquals(654, FuelCalculator.calculateRequiredFuelFirstStage(1969));
        assertEquals(33583, FuelCalculator.calculateRequiredFuelFirstStage(100756));
    }
    
    @Test
    void shouldCalculateFuelForSecondStageProperly() {
        assertEquals(2, FuelCalculator.calculateRequiredFuelSecondStage(14));
        assertEquals(966, FuelCalculator.calculateRequiredFuelSecondStage(1969));
        assertEquals(50346, FuelCalculator.calculateRequiredFuelSecondStage(100756));
    }
}