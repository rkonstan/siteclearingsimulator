package com.tdd.commands;

import com.tdd.receivers.Directional;

// Concrete command for moving the bulldozer forward
public class MoveForwardCommand implements Command {

    // Reference to a receiver who knows how to perform the move.
    private Directional direction;
    private int width;
    private int height;
    private String action;

    // Binds the receiver to the command object to call actions on
    public MoveForwardCommand(Directional direction, int width, int height, String action) {
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.action = action;
    }

    @Override
    public void execute() {
        direction.moveForward(width, height, action);

    }
}
