package pl.farmac.aoc2019.day10;

import java.util.*;

public class MonitoringStation {
    private List<List<Character>> mapOfSpace;
    private int x;
    private int y;
    
    private Map<Double, List<Position>> firstQuarterPoints = new TreeMap<>();
    private Map<Double, List<Position>> secondQuarterPoints = new TreeMap<>();
    private Map<Double, List<Position>> thirdQuarterPoints = new TreeMap<>();
    private Map<Double, List<Position>> fourthQuarterPoints = new TreeMap<>();
    
    public MonitoringStation(List<List<Character>> mapOfSpace) {
        this.mapOfSpace = mapOfSpace;
    }
    
    private static class Position {
        private int x2;
        private int y2;
        
        public Position(int x2, int y2) {
            this.x2 = x2;
            this.y2 = y2;
        }
        
        public int getX() {
            return x2;
        }
        
        public int getY() {
            return y2;
        }
        
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
                Double slope = Math.toDegrees(Math.atan2(i - y, j - x));
                trajectories.add(slope);
            }
        }
        return trajectories.size();
    }
    
    public void setupQuarters() {
        // x = j y = i
        for (int i = 0; i < mapOfSpace.size(); i++) {
            for (int j = 0; j < mapOfSpace.get(i).size(); j++) {
                if (j == x && i == y || mapOfSpace.get(i).get(j) == '.') {
                    continue;
                }
                Double slope = Math.toDegrees(Math.atan2(i - y, j - x));
                if (slope >= -90 && slope < 0) {
                    if (!firstQuarterPoints.containsKey(slope)) {
                        firstQuarterPoints.put(slope, new LinkedList<>());
                    }
                    firstQuarterPoints.get(slope).add(new Position(j, i));
                } else if (slope >= -180 && slope < -90) {
                    if (!secondQuarterPoints.containsKey(slope)) {
                        secondQuarterPoints.put(slope, new LinkedList<>());
                    }
                    secondQuarterPoints.get(slope).add(new Position(j, i));
                } else if (slope >= 90 && slope < 180) {
                    if (!thirdQuarterPoints.containsKey(slope)) {
                        thirdQuarterPoints.put(slope, new LinkedList<>());
                    }
                    thirdQuarterPoints.get(slope).add(new Position(j, i));
                } else if (slope >= 0 && slope < 90) {
                    if (!fourthQuarterPoints.containsKey(slope)) {
                        fourthQuarterPoints.put(slope, new LinkedList<>());
                    }
                    fourthQuarterPoints.get(slope).add(new Position(j, i));
                }
            }
        }
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
                    this.x = x;
                    this.y = y;
                }
            }
        }
        return position;
    }
    
    
    public int get200thAsteroidToBeVaporized() {
        setupQuarters();
        int i = 2;
        while (i <= 200) {
            for (Double trajectory : firstQuarterPoints.keySet()) {
                if (firstQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = firstQuarterPoints.get(trajectory).get(0);
                firstQuarterPoints.get(trajectory).remove(pos);
                if (i == 200) {
                    return pos.getX() * 100 + pos.getY();
                }
                i++;
                
            }
            for (Double trajectory : fourthQuarterPoints.keySet()) {
                if (fourthQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = fourthQuarterPoints.get(trajectory).get(0);
                fourthQuarterPoints.get(trajectory).remove(pos);
                if (i == 200) {
                    return pos.getX() * 100 + pos.getY();
                }
                i++;
            }
            for (Double trajectory : thirdQuarterPoints.keySet()) {
                if (thirdQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = thirdQuarterPoints.get(trajectory).get(0);
                thirdQuarterPoints.get(trajectory).remove(pos);
                if (i == 200) {
                    return pos.getX() * 100 + pos.getY();
                }
                i++;
            }
            for (Double trajectory : secondQuarterPoints.keySet()) {
                if (secondQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = secondQuarterPoints.get(trajectory).get(0);
                secondQuarterPoints.get(trajectory).remove(pos);
                if (i == 200) {
                    return pos.getX() * 100 + pos.getY();
                }
                i++;
            }
        }
        return 0;
    }
    
}

