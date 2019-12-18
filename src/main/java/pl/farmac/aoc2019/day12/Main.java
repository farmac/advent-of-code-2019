package pl.farmac.aoc2019.day12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern PATTERN = Pattern.compile("<x=(.+), y=(.+), z=(.+)>");
    private static final String FILE_NAME = "./inputs/day12input.txt";
    
    public static void main(String[] args) {
        MotionSimulator motionSimulator = new MotionSimulator(parseInput());
        motionSimulator.simulateMotion(1000);
        System.out.println(motionSimulator.getTotalEnergy());

        MotionSimulator motionSimulator1 = new MotionSimulator(parseInput());
        System.out.println(motionSimulator1.findNumberOfStepsUntilAllMoonsAreInTheSamePositionAgain());
        
    }
    
    public static Moon[] parseInput() {
        Moon[] moons = new Moon[4];
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher m = PATTERN.matcher(line);
                m.find();
                moons[i] = new Moon(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)));
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File has not been found.");
        } catch (IOException e) {
            System.out.println("Can not read the file.");
        }
        return moons;
    }
}
