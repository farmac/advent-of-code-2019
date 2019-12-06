package pl.ofnero.day06;

import java.util.*;

public class OrbitChecker {
    
    
    public static int countOrbits(String[] map) {
        LinkedHashMap<String, String> orbits = new LinkedHashMap<>();
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
    
    
}
