package pl.ofnero.day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PositionChanger {
    public static void process(int[] array) {
        for (int i = 0; i < array.length - 4; i += 4) {
            int opcode = array[i];
            switch (opcode) {
                case 1:
                    array[array[i+3]] = array[array[i+1]] + array[array[i+2]];
                    break;
                case 2:
                    array[array[i+3]] = array[array[i+1]] * array[array[i+2]];
                    break;
                case 99:
                    break;
            }
        }
    }
    
    public static String[] loadCode(String fileName) {
        String[] tokens = null;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            tokens = reader.readLine().split(",");
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File " + fileName + " has not been found.");
        } catch (IOException e) {
            System.out.println("Input / output error occured.");
            System.exit(0);
        }
    
        return tokens;
    }
}
