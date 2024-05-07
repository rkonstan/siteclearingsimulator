package com.tdd;

import com.tdd.model.Bulldozer;
import com.tdd.model.Crawler;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SiteClearingSimulatorTest {

    private Bulldozer bulldozer = new Crawler();
    SiteClearingSimulator siteClearingSimulator = new SiteClearingSimulator(bulldozer);

    @Test
    public void bulldozerPositionShouldBe_0_0_E_inStartingPosition() {
        siteClearingSimulator.getBulldozerPosition(6,6,"A0");
        siteClearingSimulator.getBulldozerPosition(6,6,"");
        Assert.assertEquals("0,0,E", siteClearingSimulator.getBulldozerPosition(6,6,"A0"));
    }

    @Test
    public void bulldozerPositionShouldBe_0_0_E_whenSiteAreaNotGiven() {
        Assert.assertEquals("0,0,E",
                siteClearingSimulator.getBulldozerPosition(0,0,"A0"));
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
    public void bulldozerPositionShouldBe_5_5_N() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A4");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A3");
        siteClearingSimulator.getBulldozerPosition(6,6, "R");
        siteClearingSimulator.getBulldozerPosition(6,6, "A1");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        assertEquals("5,5,N", siteClearingSimulator.getBulldozerPosition(6,6, "A2"));
    }

    @Test
    public void bulldozerPositionShouldBe_3_5_N() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A2");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A2");
        siteClearingSimulator.getBulldozerPosition(6,6, "R");
        siteClearingSimulator.getBulldozerPosition(6,6, "A1");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        assertEquals("3,5,N", siteClearingSimulator.getBulldozerPosition(6,6, "A3"));
    }
}
