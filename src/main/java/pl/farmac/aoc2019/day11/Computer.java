package pl.farmac.aoc2019.day11;


public class Computer {
    private int instructionPointer = 0;
    private long[] program;
    
    
    public Computer(long[] code) {
        this.program = code;
    }
    
    public int[] process(int inputNumber) {
        int colorToPaint = 0;
        int direction;
        int counter = 0;
        
        int firstParameter = 0, secondParameter = 0, mode, position = 0, posForCodeThreeOrFour;
        
        while (true) {
            String instructions = String.format("%05d", program[instructionPointer]);
            int opcode = Integer.parseInt(instructions.substring(3));
            if (opcode == 99) {
                return null;
            }
            
            if (opcode != 3 && opcode != 4) {
                firstParameter = (int) (instructions.charAt(2) == '0' ? program[(int) program[instructionPointer + 1]] : program[instructionPointer + 1]);
                secondParameter = (int) (instructions.charAt(1) == '0' ? program[(int) program[instructionPointer + 2]] : program[instructionPointer + 2]);
                mode = instructions.charAt(0) == '0' ? 0 : 1;
                position = mode == 0 ? (int) program[instructionPointer + 3] : (instructionPointer + 3);
            }
            posForCodeThreeOrFour = instructions.charAt(2) != '1' ? (int) program[instructionPointer + 1] : (instructionPointer + 1);
            
            if (opcode == 1) {
                program[position] = firstParameter + secondParameter;
                instructionPointer += 4;
            } else if (opcode == 2) {
                program[position] = firstParameter * secondParameter;
                instructionPointer += 4;
            } else if (opcode == 3) {
                program[posForCodeThreeOrFour] = inputNumber;
                instructionPointer += 2;
            } else if (opcode == 4) {
                counter++;
                if (counter == 1) {
                    colorToPaint = (int) program[posForCodeThreeOrFour];
                } else if (counter == 2) {
                    direction = (int) program[posForCodeThreeOrFour];
                    instructionPointer += 2;
                    return new int[]{colorToPaint, direction};
                }
                instructionPointer += 2;
            } else if (opcode == 5) {
                instructionPointer = firstParameter != 0 ? secondParameter : (instructionPointer + 3);
            } else if (opcode == 6) {
                instructionPointer = firstParameter == 0 ? secondParameter : (instructionPointer + 3);
            } else if (opcode == 7) {
                program[position] = (firstParameter < secondParameter) ? 1 : 0;
                instructionPointer += 4;
            } else if (opcode == 8) {
                program[position] = (firstParameter == secondParameter) ? 1 : 0;
                instructionPointer += 4;
            }
        }
    }
}