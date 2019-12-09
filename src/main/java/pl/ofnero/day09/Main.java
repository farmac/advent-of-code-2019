package pl.ofnero.day09;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int INPUT = 1;
    
    public static void main(String[] args) {
        long[] main = getDiagnosticProgram("./inputs/day09input.txt");
        long[] diagnosticProgram = new long[1100];
        Arrays.fill(diagnosticProgram , 0);
        for (int i = 0; i < main.length; i++) {
            diagnosticProgram[i] = main[i];
        }
        Computer.process(diagnosticProgram, INPUT);
    }
    
    public static long[] getDiagnosticProgram(String fileName) {
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
                .mapToLong(Long::parseLong)
                .toArray();
    }
}
