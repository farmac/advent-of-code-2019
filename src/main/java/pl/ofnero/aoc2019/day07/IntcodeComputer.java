package pl.ofnero.aoc2019.day07;

import java.util.ArrayList;
import java.util.List;

public class IntcodeComputer {
    public static int process(int[] array, int phaseSetting, int inputNumber) {
        // Modes
        // 0 - position mode
        // 1 - immediate mode
        int firstParameter = 0, secondParameter = 0, mode, position = 0, posForCodeThreeOrFour;
        int i = 0;
        int inputCount = 0;
        while (true) {
            String instructions = String.format("%05d", array[i]);
            int opcode = Integer.parseInt(instructions.substring(3));
            if (opcode == 99) {
                break;
            }
            
            if (opcode != 3 && opcode != 4) {
                firstParameter = instructions.charAt(2) == '0' ? array[array[i + 1]] : array[i + 1];
                secondParameter = instructions.charAt(1) == '0' ? array[array[i + 2]] : array[i + 2];
                mode = instructions.charAt(0) == '0' ? 0 : 1;
                position = mode == 0 ? array[i + 3] : (i + 3);
            }
            posForCodeThreeOrFour = instructions.charAt(2) != '1' ? array[i + 1] : (i + 1);
            
            if (opcode == 1) {
                array[position] = firstParameter + secondParameter;
                i += 4;
            } else if (opcode == 2) {
                array[position] = firstParameter * secondParameter;
                i += 4;
            } else if (opcode == 3) {
                int input = inputCount == 0 ? phaseSetting : inputNumber;
                array[posForCodeThreeOrFour] = input;
                inputCount++;
                i += 2;
            } else if (opcode == 4) {
                return array[posForCodeThreeOrFour];
            } else if (opcode == 5) {
                i = firstParameter != 0 ? secondParameter : (i + 3);
            } else if (opcode == 6) {
                i = firstParameter == 0 ? secondParameter : (i + 3);
            } else if (opcode == 7) {
                array[position] = (firstParameter < secondParameter) ? 1 : 0;
                i += 4;
            } else if (opcode == 8) {
                array[position] = (firstParameter == secondParameter) ? 1 : 0;
                i += 4;
            }
        }
        return -1;
    }
    
    public static int calculateThrusterSignal(int[] amplifiers, int[] program) {
        int signal = process(program, amplifiers[0], 0);
        
        for (int i = 1; i < 5; i++) {
            signal = process(program, amplifiers[i], signal);
        }
        
        return signal;
    }
    
    
    public static int calculateMaximumThrusterSignal(int[] program) {
        int max = 0;
        for(int[] settingSequence: getPermutations()) {
            int signal = calculateThrusterSignal(settingSequence, program);
            if(signal > max) {
                max = signal;
            }
        }
        return max;
    }
    
    private static List<int[]> getPermutations() {
        List<int[]> list = new ArrayList<>();
        int[] elements = {0, 1, 2, 3, 4};
        int[] temp = elements.clone();
        list.add(temp);
        int[] indexes = new int[5];
        for (int i = 0; i < 5; i++) {
            indexes[i] = 0;
        }
    
        int i = 0;
        while (i < 5) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                temp = elements.clone();
                list.add(temp);
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }
        return list;
    }
    
    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}
