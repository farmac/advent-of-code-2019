package pl.farmac.aoc2019.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Collections2.permutations;

public class AmplifierController {
    private IntcodeComputerPartOne intcodeComputer;
    private List<IntcodeComputerPartTwo> intcodeComputerList;
    
    public AmplifierController(IntcodeComputerPartOne intcodeComputer, List<IntcodeComputerPartTwo> intcodeComputerList) {
        this.intcodeComputer = intcodeComputer;
        this.intcodeComputerList = intcodeComputerList;
    }
    
    public int calculateThrusterSignal(List<Integer> settingSequence) {
        intcodeComputer.process(settingSequence.get(0), 0);
        for (int i = 1; i < 5; i++) {
            intcodeComputer.process(settingSequence.get(i), intcodeComputer.getSignal());
        }
        return intcodeComputer.getSignal();
    }
    
    public int calculateMaximumThrusterSignal() {
        int max = 0;
        for (List<Integer> settingSequence : getPermutations()) {
            int signal = calculateThrusterSignal(settingSequence);
            if (signal > max) {
                max = signal;
            }
        }
        return max;
    }
    
    public int calculateThrusterSignalWithFeedbackLoop(List<Integer> settingSequence) {
        List<IntcodeComputerPartTwo> computers = new ArrayList<>();
        for(IntcodeComputerPartTwo comp: intcodeComputerList) {
            computers.add(new IntcodeComputerPartTwo(comp.getCode()));
        }
        IntcodeComputerPartTwo a = computers.get(0);
        IntcodeComputerPartTwo b = computers.get(1);
        IntcodeComputerPartTwo c = computers.get(2);
        IntcodeComputerPartTwo d = computers.get(3);
        IntcodeComputerPartTwo e = computers.get(4);
        
        while (!e.isDone()) {
            a.process(settingSequence.get(0), 0);
            b.setInput(a.getSignal());
            b.process(settingSequence.get(1), a.getSignal());
            c.setInput(b.getSignal());
            c.process(settingSequence.get(2), b.getSignal());
            d.setInput(c.getSignal());
            d.process(settingSequence.get(3), c.getSignal());
            e.setInput(d.getSignal());
            e.process(settingSequence.get(4), d.getSignal());
            a.setInput(e.getSignal());
        }
        
        return e.getSignal();
    }
    
    public int calculateMaximumThrusterSignalWithFeedbackLoop() {
        int max = 0;
        for (List<Integer> permutation : getPermutations2()) {
            int signal = calculateThrusterSignalWithFeedbackLoop(permutation);
            if (signal > max) {
                max = signal;
            }
        }
        return max;
    }
    
    private List<List<Integer>> getPermutations() {
        return new ArrayList<>(permutations(Arrays.asList(0, 1, 2, 3, 4)));
    }
    
    private List<List<Integer>> getPermutations2() {
        return new ArrayList<>(permutations(Arrays.asList(5, 6, 7, 8, 9)));
    }
}
