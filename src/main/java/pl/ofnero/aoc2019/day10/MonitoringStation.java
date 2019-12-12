package pl.ofnero.aoc2019.day10;

import java.util.*;

public class MonitoringStation {
    private List<List<Character>> mapOfSpace;
    
    public MonitoringStation(List<List<Character>> mapOfSpace) {
        this.mapOfSpace = mapOfSpace;
    }
    
    public int detectAsteroidsAtGivenPosition(int x, int y) {
        if (mapOfSpace.get(y).get(x) == '.') {
            return 0;
        }
        Set<Double> trajectories = new HashSet<>();
        // x = j y = i
        for (int i = 0; i < mapOfSpace.size(); i++) {
            for (int j = 0; j < mapOfSpace.get(i).size(); j++) {
                if (j == x && i == y || mapOfSpace.get(i).get(j) == '.') {
                    continue;
                }
                Double slope = Math.atan2(i - y, j - x);
                trajectories.add(slope);
            }
        }
        return trajectories.size();
    }
    
    public Integer[] findLocationWithMostAsteroidsDetected() {
        int detectedAsteroids = 0;
        Integer[] position = new Integer[2];
        for (int y = 0; y < mapOfSpace.size(); y++) {
            for (int x = 0; x < mapOfSpace.get(y).size(); x++) {
                int temp = detectAsteroidsAtGivenPosition(x, y);
                if (temp > detectedAsteroids) {
                    position[0] = x;
                    position[1] = y;
                    detectedAsteroids = temp;
                }
            }
        }
        return position;
    }
    
    public int getNumberOfAsteroidsDetectedAtFoundLocation() {
        Integer[] location = findLocationWithMostAsteroidsDetected();
        return detectAsteroidsAtGivenPosition(location[0], location[1]);
    }
}
