package com.tdd.strategies;

import com.tdd.constants.SiteClearingConstants;
/**
 * A class that encapsulates a behaviour of a bulldozer
 */
public class Turn implements Turnable {

    private String orientation;
    @Override
    public String turn(String command) {
        switch (command) {
            case String cmd -> {
                 if (cmd.startsWith(SiteClearingConstants.LEFT)) {
                     orientation = SiteClearingConstants.NORTH;
                }  if (cmd.startsWith(SiteClearingConstants.RIGHT)) {
                    orientation = SiteClearingConstants.EAST;
                }
            }
        }
        return orientation;
    }
}
