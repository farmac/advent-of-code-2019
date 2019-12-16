package pl.farmac.aoc2019.day10;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String fileName = "./inputs/day10input.txt";
    
    public static void main(String[] args) {
        
        List<List<Character>> map = parseInput();
        MonitoringStation monitoringStation = new MonitoringStation(map);
        Integer[] monitoringStationLocation = monitoringStation.findLocationWithMostAsteroidsDetected();
        System.out.println(monitoringStation.detectAsteroidsAtGivenPosition(monitoringStationLocation[0],
                monitoringStationLocation[1]));
        int positionOfVaporizedAsteroid = monitoringStation.get200thAsteroidToBeVaporized();
        System.out.println(positionOfVaporizedAsteroid);
        
        
    }
    
    private static List<List<Character>> parseInput() {
        List<List<Character>> map = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(Main.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Character> row = line.chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toList());
                map.add(row);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File " + Main.fileName + " could not be found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return map;
    }
}
