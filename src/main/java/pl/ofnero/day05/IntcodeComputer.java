package pl.ofnero.day05;

public class IntcodeComputer {
    public static void process(int[] array, int input) {
        int i = 0;
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
                    if (instructions.charAt(2) != '1') {
                        array[array[i + 1]] = input;
                    } else {
                        array[i + 1] = input;
                    }
                    i += 2;
                    break;
                case 4:
                    if (instructions.charAt(2) != '1') {
                        System.out.println(array[array[i + 1]]);
                    } else {
                        System.out.println(array[i + 1]);
                    }
                    i += 2;
                    break;
                    
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
}
