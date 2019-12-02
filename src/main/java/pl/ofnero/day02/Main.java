package pl.ofnero.day02;

public class Main {
    public static void main(String[] args) {
        String file = "./inputs/day02input.txt";
        int[] tokens = PositionChanger.loadCode(file);
        
        tokens[1] = 12;
        tokens[2] = 2;
    
        //First stage
        PositionChanger.process(tokens);
        System.out.println(tokens[0]);
    
        // Second stage
        System.out.println(PairDeterminator.findVerbAndNoun(19690720, file));
    }
}
