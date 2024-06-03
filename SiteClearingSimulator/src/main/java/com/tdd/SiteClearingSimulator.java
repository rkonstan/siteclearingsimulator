package com.tdd;

import com.tdd.subjects.Bulldozer;

public class SiteClearingSimulator {
    private Bulldozer bulldozer;

    public SiteClearingSimulator(Bulldozer bulldozer) {
        this.bulldozer = bulldozer;
    }

    public void getBulldozerPosition(int width, int height, String command) {
        if (width <= 0 || height <= 0) {
            System.out.println("Site area cannot be zero or less.");
        }
        if (bulldozer.inspectMachine() && bulldozer.warmUpMachine()) {
            bulldozer.start(width, height, command);
        } else {
            System.out.println("Make sure pre-safety checks are completed!");
        }
    }
}

