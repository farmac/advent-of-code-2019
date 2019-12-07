package pl.ofnero.day07;

import java.util.ArrayList;
import java.util.List;

public class IntcodeComputer {
    public static int process(int[] array, int phaseSetting, int inputNumber) {
        int i = 0;
        int inputCount = 0;
        while (true) {
            String instructions = String.format("%05d", array[i]);
            int opcode = Integer.parseInt(instructions.substring(3));
            if (opcode == 99) {
                break;
            }
            switch (opcode) {
                case 1:
                    switchPoints(array, i, instructions, 1);
                    i += 4;
                    break;
                case 2:
                    switchPoints(array, i, instructions, 2);
                    i += 4;
                    break;
                case 3:
                    int input = inputCount == 0 ? phaseSetting : inputNumber;
                    if (instructions.charAt(2) != '1') {
                        array[array[i + 1]] = input;
                    } else {
                        array[i + 1] = input;
                    }
                    i += 2;
                    inputCount++;
                    break;
                case 4:
                    if (instructions.charAt(2) != '1') {
                        return array[array[i + 1]];
                    } else {
                        return array[i + 1];
                    }
                
                case 5:
                    int firstParameter = instructions.charAt(2) == '0' ? array[array[i + 1]] : array[i + 1];
                    int secondParameter = instructions.charAt(1) == '0' ? array[array[i + 2]] : array[i + 2];
                    if (firstParameter != 0) {
                        i = secondParameter;
                    } else {
                        i += 3;
                    }
                    break;
                case 6:
                    int firstParameter6 = instructions.charAt(2) == '0' ? array[array[i + 1]] : array[i + 1];
                    int secondParameter6 = instructions.charAt(1) == '0' ? array[array[i + 2]] : array[i + 2];
                    if (firstParameter6 == 0) {
                        i = secondParameter6;
                    } else {
                        i += 3;
                    }
                    break;
                case 7:
                    switchPoints(array, i, instructions, 7);
                    i += 4;
                    break;
                case 8:
                    switchPoints(array, i, instructions, 8);
                    i += 4;
                    break;
            }
        }
        return -1;
    }
    
    private static void switchPoints(int[] program, int index, String instructions, int opcode) {
        // true = position mode
        // false = immediate mode
        boolean firstParameterMode = instructions.charAt(2) == '0';
        boolean secondParameterMode = instructions.charAt(1) == '0';
        boolean thirdParameterMode = instructions.charAt(0) == '0';
        
        int firstParameter = firstParameterMode ? program[program[index + 1]] : program[index + 1];
        int secondParameter = secondParameterMode ? program[program[index + 2]] : program[index + 2];
        
        if (thirdParameterMode) {
            if (opcode == 1) {
                program[program[index + 3]] = firstParameter + secondParameter;
            } else if (opcode == 2) {
                program[program[index + 3]] = firstParameter * secondParameter;
            } else if (opcode == 7) {
                if (firstParameter < secondParameter) {
                    program[program[index + 3]] = 1;
                } else {
                    program[program[index + 3]] = 0;
                }
            } else if (opcode == 8) {
                if (firstParameter == secondParameter) {
                    program[program[index + 3]] = 1;
                } else {
                    program[program[index + 3]] = 0;
                }
            }
        } else {
            if (opcode == 1) {
                program[index + 3] = firstParameter + secondParameter;
            } else if (opcode == 2) {
                program[index + 3] = firstParameter * secondParameter;
            } else if (opcode == 7) {
                if (firstParameter < secondParameter) {
                    program[index + 3] = 1;
                } else {
                    program[index + 3] = 0;
                }
            } else if (opcode == 8) {
                if (firstParameter == secondParameter) {
                    program[index + 3] = 1;
                } else {
                    program[index + 3] = 0;
                }
            }
        }
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
