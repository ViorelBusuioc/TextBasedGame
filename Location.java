package dev.lpa;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private String description;
    private Map<String, String> nextMoves;

    public Location(String description) {
        this.description = description;
        this.nextMoves = new HashMap<>();
    }

    public void addNextMove(String direction, String nextLocation) {
        nextMoves.put(direction.toUpperCase(), nextLocation);
    }

    public String getNextLocation(String direction) {
        return nextMoves.get(direction.toUpperCase());
    }

    @Override
    public String toString() {
        return description;
    }
}
