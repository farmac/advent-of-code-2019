package pl.ofnero.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoverTest {
    private Point point1 = new Point(0, 0);
    private Point point2 = new Point(0, 0);
    private Point point3 = new Point(0, 0);
    
    @Test
    void shouldProperlyMove() {
        Mover.makeMoves(point1, new String[]{"R21", "U31", "L15", "D5"});
        Mover.makeMoves(point2, new String[]{"R8", "U5", "L5", "D3"});
        Mover.makeMoves(point3, new String[]{"U7", "R6", "D4", "L4"});
        assertEquals(6, point1.getX());
        assertEquals(26, point1.getY());
        
        assertEquals(3, point2.getX());
        assertEquals(2, point2.getY());
        
        assertEquals(2, point3.getX());
        assertEquals(3, point3.getY());
    }
    
    @Test
    void shouldProperlyCalculateDistance() {
        Point point4 = new Point(0, 0);
        Point point5 = new Point(0, 0);
        Mover.makeMoves(point4, new String[]{"R8", "U5", "L5", "D3"});
        Mover.makeMoves(point5, new String[]{"U7", "R6", "D4", "L4"});
        assertEquals(6, Mover.calculateDistance(Mover.getAllIntersectionPoints(point4, point5)));
    }
    
    @Test
    void shouldProperlyCalculateDistanceAgain() {
        Point point6 = new Point(0, 0);
        Point point7 = new Point(0, 0);
        Mover.makeMoves(point6, new String[]{"R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"});
        Mover.makeMoves(point7, new String[]{"U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"});
        assertEquals(159, Mover.calculateDistance(Mover.getAllIntersectionPoints(point6, point7)));
    }
    
    @Test
    void shouldProperlyCalculateDistanceOnceMore() {
        Point point8 = new Point(0, 0);
        Point point9 = new Point(0, 0);
        Mover.makeMoves(point8, new String[]{"R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"});
        Mover.makeMoves(point9, new String[]{"U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"});
        assertEquals(135, Mover.calculateDistance(Mover.getAllIntersectionPoints(point8, point9)));
    }
}
