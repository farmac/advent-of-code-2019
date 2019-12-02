package pl.ofnero.day02;

public class PairDeterminator {
    public static int findVerbAndNoun(int expectedOutput, String fileName) {
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                int[] array = PositionChanger.loadCode(fileName);
                array[1] = noun;
                array[2] = verb;
                PositionChanger.process(array);
                if (array[0] == expectedOutput) {
                    return 100 * noun + verb;
                }
            }
        }
        return -1;
    }
}
