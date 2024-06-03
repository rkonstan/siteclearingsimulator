package com.tdd.observers;

import com.tdd.constants.SiteClearingConstants;
import com.tdd.subjects.Bulldozer;

public class Turn implements Observables, Positional {

    private String orientation = SiteClearingConstants.EAST;
    private Bulldozer bulldozer;

    public Turn(Bulldozer bulldozer) {
        this.bulldozer = bulldozer;
        bulldozer.registerObserver(this);
    }

    @Override
    public void update(int width, int height, String command) {
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
    public String position() {
        return orientation;
    }
}
