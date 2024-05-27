package com.tdd;

import com.tdd.constants.SiteClearingConstants;
import com.tdd.model.Bulldozer;

public class SiteClearingSimulator {
    private Bulldozer bulldozer;

    public SiteClearingSimulator(Bulldozer bulldozer) {
        this.bulldozer = bulldozer;
    }

    public String getBulldozerPosition(int width, int height, String command) {
        if (width <= 0 || height <= 0) {
            return SiteClearingConstants.DEFAULT_POSITION;
        }
        if (bulldozer.inspectMachine() && bulldozer.warmUpMachine()) {
            return bulldozer.start(width, height, command);
        }
        return "Make sure pre-safety checks are completed!";
    }

}

