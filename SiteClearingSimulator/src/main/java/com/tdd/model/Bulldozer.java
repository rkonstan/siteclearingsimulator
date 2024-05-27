package com.tdd.model;

import com.tdd.strategies.Directional;
import com.tdd.strategies.Turnable;

public abstract class Bulldozer {

    Directional directional;
    Turnable turnable;

    public void setDirectional(Directional directional) {
        this.directional = directional;
    }

    public void setTurnable(Turnable turnable) {
        this.turnable = turnable;
    }

    public abstract boolean inspectMachine();
    public abstract boolean warmUpMachine();
    public abstract String start(int width, int height, String command);
}
