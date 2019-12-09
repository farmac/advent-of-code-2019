package pl.ofnero.aoc2019.day06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "./inputs/day06input.txt";
        int count = OrbitChecker.countOrbits(getOrbits(fileName));
        int steps = OrbitChecker.calculateMinimumNumberOfSteps(getOrbits(fileName));
        System.out.println(count);
        System.out.println(steps);
    
    }
    
    public static String[] getOrbits(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines().toArray(String[]::new);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File " + fileName + " has not been found.");
        } catch (IOException e) {
            System.out.println("Input / output error occured.");
            System.exit(0);
        }
        return null;
    }
}
