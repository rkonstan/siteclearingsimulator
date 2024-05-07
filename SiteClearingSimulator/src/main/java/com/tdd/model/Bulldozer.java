package com.tdd.model;

public abstract class Bulldozer {
    public abstract void forward(String command);
    public abstract String turnLeft(String command);
    public abstract String turnRight(String command);
    public abstract String position(int width, int height);
    public abstract boolean inspectMachine();
    public abstract boolean warmUpMachine();
    public abstract void start(String command);
}
