package com.tdd;

import com.tdd.commands.Command;
import com.tdd.commands.MoveForwardCommand;
import com.tdd.commands.TurnCommand;
import com.tdd.receivers.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SiteClearingSimulatorTest {

    // Create receivers
    Direction direction = new Direction();

    // Create invoker
    Bulldozer bulldozer = new Crawler();

    // Inject the bulldozer into the simulator
    SiteClearingSimulator siteClearingSimulator = new SiteClearingSimulator(bulldozer);

    @Test
    void bulldozerPositionShouldBe_0_0_E_inStartingPosition() {
        // Create command objects
        Command noMoveForwardEntered = new MoveForwardCommand(direction, 6, 6, "A0");
        Command noTurnDirectionEntered = new TurnCommand(direction, "");
        Command noMoveForwardEnteredAgain = new MoveForwardCommand(direction, 6, 6, "A0");

        // Set and execute commands
        bulldozer.enterCommands(noMoveForwardEntered);
        bulldozer.enterCommands(noTurnDirectionEntered);
        bulldozer.enterCommands(noMoveForwardEnteredAgain);
        bulldozer.executeCommands();

        assertEquals("0,0,E", direction.position());
    }

    @Test
    void bulldozerPositionShouldBe_0_0_E_whenSiteAreaNotGiven() {
        Command siteAreaNotGiven = new MoveForwardCommand(direction, 0, 0, "A0");
        bulldozer.enterCommands(siteAreaNotGiven);
        bulldozer.executeCommands();

        assertEquals("0,0,E", direction.position());
    }

    @Test
    void bulldozerPositionShouldBe_2_1_N() {
        // Create commands
        Command moveForwardTwoSpots = new MoveForwardCommand(direction, 6, 6, "A2");
        Command turnLeft = new TurnCommand(direction, "L");
        Command moveForwardOneSpot = new MoveForwardCommand(direction, 6, 6, "A1");

        // Set and execute commands
        bulldozer.enterCommands(moveForwardTwoSpots);
        bulldozer.enterCommands(turnLeft);
        bulldozer.enterCommands(moveForwardOneSpot);
        bulldozer.executeCommands();

        assertEquals("2,1,N", direction.position());
    }

    @Test
    void bulldozerPositionShouldBe_0_0_E_whenGivenNegativeNumber() {
        // Create commands
        Command moveBackwardsThreeSpots = new MoveForwardCommand(direction, 6, 6, "A-3");
        Command turnLeft = new TurnCommand(direction, "L");
        Command moveBackwardsOneSpot = new MoveForwardCommand(direction, 6, 6, "A-1");

        // Set and execute commands
        bulldozer.enterCommands(moveBackwardsThreeSpots);
        bulldozer.enterCommands(turnLeft);
        bulldozer.enterCommands(moveBackwardsOneSpot);
        bulldozer.executeCommands();

        assertEquals("0,0,E", direction.position());
    }

    @Test
    void bulldozerPositionShouldBe_0_0_E_whenGivenNumberLargerThanSiteArea() {
        // Create commands
        Command moveForwardSixSpots = new MoveForwardCommand(direction, 6, 6, "A6");
        Command turnLeft = new TurnCommand(direction, "L");
        Command moveForwardEightSpots = new MoveForwardCommand(direction, 6, 6, "A8");

        // Set and execute commands
        bulldozer.enterCommands(moveForwardSixSpots);
        bulldozer.enterCommands(turnLeft);
        bulldozer.enterCommands(moveForwardEightSpots);
        bulldozer.executeCommands();

        assertEquals("0,0,E", direction.position());
    }

    @Test
    void bulldozerPositionShouldBe_5_5_N() {
        // Create commands
        Command moveForwardFourSpots = new MoveForwardCommand(direction, 6, 6, "A4");
        Command turnLeft = new TurnCommand(direction, "L");
        Command moveForwardThreeSpots = new MoveForwardCommand(direction, 6, 6, "A3");
        Command turnRight = new TurnCommand(direction, "R");
        Command moveForwardOneSpot = new MoveForwardCommand(direction, 6, 6, "A1");
        Command turnLeftAgain = new TurnCommand(direction, "L");
        Command moveForwardTwoSpots = new MoveForwardCommand(direction, 6, 6, "A2");

        // Set and execute commands
        bulldozer.enterCommands(moveForwardFourSpots);
        bulldozer.enterCommands(turnLeft);
        bulldozer.enterCommands(moveForwardThreeSpots);
        bulldozer.enterCommands(turnRight);
        bulldozer.enterCommands(moveForwardOneSpot);
        bulldozer.enterCommands(turnLeftAgain);
        bulldozer.enterCommands(moveForwardTwoSpots);
        bulldozer.executeCommands();

        assertEquals("5,5,N", direction.position());
    }

    @Test
    void bulldozerPositionShouldBe_3_5_N() {
        // Create commands
        Command moveForwardTwoSpots = new MoveForwardCommand(direction, 6, 6, "A2");
        Command turnLeft = new TurnCommand(direction, "L");
        Command moveForwardTwoSpotsAgain = new MoveForwardCommand(direction, 6, 6, "A2");
        Command turnRight = new TurnCommand(direction, "R");
        Command moveForwardOneSpot = new MoveForwardCommand(direction, 6, 6, "A1");
        Command turnLeftAgain = new TurnCommand(direction, "L");
        Command moveForwardThreeSpots = new MoveForwardCommand(direction, 6, 6, "A3");

        // Set and execute commands
        bulldozer.enterCommands(moveForwardTwoSpots);
        bulldozer.enterCommands(turnLeft);
        bulldozer.enterCommands(moveForwardTwoSpotsAgain);
        bulldozer.enterCommands(turnRight);
        bulldozer.enterCommands(moveForwardOneSpot);
        bulldozer.enterCommands(turnLeftAgain);
        bulldozer.enterCommands(moveForwardThreeSpots);
        bulldozer.executeCommands();

        assertEquals("3,5,N", direction.position());

    }
}
