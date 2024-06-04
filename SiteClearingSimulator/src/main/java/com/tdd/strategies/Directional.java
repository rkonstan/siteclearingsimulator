package com.tdd.strategies;

/**
 * Interface for specific behaviour that can vary.
 */
public interface Directional {
    String direction(int height, int width, String command);
}
