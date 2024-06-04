package com.tdd.subjects;

/**
 * Class for different types of bulldozers to inherit common functionality
 */
public abstract class Bulldozer implements Subject {

    public abstract boolean inspectMachine();
    public abstract boolean warmUpMachine();
    public abstract void start(int width, int height, String command);
}
