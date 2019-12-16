package pl.farmac.aoc2019.day05;

public class IntcodeComputer {
    public static void process(int[] array, int input) {
        // Modes
        // 0 - position mode
        // 1 - immediate mode
        int firstParameter = 0, secondParameter = 0, mode, position = 0, posForCodeThreeOrFour;
        int i = 0;
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
                array[posForCodeThreeOrFour] = input;
                i += 2;
            } else if (opcode == 4) {
                System.out.println(array[posForCodeThreeOrFour]);
                i += 2;
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
    }
}
