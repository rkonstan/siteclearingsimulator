package com.tdd.receivers;

import com.tdd.constants.SiteClearingConstants;
import com.tdd.util.SiteClearingUtils;

// Receiver - knows how to implement the action
public class Direction implements Directional, Positional {

    private int movesForwardWidth = 0;
    private int movesForwardHeight = 0;
    private static Integer count = 0;
    private String orientation = SiteClearingConstants.EAST;

    @Override
    public void moveForward(int width, int height, String action) {
        if (SiteClearingUtils.isActionCommand(action)) {
            switch (count) {
                case Integer x -> {
                    if (x % 2 == 0) {
                        movesForwardWidth += SiteClearingUtils.getNumberOfMovesFromCommand(action);
                    } else {
                        movesForwardHeight += SiteClearingUtils.getNumberOfMovesFromCommand(action);
                    }
                    count++;
                }
            }
        }
        checkCommandsAreValid(width, height);
    }

    @Override
    public void turn(String action) {
        switch (action) {
            case String cmd -> {
                if (cmd.startsWith(SiteClearingConstants.LEFT)) {
                    orientation = SiteClearingConstants.NORTH;
                } else if (cmd.startsWith(SiteClearingConstants.RIGHT)) {
                    orientation = SiteClearingConstants.EAST;
                }
            }
        }
    }

    private void checkCommandsAreValid(int width, int height) {
        if (movesForwardWidth < 0 || movesForwardHeight < 0 ||
                movesForwardWidth >= width || movesForwardHeight >= height) {
            movesForwardWidth = 0;
            movesForwardHeight = 0;
            orientation = SiteClearingConstants.EAST;
        }
    }

    @Override
    public String position() {
        return String.format("%s,%s,%s", movesForwardWidth, movesForwardHeight, orientation);
    }
}
