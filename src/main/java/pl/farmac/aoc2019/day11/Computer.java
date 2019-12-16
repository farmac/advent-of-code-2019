package pl.farmac.aoc2019.day11;

public class Computer {
    private int ip = 0;
    private long[] program;
    private long relativeBase = 0;
    
    
    public Computer(long[] code) {
        this.program = code;
    }
    
    public int[] process(int inputNumber) {
        int colorToPaint = 0;
        int direction;
        int counter = 0;
        
        long firstParameter = 0;
        long secondParameter = 0;
        int mode;
        long position = 0;
        long posForCodeThreeOrFourAndNine = 0;
        
        while (true) {
            String instructions = String.format("%05d", program[ip]);
            int opcode = Integer.parseInt(instructions.substring(3));
            if (opcode == 99) {
                return null;
            }
            if (opcode != 3 && opcode != 4 && opcode != 9) {
                if (instructions.charAt(2) == '0') {
                    firstParameter = program[(int) program[ip + 1]];
                } else if (instructions.charAt(2) == '1') {
                    firstParameter = program[ip + 1];
                } else {
                    firstParameter = program[(int) (program[ip + 1] + relativeBase)];
                }
                
                
                if (instructions.charAt(1) == '0') {
                    secondParameter = program[(int) program[ip + 2]];
                } else if (instructions.charAt(1) == '1') {
                    secondParameter = program[ip + 2];
                } else {
                    secondParameter = program[(int) (program[ip + 2] + relativeBase)];
                }
                mode = instructions.charAt(0) == '0' ? 0 : instructions.charAt(0) == '1' ? 1 : 2;
                position = mode == 0 ? program[ip + 3] : mode == 1 ? (ip + 3) : (program[ip + 3] + relativeBase);
            } else {
                posForCodeThreeOrFourAndNine = instructions.charAt(2) == '0' ? program[ip + 1] :
                        instructions.charAt(2) == '1' ? (ip + 1) : (program[ip + 1] + relativeBase);
            }
            
            if (opcode == 1) {
                program[(int) position] = firstParameter + secondParameter;
                ip += 4;
            } else if (opcode == 2) {
                program[(int) position] = firstParameter * secondParameter;
                ip += 4;
            } else if (opcode == 3) {
                program[(int) posForCodeThreeOrFourAndNine] = inputNumber;
                ip += 2;
            } else if (opcode == 4) {
                counter++;
                if (counter == 1) {
                    colorToPaint = (int) program[(int) posForCodeThreeOrFourAndNine];
                } else if (counter == 2) {
                    direction = (int) program[(int) posForCodeThreeOrFourAndNine];
                    ip += 2;
                    return new int[]{colorToPaint, direction};
                }
                ip += 2;
            } else if (opcode == 5) {
                ip = firstParameter != 0 ? (int) secondParameter : (ip + 3);
            } else if (opcode == 6) {
                ip = (firstParameter == 0) ? (int) secondParameter : (ip + 3);
            } else if (opcode == 7) {
                program[(int) position] = (firstParameter < secondParameter) ? 1 : 0;
                ip += 4;
            } else if (opcode == 8) {
                program[(int) position] = (firstParameter == secondParameter) ? 1 : 0;
                ip += 4;
            } else if (opcode == 9) {
                relativeBase += program[(int) posForCodeThreeOrFourAndNine];
                ip += 2;
            }
        }
    }
}