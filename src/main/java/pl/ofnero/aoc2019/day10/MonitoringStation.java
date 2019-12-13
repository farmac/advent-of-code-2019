package pl.ofnero.aoc2019.day10;

import java.util.*;

public class MonitoringStation {
    private List<List<Character>> mapOfSpace;
    
    private Map<Double, List<Position>> firstQuarterPoints = new TreeMap<>();
    private Map<Double, List<Position>> secondQuarterPoints = new TreeMap<>();
    private Map<Double, List<Position>> thirdQuarterPoints = new TreeMap<>();
    private Map<Double, List<Position>> fourthQuarterPoints = new TreeMap<>();
    
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
    
    /*
    public int getNumberOfAsteroidsDetectedAtFoundLocation() {
        Integer[] location = findLocationWithMostAsteroidsDetected();
        return detectAsteroidsAtGivenPosition(location[0], location[1]);
    }
    
    
     */
    public void get200thAsteroidToBeVaporized() {
        List<Position> positionList = new ArrayList<>();
        sortLists();
        System.out.println(firstQuarterPoints);
        System.out.println();
        System.out.println();
        System.out.println(secondQuarterPoints);
        System.out.println();
        System.out.println();
        System.out.println(thirdQuarterPoints);
        System.out.println();
        System.out.println();
        System.out.println(fourthQuarterPoints);
        int i = 0;
        while (i < 200) {
            for (Double trajectory : firstQuarterPoints.keySet()) {
                if(i == 200) break;
                if(firstQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = firstQuarterPoints.get(trajectory).get(0);
                System.out.println(pos);
                positionList.add(pos);
                firstQuarterPoints.get(trajectory).remove(pos);
                i++;
                
            }
            for (Double trajectory : fourthQuarterPoints.keySet()) {
                if(i == 200) break;
                if(fourthQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = fourthQuarterPoints.get(trajectory).get(0);
                System.out.println(pos);
                positionList.add(pos);
                fourthQuarterPoints.get(trajectory).remove(pos);
                i++;
                
    
    
            }
            for (Double trajectory : thirdQuarterPoints.keySet()) {
                if(i == 200) break;
                if(thirdQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = thirdQuarterPoints.get(trajectory).get(0);
                System.out.println(pos);
                positionList.add(pos);
                thirdQuarterPoints.get(trajectory).remove(pos);
                i++;
    
            }
            for (Double trajectory : secondQuarterPoints.keySet()) {
                if(i == 200) break;
    
                if(secondQuarterPoints.get(trajectory).size() == 0) {
                    continue;
                }
                Position pos = secondQuarterPoints.get(trajectory).get(0);
                System.out.println(pos);
                positionList.add(pos);
                secondQuarterPoints.get(trajectory).remove(pos);
                i++;
    
    
            }
        }
       // System.out.println(positionList.get(199));
    }
    
    private void sortLists() {
        for (List<Position> list : firstQuarterPoints.values()) {
            list.sort(Position::compareTo);
        }
        for (List<Position> list : secondQuarterPoints.values()) {
            list.sort(Position::compareTo);
        }
        for (List<Position> list : secondQuarterPoints.values()) {
            list.sort(Position::compareTo);
        }
        for (List<Position> list : secondQuarterPoints.values()) {
            list.sort(Position::compareTo);
        }
    }
}
