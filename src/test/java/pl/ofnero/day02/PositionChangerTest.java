package pl.ofnero.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionChangerTest {
    private int[] array1 = {1, 0, 0, 0, 99};
    private int[] array2 = {2, 3, 0, 3, 99};
    private int[] array3 = {2, 4, 4, 5, 99, 0};
    private int[] array4 = {1, 1, 1, 4, 99, 5, 6, 0, 99};
    private int[] array5 = {1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50};
    
    @Test
    void shouldProperlyChangePositions() {
        PositionChanger.process(array1);
        assertArrayEquals(new int[]{2, 0, 0, 0, 99}, array1);
        
        PositionChanger.process(array2);
        assertArrayEquals(new int[]{2, 3, 0, 6, 99}, array2);
        
        PositionChanger.process(array3);
        assertArrayEquals(new int[]{2, 4, 4, 5, 99, 9801}, array3);
        
        PositionChanger.process(array4);
        assertArrayEquals(new int[]{30, 1, 1, 4, 2, 5, 6, 0, 99}, array4);
        
        PositionChanger.process(array5);
        assertArrayEquals(new int[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50}, array5);
    }
}
