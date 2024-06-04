package com.tdd.observers;

import com.tdd.constants.SiteClearingConstants;
import com.tdd.subjects.Bulldozer;
import com.tdd.util.SiteClearingUtils;

/**
 * A concrete Observer - gets updates from the Subject (Bulldozer)
 */
public class Direction implements Observables, Positional {

    private int movesForwardWidth = 0;
    private int movesForwardHeight = 0;
    private static Integer count = 0;
    private Bulldozer bulldozer;
    private String orientation = SiteClearingConstants.EAST;

    public Direction(Bulldozer bulldozer) {
        this.bulldozer = bulldozer;
        bulldozer.registerObserver(this);
    }

    @Override
    public void update(int width, int height, String command) {
        moveForward(command);
        turn(command);
        checkCommandsAreValid(width, height);
    }

    private void moveForward(String command) {
        if (SiteClearingUtils.isActionCommand(command)) {
            switch (count) {
                case Integer x -> {
                    if (x % 2 == 0) {
                        movesForwardWidth += SiteClearingUtils.getNumberOfMovesFromCommand(command);
                    } else {
                        movesForwardHeight += SiteClearingUtils.getNumberOfMovesFromCommand(command);
                    }
                    count++;
                }
            }
        }
    }

    private void turn(String command) {
        switch (command) {
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
