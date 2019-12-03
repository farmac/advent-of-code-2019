package pl.ofnero.day03;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mover {
    private static final Pattern PATTERN = Pattern.compile("(\\w)(\\d+)");
    
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
                .map(Mover::calculateDistance)
                .min(Comparator.comparingInt(Integer::valueOf))
                .orElse(0);
    }
}
