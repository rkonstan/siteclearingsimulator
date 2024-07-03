package com.tdd.model;

public abstract class Bulldozer {

    // Template method
    public final String bulldozerPosition(int width, int height, String command) {

        inspectMachine();
        warmUpMachine();
        moveForward(command);
        turn(command);

        return position(width, height);
    }

    // Subclasses to provide implementation of these steps
    public abstract void moveForward(String command);
    public abstract void turn(String command);
    public abstract String position(int width, int height);

    public boolean inspectMachine() {
        // Scan outside of machine for damaged parts
        // Check oil and hydraulic fluid leaks
        // Check all door and hood latches lock in place properly
        // Check levels of fuel, oil, engine coolant, transmission oil and hydraulic fluid
        return true;
    }
    public boolean warmUpMachine() {
        // let oil lubricate all parts and cooling system to reach operational temperature
        return true;
    }

}
