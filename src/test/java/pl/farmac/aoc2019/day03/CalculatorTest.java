package pl.farmac.aoc2019.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @Test
    void shouldProperlyCalculateDistance() {
        Position point1 = new Position(0, 0);
        Position point2 = new Position(0, 0);
        point1.makeMoves(new String[]{"R8", "U5", "L5", "D3"});
        point2.makeMoves(new String[]{"U7", "R6", "D4", "L4"});
        assertEquals(6, Calculator.calculateDistance(Calculator.getAllIntersectionPoints(point1, point2)));
    }
    
    @Test
    void shouldProperlyCalculateDistance2() {
        Position point1 = new Position(0, 0);
        Position point2 = new Position(0, 0);
        point1.makeMoves(new String[]{"R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"});
        point2.makeMoves(new String[]{"U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"});
        assertEquals(159, Calculator.calculateDistance(Calculator.getAllIntersectionPoints(point1, point2)));
    }
    
    @Test
    void shouldProperlyCalculateDistance3() {
        Position point1 = new Position(0, 0);
        Position point2 = new Position(0, 0);
        point1.makeMoves(new String[]{"R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"});
        point2.makeMoves(new String[]{"U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"});
        assertEquals(135, Calculator.calculateDistance(Calculator.getAllIntersectionPoints(point1, point2)));
    }
    
    @Test
    void shouldProperlyCalculateStepsToFirstInterceptionPoint() {
        Position p1 = new Position(0, 0);
        Position p2 = new Position(0, 0);
        p1.makeMoves(new String[]{"R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"});
        p2.makeMoves(new String[]{"U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"});
        assertEquals(610, Calculator.calculateStepsToTheClosestInterceptionPoint(p1, p2));
    }
    
    @Test
    void shouldProperlyCalculateStepsToFirstInterceptionPoint2() {
        Position p1 = new Position(0, 0);
        Position p2 = new Position(0, 0);
        p1.makeMoves(new String[]{"R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"});
        p2.makeMoves(new String[]{"U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"});
        assertEquals(410, Calculator.calculateStepsToTheClosestInterceptionPoint(p1, p2));
    }
    
    @Test
    void shouldProperlyCalculateStepsToFirstInterceptionPoint3() {
        Position p1 = new Position(0, 0);
        Position p2 = new Position(0, 0);
        p1.makeMoves(new String[]{"R8", "U5", "L5", "D3"});
        p2.makeMoves(new String[]{"U7", "R6", "D4", "L4"});
        assertEquals(30, Calculator.calculateStepsToTheClosestInterceptionPoint(p1, p2));
    }
}
