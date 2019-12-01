package pl.ofnero.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FuelCalculator {
    // Part 1
    public static int calculateRequiredFuel(int mass) {
        return mass / 3 - 2;
    }
    
    // Part 2
    public static int calculateRequiredFuelIncludingAdditionalFuel(String mass) {
        int requiredFuel = 0;
        int massOfModule;
        try {
            massOfModule = Integer.parseInt(mass);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Malformed format!");
        }
        
        while (massOfModule >= 9) {
            int fuel = calculateRequiredFuel(massOfModule);
            requiredFuel += fuel;
            massOfModule = fuel;
        }
        
        return requiredFuel;
    }
    
    
    
    public static int parseData(String input) {
        int totalFuel = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                    int fuel = calculateRequiredFuelIncludingAdditionalFuel(line);
                    totalFuel += fuel;
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File " + input + " has not been found.");
        } catch (IOException e) {
            System.out.println("Input / output error occured.");
            System.exit(0);
        }
        
        return totalFuel;
    }
    
    public static void main(String[] args) {
        int totalRequiredFuel = parseData("day01input.txt");
        System.out.println(totalRequiredFuel);
    }
}
