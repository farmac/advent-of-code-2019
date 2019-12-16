package pl.farmac.aoc2019.day09;

public class Computer {
    public static void process(long[] array, int input) {
        // Modes
        // 0 - position mode
        // 1 - immediate mode
        // 2 - relative mode
        int relativeBase = 0;
        long firstParameter = 0;
        long secondParameter = 0;
        int mode, position = 0, posForCodeThreeOrFourAndNine = 0;
        int i = 0;
        while (true) {
            String instructions = String.format("%05d", array[i]);
            int opcode = Integer.parseInt(instructions.substring(3));
            if (opcode == 99) {
                break;
            }
            
            if (opcode != 3 && opcode != 4 && opcode != 9) {
                firstParameter = instructions.charAt(2) == '0'
                        ? array[(int) array[i + 1]] : instructions.charAt(2) == '1'
                        ? array[i + 1] : array[(int) array[i + 1] + relativeBase];
                secondParameter = instructions.charAt(1) == '0'
                        ? array[(int) array[i + 2]] : instructions.charAt(1) == '1'
                        ? array[i + 2] : array[(int) array[i + 2] + relativeBase];
                mode = instructions.charAt(0) == '0' ? 0 : instructions.charAt(0) == '1' ? 1 : 2;
                position = mode == 0 ? (int) array[i + 3] : mode == 1 ? (i + 3) : (int) (array[i + 3] + relativeBase);
            } else {
                posForCodeThreeOrFourAndNine = instructions.charAt(2) == '0' ? (int) array[i + 1] :
                        instructions.charAt(2) == '1' ? (i + 1) : (int) (array[i + 1] + relativeBase);
            }
            if (opcode == 1) {
                array[position] = firstParameter + secondParameter;
                i += 4;
            } else if (opcode == 2) {
                array[position] = firstParameter * secondParameter;
                i += 4;
            } else if (opcode == 3) {
                array[posForCodeThreeOrFourAndNine] = input;
                i += 2;
            } else if (opcode == 4) {
                System.out.println(array[posForCodeThreeOrFourAndNine]);
                i += 2;
            } else if (opcode == 5) {
                i = firstParameter != 0 ? (int) secondParameter : (i + 3);
            } else if (opcode == 6) {
                i = firstParameter == 0 ? (int) secondParameter : (i + 3);
            } else if (opcode == 7) {
                array[position] = (firstParameter < secondParameter) ? 1 : 0;
                i += 4;
            } else if (opcode == 8) {
                array[position] = (firstParameter == secondParameter) ? 1 : 0;
                i += 4;
            } else if (opcode == 9) {
                relativeBase += array[posForCodeThreeOrFourAndNine];
                i += 2;
            }
        }
    }
}
