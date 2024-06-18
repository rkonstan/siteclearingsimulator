package com.tdd.commands;

import com.tdd.receivers.Directional;

public class TurnCommand implements Command {

    private Directional direction;
    private String action;

    public TurnCommand(Directional direction, String action) {
        this.direction = direction;
        this.action = action;
    }

    @Override
    public void execute() {
        direction.turn(action);
    }
}
