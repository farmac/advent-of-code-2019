package pl.ofnero.aoc2019.day06;

import java.util.*;

public class OrbitChecker {
    
    
    public static int countOrbits(String[] map) {
        Map<String, String> orbits = new HashMap<>();
        int count = 0;
        for (String relation : map) {
            String[] tokens = relation.split("\\)");
            orbits.put(tokens[1], tokens[0]);
        }
        for (Map.Entry<String, String> entry : orbits.entrySet()) {
            String key = entry.getKey();
            while (orbits.containsKey(key)) {
                count++;
                key = orbits.get(key);
            }
        }
        return count;
    }
    
    
    public static int calculateMinimumNumberOfSteps(String[] map) {
        // Initialize a map
        Map<String, String> orbits = new HashMap<>();
        for (String relation : map) {
            String[] tokens = relation.split("\\)");
            orbits.put(tokens[1], tokens[0]);
        }
        
        String startingPoint = orbits.get("YOU");
        String destinationPoint = orbits.get("SAN");
        
        
        // What we're doing here is finding a interception point and summing up steps to reach it for both objects.
        Map<String, Integer> yourSteps = new HashMap<>();
        int yourCount = 0;
        int sanCount = 0;
        while (orbits.containsKey(startingPoint)) {
            yourSteps.put(startingPoint, yourCount);
            startingPoint = orbits.get(startingPoint);
            yourCount++;
            
        }
        
        while (orbits.containsKey(destinationPoint)) {
            if (yourSteps.containsKey(destinationPoint)) {
                return yourSteps.get(destinationPoint) + sanCount;
            }
            sanCount++;
            destinationPoint = orbits.get(destinationPoint);
        }
        return -1;
    }
}
