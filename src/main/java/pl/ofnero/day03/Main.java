package pl.ofnero.day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String fileName = "./inputs/day03input.txt";
        String[] moves = parseInput(fileName);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Point.makeMoves(point1, moves[0].split(","));
        Point.makeMoves(point2, moves[1].split(","));
        Set<Point> intersectionPoint = Calculator.getAllIntersectionPoints(point1, point2);
        System.out.println(Calculator.calculateDistance(intersectionPoint));
     
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
