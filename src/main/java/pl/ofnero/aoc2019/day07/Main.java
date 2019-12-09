package pl.ofnero.aoc2019.day07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] program = getProgram("./inputs/day07input.txt");
        int maximumSignal = IntcodeComputer.calculateMaximumThrusterSignal(program);
        System.out.println(maximumSignal);
    }
    
    public static int[] getProgram(String fileName) {
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
