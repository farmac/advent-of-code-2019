package pl.ofnero.day03;

import java.util.*;

public class Calculator {
    
    
    private static int calculateDistance(Point point) {
        return Math.abs(point.getX()) + Math.abs(point.getY());
    }
    
    public static Set<Point> getAllIntersectionPoints(Point point1, Point point2) {
        Set<Point> set = point1.getPointSet();
        set.retainAll(point2.getPointSet());
        return set;
        
    }
    
    public static int calculateDistance(Set<Point> intersectionPoints) {
        return intersectionPoints.stream()
                .map(Calculator::calculateDistance)
                .min(Comparator.comparingInt(Integer::valueOf))
                .orElse(0);
    }
}
