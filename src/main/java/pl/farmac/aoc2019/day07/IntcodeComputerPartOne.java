package pl.farmac.aoc2019.day07;

public class IntcodeComputerPartOne {
    private int[] code;
    private int signal;
    private int input = 0;
    
    public IntcodeComputerPartOne(int[] code) {
        this.code = code;
    }
    
    public void setInput(int input) {
        this.input = input;
    }
    
    public int getSignal() {
        return signal;
    }
    
    public void setSignal(int signal) {
        this.signal = signal;
    }
    
    public void process(int phaseSetting, int inputNumber) {
        int instructionPointer = 0;
        int inputCount = 0;
        // Modes
        // 0 - position mode
        // 1 - immediate mode
        int firstParameter = 0, secondParameter = 0, mode, position = 0, posForCodeThreeOrFour;
        
        while (true) {
            String instructions = String.format("%05d", code[instructionPointer]);
            int opcode = Integer.parseInt(instructions.substring(3));
            if (opcode == 99) {
                break;
            }
            
            if (opcode != 3 && opcode != 4) {
                firstParameter = instructions.charAt(2) == '0' ? code[code[instructionPointer + 1]] : code[instructionPointer + 1];
                secondParameter = instructions.charAt(1) == '0' ? code[code[instructionPointer + 2]] : code[instructionPointer + 2];
                mode = instructions.charAt(0) == '0' ? 0 : 1;
                position = mode == 0 ? code[instructionPointer + 3] : (instructionPointer + 3);
            }
            posForCodeThreeOrFour = instructions.charAt(2) != '1' ? code[instructionPointer + 1] : (instructionPointer + 1);
            
            if (opcode == 1) {
                code[position] = firstParameter + secondParameter;
                instructionPointer += 4;
            } else if (opcode == 2) {
                code[position] = firstParameter * secondParameter;
                instructionPointer += 4;
            } else if (opcode == 3) {
                code[posForCodeThreeOrFour] = inputCount == 0 ? phaseSetting : inputCount == 1 ? inputNumber : input;
                instructionPointer += 2;
                inputCount++;
            } else if (opcode == 4) {
                this.setSignal(code[posForCodeThreeOrFour]);
                instructionPointer += 2;
            } else if (opcode == 5) {
                instructionPointer = firstParameter != 0 ? secondParameter : (instructionPointer + 3);
            } else if (opcode == 6) {
                instructionPointer = firstParameter == 0 ? secondParameter : (instructionPointer + 3);
            } else if (opcode == 7) {
                code[position] = (firstParameter < secondParameter) ? 1 : 0;
                instructionPointer += 4;
            } else if (opcode == 8) {
                code[position] = (firstParameter == secondParameter) ? 1 : 0;
                instructionPointer += 4;
            }
        }
    }
}
