package pl.ofnero.aoc2019.day07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static String INPUT = "./inputs/day07input.txt";
    
    public static void main(String[] args) {
        List<IntcodeComputerPartTwo> list = Arrays.asList(
                new IntcodeComputerPartTwo(getProgram(INPUT)),
                new IntcodeComputerPartTwo(getProgram(INPUT)),
                new IntcodeComputerPartTwo(getProgram(INPUT)),
                new IntcodeComputerPartTwo(getProgram(INPUT)),
                new IntcodeComputerPartTwo(getProgram(INPUT))
        );
        AmplifierController amplifierController = new AmplifierController(new IntcodeComputerPartOne(getProgram(INPUT)), list);
        int first = amplifierController.calculateMaximumThrusterSignal();
        int second = amplifierController.calculateMaximumThrusterSignalWithFeedbackLoop();
        
        System.out.println(first);
        System.out.println(second);
    }
    
    private static int[] getProgram(String fileName) {
        String[] tokens = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            tokens = br.readLine().split(",");
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File " + fileName + " has not been found.");
        } catch (IOException e) {
            System.out.println("Cannot read the file.");
            System.exit(0);
        }
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
