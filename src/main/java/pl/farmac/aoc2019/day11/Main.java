package pl.farmac.aoc2019.day11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] code = getDiagnosticProgram("./inputs/day11input.txt");
        long[] diagnosticProgram = new long[2000];
        Arrays.fill(diagnosticProgram, 0);
        System.arraycopy(code, 0, diagnosticProgram, 0, code.length);
        Robot robot = new Robot(diagnosticProgram);
        System.out.println(robot.countPaintedPanels());
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
