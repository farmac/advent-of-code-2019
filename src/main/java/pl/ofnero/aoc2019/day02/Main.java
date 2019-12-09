package pl.ofnero.aoc2019.day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String file = "./inputs/day02input.txt";
        int[] tokens = loadCode(file);
        int[] tokens2 = tokens.clone();
    
        System.out.println(PositionChanger.getValueFromIndexZero(tokens, 12, 2));
    
        System.out.println(PairDeterminator.getVerbAndNoun(19690720, tokens2));
    }
    
    private static int[] loadCode(String fileName) {
        String[] tokens = null;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            tokens = reader.readLine().split(",");
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
