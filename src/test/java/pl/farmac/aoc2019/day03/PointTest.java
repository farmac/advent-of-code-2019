package pl.farmac.aoc2019.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private Position point1 = new Position(0, 0);
    private Position point2 = new Position(0, 0);
    private Position point3 = new Position(0, 0);
    
    @Test
    void shouldBeAbleToMove() {
        point1.makeMoves(new String[]{"R21", "U31", "L15", "D5"});
        point2.makeMoves(new String[]{"R8", "U5", "L5", "D3"});
        point3.makeMoves(new String[]{"U7", "R6", "D4", "L4"});
        
        assertEquals(6, point1.getX());
        assertEquals(26, point1.getY());
        
        assertEquals(3, point2.getX());
        assertEquals(2, point2.getY());
        
        assertEquals(2, point3.getX());
        assertEquals(3, point3.getY());
    }
    
}
