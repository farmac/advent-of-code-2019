package pl.ofnero.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FuelCalculator {
    public static int calculateRequiredFuel(int mass) {
        if(mass >= 9) {
            return mass / 3 - 2 + calculateRequiredFuel(mass / 3 - 2);
        } else {
            return 0;
        }
    }
    
    public static int parseData(String input) {
        int totalFuel = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                int fuel;
                try {
                    fuel = calculateRequiredFuel(Integer.parseInt(line));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Malformed format.");
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