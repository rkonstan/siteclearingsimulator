package com.tdd.strategies;

import com.tdd.util.SiteClearingUtils;

public class MoveForward implements Directional, Positional {

    private int movesForwardWidth = 0;
    private int movesForwardHeight = 0;
    private static Integer count = 0;

    @Override
    public String direction(int width, int height, String command) {
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
        checkCommandsAreValid(width, height);
        return position();
    }

    private  void checkCommandsAreValid(int width, int height) {
        if (movesForwardWidth < 0 || movesForwardHeight < 0 ||
                movesForwardWidth >= width || movesForwardHeight >= height) {
            movesForwardWidth = 0;
            movesForwardHeight = 0;
        }
    }

    @Override
    public String position() {
        return String.format("%s,%s",movesForwardWidth, movesForwardHeight);
    }
}
