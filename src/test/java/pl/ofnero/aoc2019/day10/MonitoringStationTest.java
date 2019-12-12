package pl.ofnero.aoc2019.day10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonitoringStationTest {
    private List<List<Character>> mapOfSpace1 = Arrays.asList(
            Arrays.asList('.', '#', '.', '.', '#'),
            Arrays.asList('.', '.', '.', '.', '.'),
            Arrays.asList('#', '#', '#', '#', '#'),
            Arrays.asList('.', '.', '.', '.', '#'),
            Arrays.asList('.', '.', '.', '#', '#')
    );
    
    private List<List<Character>> mapOfSpace2 = Arrays.asList(
            Arrays.asList('.', '.', '.', '.', '.', '.', '#', '.', '#', '.'),
            Arrays.asList('#', '.', '.', '#', '.', '#', '.', '.', '.', '.'),
            Arrays.asList('.', '.', '#', '#', '#', '#', '#', '#', '#', '.'),
            Arrays.asList('.','#','.','#','.','#','#','#','.','.'),
            Arrays.asList('.','#','.','.','#','.','.','.','.','.'),
            Arrays.asList('.','.','#','.','.','.','.','#','.','#'),
            Arrays.asList('#','.','.','#','.','.','.','.','#','.'),
            Arrays.asList('.','#','#','.','#','.','.','#','#','#'),
            Arrays.asList('#','#','.','.','.','#','.','.','#','.'),
            Arrays.asList('.','#','.','.','.','.','#','#','#','#')
    );
    private MonitoringStation monitoringStation = new MonitoringStation(mapOfSpace1);
    private MonitoringStation monitoringStation2 = new MonitoringStation(mapOfSpace2);
    
    
    @Test
    void shouldDetectRightPosition() {
        assertArrayEquals(new Integer[]{3, 4}, monitoringStation.findLocationWithMostAsteroidsDetected());
        assertArrayEquals(new Integer[]{5, 8}, monitoringStation2.findLocationWithMostAsteroidsDetected());
    }
    
    @Test
    void shouldFindCorrectNumberOfDetectedAsteroids() {
        assertEquals(8, monitoringStation.detectAsteroidsAtGivenPosition(3, 4));
        assertEquals(7, monitoringStation.detectAsteroidsAtGivenPosition(4, 4));
        assertEquals(7, monitoringStation.detectAsteroidsAtGivenPosition(4, 3));
        assertEquals(6, monitoringStation.detectAsteroidsAtGivenPosition(0, 2));
        assertEquals(33, monitoringStation2.detectAsteroidsAtGivenPosition(5, 8));
        
    }
    
}