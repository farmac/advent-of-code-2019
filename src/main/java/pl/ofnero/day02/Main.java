package pl.ofnero.day02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] input = PositionChanger.loadCode("./inputs/day02input.txt");
        int[] tokens = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        
        tokens[1] = 12;
        tokens[2] = 2;
    
        PositionChanger.process(tokens);
        System.out.println(tokens[0]);
    }
}
