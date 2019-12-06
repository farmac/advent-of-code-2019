package pl.ofnero.day06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int count = OrbitChecker.countOrbits(getOrbits("./inputs/day06input.txt"));
        System.out.println(count);
    
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
