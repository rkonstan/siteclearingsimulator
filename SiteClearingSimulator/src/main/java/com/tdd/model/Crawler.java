package com.tdd.model;

import com.tdd.constants.SiteClearingConstants;
import com.tdd.util.SiteClearingUtils;

public class Crawler extends Bulldozer {

    private int movesForwardWidth = 0;
    private int movesForwardHeight = 0;
    private String orientation = SiteClearingConstants.EAST;
    private int count;


    @Override
    public void forward(String command) {
        if (SiteClearingUtils.isActionCommand(command)) {
            switch (count) {
                case 0, 2:
                    movesForwardWidth += SiteClearingUtils.getNumberOfMovesFromCommand(command);
                    count++;
                    break;
                case 1, 3:
                    movesForwardHeight += SiteClearingUtils.getNumberOfMovesFromCommand(command);
                    count++;
                    break;
            }
        }
    }

    @Override
    public void turnLeft(String command) {
         orientation = SiteClearingConstants.NORTH;
    }

    @Override
    public void turnRight(String command) {
        orientation = SiteClearingConstants.EAST;
    }

    @Override
    public String position(int width, int height) {
        if (movesForwardWidth < 0 || movesForwardHeight < 0 ||
                movesForwardWidth >= width || movesForwardHeight >= height) {
            return SiteClearingConstants.DEFAULT_POSITION;
        }
        return String.format("%s,%s,%s", movesForwardWidth, movesForwardHeight, orientation);
    }

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
        // let oil lubricate all parts and cooling system to reach operational temperature
        return true;
    }

    @Override
    public void start(String command) {
        switch (command) {
            case String cmd -> {
                if (cmd.startsWith(SiteClearingConstants.ACTION)) {
                    forward(cmd);
                } else if (cmd.startsWith(SiteClearingConstants.LEFT)) {
                    turnLeft(cmd);
                } else if (cmd.startsWith(SiteClearingConstants.RIGHT)) {
                    turnRight(cmd);
                }
            }
        }
    }

}
