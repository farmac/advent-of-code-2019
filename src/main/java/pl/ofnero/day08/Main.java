package pl.ofnero.day08;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final int WIDTH = 25;
    private static final int HEIGHT = 6;
    
    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        int value = decoder.calculateFinalOutput(decoder.getLayerWithLeast0Digits(decoder.getLayers(getCode(), WIDTH, HEIGHT)));
        System.out.println(value);
    }
    
    private static String getCode() {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader("./inputs/day08input.txt"))) {
            line = br.readLine();
        } catch (IOException ignored) {
        }
        return line;
    }
}
