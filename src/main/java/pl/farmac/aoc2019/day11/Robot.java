package pl.farmac.aoc2019.day11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Robot {
    private Computer computer;
    private int[][] grid = new int[200][200];
    
    public Robot(long[] program) {
        computer = new Computer(program);
    }
    
    private static class Location {
        private int x;
        private int y;
        
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x &&
                    y == location.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int countPaintedPanels() {
        Set<Location> locations = new HashSet<>();
        paintGrid(locations);
        return locations.size();
    }
    
    private void paintGrid(Set<Location> locations) {
        int[] temp;
        int x = 100;
        int y = 100;
        int direction = 3;
        // 1 - facing left
        // 2 - facing down
        // 3 - facing up
        // 4 - facing right
        while (true) {
            int input = grid[x][y] == 0 ? 0 : 1;
            temp = computer.process(input);
            if(temp == null) {
                break;
            }
            locations.add(new Location(x, y));
            grid[x][y] = temp[0];
            direction = getNextDirection(direction, temp[1]);
            if (direction == 1) {
                y -= 1;
            } else if (direction == 2) {
                x += 1;
            } else if (direction == 3) {
                x -= 1;
            } else if (direction == 4) {
                y += 1;
            }
        }
    }
    
    private int getNextDirection(int initialDirection, int directionRobotShouldTurn) {
        int nextDirection;
        if (initialDirection == 1) {
            nextDirection = directionRobotShouldTurn == 0 ? 2 : 3;
        } else if (initialDirection == 2) {
            nextDirection = directionRobotShouldTurn == 0 ? 4 : 1;
        } else if (initialDirection == 3) {
            nextDirection = directionRobotShouldTurn == 0 ? 1 : 4;
        } else {
            nextDirection = directionRobotShouldTurn == 0 ? 3 : 2;
        }
        
        return nextDirection;
    }
    
}
