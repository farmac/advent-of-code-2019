package pl.ofnero.day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "./inputs/day03input.txt";
        String[] moves = parseInput(fileName);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        point1.makeMoves(moves[0].split(","));
        point2.makeMoves(moves[1].split(","));
        System.out.println(Calculator.calculateStepsToTheClosestInterceptionPoint(point1, point2));
    }
    
    public static String[] parseInput(String fileName) {
        String[] tokens = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            tokens = br.lines()
                    .toArray(String[]::new);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File " + fileName + " has not been found.");
        } catch (IOException e) {
            System.out.println("Input / output error occured.");
            System.exit(0);
        }
        return tokens;
    }
}
