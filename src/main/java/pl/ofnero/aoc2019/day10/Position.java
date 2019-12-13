package pl.ofnero.aoc2019.day10;

public class Position implements Comparable<Position> {
    private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    
    //X(22,19)
    @Override
    public int compareTo(Position position) {
        return (int) (Math.sqrt(Math.pow(x - 22, 2) + Math.pow(y - 19, 2))
                - Math.sqrt(Math.pow(position.getX() - 22, 2) + Math.pow(position.getY() - 19, 2)));
    }
}
