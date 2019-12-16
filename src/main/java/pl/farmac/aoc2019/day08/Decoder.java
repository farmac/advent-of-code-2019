package pl.farmac.aoc2019.day08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Decoder {
    
    public int calculateFinalOutput(List<Character> layer) {
        return (int) (layer.stream().filter(i -> i == '1').count() * layer.stream().filter(i -> i == '2').count());
    }
    
    public List<Character> getLayerWithLeast0Digits(List<List<Character>> layers) {
        return layers.stream()
                .min(Comparator.comparingInt(this::count0DigitsInLayer))
                .orElse(null);
    }
    
    private int count0DigitsInLayer(List<Character> layer) {
        return (int) layer.stream()
                .filter(i -> i == '0')
                .count();
    }
    
    public List<List<Character>> getLayers(String code, int width, int height) {
        List<List<Character>> layers = new ArrayList<>();
        List<Character> layer = new ArrayList<>();
        for (int i = 0, j = 1; i < code.length(); i++, j++) {
            layer.add(code.charAt(i));
            if (j == width * height) {
                layers.add(layer);
                layer = new ArrayList<>();
                j = 0;
            }
        }
        return layers;
    }
    
    public List<Character> getFullImage(List<List<Character>> layers, int width, int height) {
        List<Character> image = new ArrayList<>();
        for (int i = 0; i < width * height; i++) {
            for (List<Character> layer : layers) {
                if (layer.get(i) != '2') {
                    image.add(layer.get(i));
                    break;
                }
            }
        }
        return image;
    }
    
    public void printImage(List<Character> image, int width) {
        for (int i = 0; i < image.size(); i++) {
            if (i % width == 0) {
                System.out.println();
            }
            char pixel = image.get(i);
            if(pixel == '1') {
                System.out.print('\u2588');
            } else {
                System.out.print(" ");
            }
            
        }
    }
}
