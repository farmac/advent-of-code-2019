package pl.ofnero.day01;

public class Main {
    public static void main(String[] args) {
        int totalRequiredFuel = FuelCalculator.parseData("day01input.txt");
        System.out.println(totalRequiredFuel);
    }
}
