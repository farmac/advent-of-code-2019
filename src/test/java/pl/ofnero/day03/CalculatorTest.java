package pl.ofnero.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @Test
    void shouldProperlyCalculateDistance() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Point.makeMoves(point1, new String[]{"R8", "U5", "L5", "D3"});
        Point.makeMoves(point2, new String[]{"U7", "R6", "D4", "L4"});
        assertEquals(6, Calculator.calculateDistance(Calculator.getAllIntersectionPoints(point1, point2)));
    }
    
    @Test
    void shouldProperlyCalculateDistanceAgain() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Point.makeMoves(point1, new String[]{"R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"});
        Point.makeMoves(point2, new String[]{"U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"});
        assertEquals(159, Calculator.calculateDistance(Calculator.getAllIntersectionPoints(point1, point2)));
    }
    
    @Test
    void shouldProperlyCalculateDistanceOnceMore() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Point.makeMoves(point1, new String[]{"R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"});
        Point.makeMoves(point2, new String[]{"U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"});
        assertEquals(135, Calculator.calculateDistance(Calculator.getAllIntersectionPoints(point1, point2)));
    }
}
