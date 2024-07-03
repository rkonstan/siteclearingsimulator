package com.tdd;

import com.tdd.model.Bulldozer;

public class SiteClearingSimulator {
    private Bulldozer bulldozer;

    public SiteClearingSimulator(Bulldozer bulldozer) {
        this.bulldozer = bulldozer;
    }

    public String getBulldozerPosition(int width, int height, String command) {

        return bulldozer.bulldozerPosition(width, height, command);

    }

}

