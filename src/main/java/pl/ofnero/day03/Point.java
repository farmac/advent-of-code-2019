package pl.ofnero.day03;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Point {
    private int x;
    private int y;
    private Set<Point> pointSet = new HashSet<>();
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
