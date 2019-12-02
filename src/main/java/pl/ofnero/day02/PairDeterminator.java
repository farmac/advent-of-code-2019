package pl.ofnero.day02;

public class PairDeterminator {
    public static int getVerbAndNoun(int expectedOutput, int[] array) {
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                int[] temp = array.clone();
                if(PositionChanger.getValueFromIndexZero(temp, noun, verb) == expectedOutput) {
                    return 100 * noun + verb;
                }
            }
        }
        return -1;
    }
}
