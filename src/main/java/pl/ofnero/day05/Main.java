package pl.ofnero.day05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
  * In order to calculate a diagnostic code for the first part of puzzle, one has to remove or comment out switch cases
  * from 5 to 8 and change the input to 1.
*/

public class Main {
    private static final int INPUT = 5;
    public static void main(String[] args) {
        int[] diagnosticProgram = getDiagnosticProgram("./inputs/day05input.txt");
        
        IntcodeComputer.process(diagnosticProgram, INPUT);
    }
    
    public static int[] getDiagnosticProgram(String fileName) {
        String[] tokens = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            tokens = br.readLine().split(",");
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File " + fileName + " has not been found.");
        } catch (IOException e) {
            System.out.println("Input / output error occured.");
            System.exit(0);
        }
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
