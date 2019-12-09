package pl.ofnero.aoc2019.day03;

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
    
    public static int calculateStepsToTheClosestInterceptionPoint(Point point1, Point point2) {
        Set<Point> set = Calculator.getAllIntersectionPoints(point1, point2);
        System.out.println("First part: " + calculateDistance(set));
        Map<Point, Integer> firstPointMap = point1.getMap();
        Map<Point, Integer> secondPointMap = point2.getMap();
        
        return set.stream()
                .map(i -> firstPointMap.get(i) + secondPointMap.get(i))
                .min(Comparator.comparingInt(Integer::intValue))
                .orElse(0);
    }
    
}
