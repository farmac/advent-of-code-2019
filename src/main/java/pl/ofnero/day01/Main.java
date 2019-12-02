package pl.ofnero.day01;

public class Main {
    public static void main(String[] args) {
        int totalRequiredFuel = FuelCalculator.parseData("./inputs/day01input.txt", 1);
        int totalRequiredFuel2 = FuelCalculator.parseData("./inputs/day01input.txt", 2);
        System.out.format("Required fuel in stage 1: %d%n", totalRequiredFuel);
        System.out.format("Required fuel in stage 2: %d", totalRequiredFuel2);
    }
}
