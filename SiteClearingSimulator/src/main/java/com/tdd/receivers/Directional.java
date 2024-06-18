package com.tdd.receivers;

// Receiver interface for concrete receivers to implement
public interface Directional {
    void moveForward(int width, int height, String action);
    void turn(String action);
}
