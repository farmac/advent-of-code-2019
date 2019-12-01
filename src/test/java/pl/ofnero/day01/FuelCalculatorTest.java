package pl.ofnero.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuelCalculatorTest {
    
    @Test
    void shouldCalculateAFuelProperly() {
        assertEquals(2, FuelCalculator.calculateRequiredFuel(12));
        assertEquals(2, FuelCalculator.calculateRequiredFuel(14));
        assertEquals(654, FuelCalculator.calculateRequiredFuel(1969));
        assertEquals(33583, FuelCalculator.calculateRequiredFuel(100756));
    }
    
    @Test
    void shouldThrowExceptionWhenLineHasIllegalFormat() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> FuelCalculator.calculateRequiredFuelIncludingAdditionalFuel("")),
                () -> assertThrows(IllegalArgumentException.class, () -> FuelCalculator.calculateRequiredFuelIncludingAdditionalFuel(" ")),
                () -> assertThrows(IllegalArgumentException.class, () -> FuelCalculator.calculateRequiredFuelIncludingAdditionalFuel("asd"))
        );
    }
    
    @Test
    void shouldCalculateAdditionalFuelProperly() {
        assertEquals(2, FuelCalculator.calculateRequiredFuelIncludingAdditionalFuel("14"));
        assertEquals(966, FuelCalculator.calculateRequiredFuelIncludingAdditionalFuel("1969"));
        assertEquals(50346, FuelCalculator.calculateRequiredFuelIncludingAdditionalFuel("100756"));
    }
    
}