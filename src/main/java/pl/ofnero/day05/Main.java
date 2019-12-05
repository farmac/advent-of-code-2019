package pl.ofnero.day05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int ONLY_INPUT = 1;
    public static void main(String[] args) {
        int[] diagnosticProgram = getDiagnosticProgram("./inputs/day05input.txt");
        
        IntcodeComputer.process(diagnosticProgram, ONLY_INPUT);
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
