package pl.ofnero.day03;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point {
    private int x;
    private int y;
    private Set<Point> pointSet = new LinkedHashSet<>();
    private Map<Point, Integer> map = new HashMap<>();
    private Integer steps = 0;
    private final Pattern PATTERN = Pattern.compile("(\\w)(\\d+)");
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Map<Point, Integer> getMap() {
        return map;
    }
    
    public Set<Point> getPointSet() {
        return pointSet;
    }
    
    public void makeMoves(String[] moves) {
        for (String move : moves) {
            Matcher matcher = PATTERN.matcher(move);
            //noinspection ResultOfMethodCallIgnored
            matcher.find();
            String direction = matcher.group(1);
            int distance = Integer.parseInt(matcher.group(2));
            
            switch (direction) {
                case "U":
                    for (int i = 0; i < distance; i++) {
                        y += 1;
                        putPointsToCollection(new Point(x, y));
                    }
                    break;
                case "D":
                    for (int i = 0; i < distance; i++) {
                        y -= 1;
                        putPointsToCollection(new Point(x, y));
                    }
                    break;
                case "L":
                    for (int i = 0; i < distance; i++) {
                        x -= 1;
                        putPointsToCollection(new Point(x, y));
                    }
                    break;
                case "R":
                    for (int i = 0; i < distance; i++) {
                        x += 1;
                        putPointsToCollection(new Point(x, y));
                    }
                    break;
            }
        }
    }
    
    private void putPointsToCollection(Point p) {
        steps++;
        pointSet.add(p);
        if (!map.containsKey(p)) {
            map.put(p, steps);
        }
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
    
    public String toString() {
        return String.format("%d:%d", x, y);
    }
}
