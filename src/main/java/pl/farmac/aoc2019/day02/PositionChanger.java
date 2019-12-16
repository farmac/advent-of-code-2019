package pl.farmac.aoc2019.day02;

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
    
    public static int getValueFromIndexZero(int[] array, int noun, int verb) {
        array[1] = noun;
        array[2] = verb;
        process(array);
        return array[0];
    }
}
