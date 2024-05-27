package com.tdd.model;

import com.tdd.constants.SiteClearingConstants;
import com.tdd.strategies.MoveForward;
import com.tdd.strategies.Turn;
import com.tdd.util.SiteClearingUtils;

public class Crawler extends Bulldozer {

    private String movesForward;
    private String orientation = SiteClearingConstants.EAST;

    @Override
    public boolean inspectMachine() {
        // Scan outside of machine for damaged parts
        // Check oil and hydraulic fluid leaks
        // Check all door and hood latches lock in place properly
        // Check levels of fuel, oil, engine coolant, transmission oil and hydraulic fluid
        return true;
    }

    @Override
    public boolean warmUpMachine() {
        // let oil lubricate all parts and let cooling system reach operational temperature
        return true;
    }

    @Override
    public String start(int width, int height, String command) {
        switch (command) {
            case String cmd -> {
                if (SiteClearingUtils.isActionCommand(cmd)) {
                    if (isDirectionalNull()) {
                        directional = new MoveForward();
                    }
                    movesForward = directional.direction(width, height, cmd);
                } else if (SiteClearingUtils.isTurningCommand(cmd)) {
                    if (movesForward.equals("0,0")) {
                        return orientation;
                    }
                    turnable = new Turn();
                    orientation = turnable.turn(cmd);
                }
            }
        }
        return String.format("%s,%s", movesForward, orientation);
    }

    private boolean isDirectionalNull() {
        if (directional == null) {
            return true;
        }
        return false;
    }

}
