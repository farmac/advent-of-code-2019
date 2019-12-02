package pl.ofnero.day02;

public class PairDeterminator {
    public static int findVerbAndNoun(int expectedOutput, String fileName) {
        int[] array = PositionChanger.loadCode(fileName);
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                int[] temp = array.clone();
                temp[1] = noun;
                temp[2] = verb;
                PositionChanger.process(temp);
                if (temp[0] == expectedOutput) {
                    return 100 * noun + verb;
                }
            }
        }
        return -1;
    }
}
