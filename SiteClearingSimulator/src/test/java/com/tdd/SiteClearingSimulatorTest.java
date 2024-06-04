package com.tdd;

import com.tdd.observers.Direction;
import com.tdd.subjects.Bulldozer;
import com.tdd.subjects.Crawler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SiteClearingSimulatorTest {

    private Bulldozer bulldozer = new Crawler();
    Direction direction = new Direction(bulldozer);
    SiteClearingSimulator siteClearingSimulator = new SiteClearingSimulator(bulldozer);

    @Test
    public void bulldozerPositionShouldBe_0_0_E_inStartingPosition() {
        siteClearingSimulator.getBulldozerPosition(6,6,"A0");
        siteClearingSimulator.getBulldozerPosition(6,6,"");
        siteClearingSimulator.getBulldozerPosition(6,6,"A0");
        assertEquals("0,0,E", direction.position());
    }

    @Test
    public void bulldozerPositionShouldBe_0_0_E_whenSiteAreaNotGiven() {
        siteClearingSimulator.getBulldozerPosition(0,0,"A0");
        assertEquals("0,0,E", direction.position());
    }

    @Test
    public void bulldozerPositionShouldBe_2_1_N() {
        siteClearingSimulator.getBulldozerPosition(6,6,"A2");
        siteClearingSimulator.getBulldozerPosition(6,6,"L");
        siteClearingSimulator.getBulldozerPosition(6,6,"A1");
        assertEquals("2,1,N", direction.position());
    }

    @Test
    public void bulldozerPositionShouldBe_0_0_E_whenGivenNegativeNumber() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A-3");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A-1");
        assertEquals("0,0,E", direction.position());
    }
    @Test
    public void bulldozerPositionShouldBe_0_0_E_whenGivenNumberLargerThanSiteArea() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A6");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A8");
        assertEquals("0,0,E", direction.position());
    }

    @Test
    public void bulldozerPositionShouldBe_5_5_N() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A4");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A3");
        siteClearingSimulator.getBulldozerPosition(6,6, "R");
        siteClearingSimulator.getBulldozerPosition(6,6, "A1");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A2");
        assertEquals("5,5,N", direction.position());
    }

    @Test
    public void bulldozerPositionShouldBe_3_5_N() {
        siteClearingSimulator.getBulldozerPosition(6,6, "A2");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A2");
        siteClearingSimulator.getBulldozerPosition(6,6, "R");
        siteClearingSimulator.getBulldozerPosition(6,6, "A1");
        siteClearingSimulator.getBulldozerPosition(6,6, "L");
        siteClearingSimulator.getBulldozerPosition(6,6, "A3");
        assertEquals("3,5,N", direction.position());
    }
}
