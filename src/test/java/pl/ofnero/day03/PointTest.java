package pl.ofnero.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private Point point1 = new Point(0, 0);
    private Point point2 = new Point(0, 0);
    private Point point3 = new Point(0, 0);
    
    @Test
    void shouldBeAbleToMove() {
        Point.makeMoves(point1, new String[]{"R21", "U31", "L15", "D5"});
        Point.makeMoves(point2, new String[]{"R8", "U5", "L5", "D3"});
        Point.makeMoves(point3, new String[]{"U7", "R6", "D4", "L4"});
        assertEquals(6, point1.getX());
        assertEquals(26, point1.getY());
        
        assertEquals(3, point2.getX());
        assertEquals(2, point2.getY());
        
        assertEquals(2, point3.getX());
        assertEquals(3, point3.getY());
    }
    
}
