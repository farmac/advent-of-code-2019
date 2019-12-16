package pl.farmac.aoc2019.day03;

import java.util.*;

public class Calculator {
    private static int calculateDistance(Position point) {
        return Math.abs(point.getX()) + Math.abs(point.getY());
    }
    
    public static Set<Position> getAllIntersectionPoints(Position point1, Position point2) {
        Set<Position> set = point1.getPointSet();
        set.retainAll(point2.getPointSet());
        
        return set;
    }
    
    public static int calculateDistance(Set<Position> intersectionPoints) {
        return intersectionPoints.stream()
                .map(Calculator::calculateDistance)
                .min(Comparator.comparingInt(Integer::valueOf))
                .orElse(0);
    }
    
    public static int calculateStepsToTheClosestInterceptionPoint(Position point1, Position point2) {
        Set<Position> set = Calculator.getAllIntersectionPoints(point1, point2);
        System.out.println("First part: " + calculateDistance(set));
        Map<Position, Integer> firstPointMap = point1.getMap();
        Map<Position, Integer> secondPointMap = point2.getMap();
        
        return set.stream()
                .map(i -> firstPointMap.get(i) + secondPointMap.get(i))
                .min(Comparator.comparingInt(Integer::intValue))
                .orElse(0);
    }
    
}
