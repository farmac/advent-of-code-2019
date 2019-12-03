package pl.ofnero.day03;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point {
    private int x;
    private int y;
    private Set<Point> pointSet = new HashSet<>();
    private static final Pattern PATTERN = Pattern.compile("(\\w)(\\d+)");
    
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    public static void makeMoves(Point point, String[] moves) {
        for(String move: moves) {
            Matcher matcher = PATTERN.matcher(move);
            matcher.find();
            String direction = matcher.group(1);
            int distance = Integer.parseInt(matcher.group(2));
            
            switch (direction) {
                case "U":
                    point.moveUp(distance);
                    break;
                case "D":
                    point.moveDown(distance);
                    break;
                case "L":
                    point.moveLeft(distance);
                    break;
                case "R":
                    point.moveRight(distance);
                    break;
            }
            
        }
    }
    public Set<Point> getPointSet() {
        return pointSet;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    public void moveLeft(int distance) {
        for (int i = 0; i < distance; i++) {
            x -= 1;
            pointSet.add(new Point(x, y));
        }
    }
    
    public void moveRight(int distance) {
        for (int i = 0; i < distance; i++) {
            x += 1;
            pointSet.add(new Point(x, y));
        }
    }
    
    public void moveUp(int distance) {
        for (int i = 0; i < distance; i++) {
            y += 1;
            pointSet.add(new Point(x, y));
        }
    }
    
    public void moveDown(int distance) {
        for (int i = 0; i < distance; i++) {
            y -= 1;
            pointSet.add(new Point(x, y));
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
