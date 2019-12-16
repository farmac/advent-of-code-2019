package pl.farmac.aoc2019.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FuelCalculator {
    public static int calculateRequiredFuelFirstStage(int mass) {
        return mass / 3 - 2;
    }
    
    public static int calculateRequiredFuelSecondStage(int mass) {
        if(mass >= 9) {
            return mass / 3 - 2 + calculateRequiredFuelSecondStage(mass / 3 - 2);
        } else {
            return 0;
        }
    }
    
    public static int parseData(String input, int stage) {
        int totalFuel = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                int fuel;
                try {
                    if(stage == 1) {
                        fuel = calculateRequiredFuelFirstStage(Integer.parseInt(line));
                    } else if(stage == 2) {
                        fuel = calculateRequiredFuelSecondStage(Integer.parseInt(line));
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Malformed format or wrong stage number.");
                }
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
}