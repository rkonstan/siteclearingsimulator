package com.tdd.model;

import com.tdd.constants.SiteClearingConstants;
import com.tdd.util.SiteClearingUtils;

/**
 * Subclass that provides implementation to various steps to the Template Method.
 */
public class Crawler extends Bulldozer {

    private int movesForwardWidth = 0;
    private int movesForwardHeight = 0;
    private String orientation = SiteClearingConstants.EAST;
    private int count;


    @Override
    public void moveForward(String command) {
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
    public void turn(String command) {
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

    @Override
    public String position(int width, int height) {
        if (movesForwardWidth < 0 || movesForwardHeight < 0 ||
                movesForwardWidth >= width || movesForwardHeight >= height) {
            return SiteClearingConstants.DEFAULT_POSITION;
        }
        return String.format("%s,%s,%s", movesForwardWidth, movesForwardHeight, orientation);
    }

}
