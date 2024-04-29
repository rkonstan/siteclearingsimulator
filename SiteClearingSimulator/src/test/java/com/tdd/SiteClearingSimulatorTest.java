package com.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SiteClearingSimulatorTest {

    private SiteClearingSimulator siteClearingSimulator = new SiteClearingSimulator();

    @Test
    public void bulldozerPositionShouldBe_0_0_E() {
        siteClearingSimulator.getBulldozerPosition(6,6,"A0");
        siteClearingSimulator.getBulldozerPosition(6,6,"");
        assertEquals("0,0,E", siteClearingSimulator.getBulldozerPosition(6,6,"A0"));
    }

    @Test
    public void bulldozerPositionShouldBe_2_1_N() {
        siteClearingSimulator.getBulldozerPosition(6,6,"A2");
        siteClearingSimulator.getBulldozerPosition(6,6,"L");
        assertEquals("2,1,N", siteClearingSimulator.getBulldozerPosition(6,6,"A1"));
    }

    @Test
    public void bulldozerPositionShouldBe_0_0_E_whenGivenNegativeNumber() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A-3");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        assertEquals("0,0,E", siteClearingSimulator.getBulldozerPosition(6,6, "A-1"));
    }
    @Test
    public void bulldozerPositionShouldBe_0_0_E_whenGivenNumberLargerThanSiteArea() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A6");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        assertEquals("0,0,E", siteClearingSimulator.getBulldozerPosition(6,6, "A8"));
    }

    @Test
    public void bulldozerPositionShouldBe_4_3_E() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A4");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A3");
        assertEquals("4,3,E", siteClearingSimulator.getBulldozerPosition(6,6, "R"));
    }
}
