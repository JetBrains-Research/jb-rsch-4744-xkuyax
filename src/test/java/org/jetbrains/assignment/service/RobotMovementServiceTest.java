package org.jetbrains.assignment.service;

import org.jetbrains.assignment.model.Location;
import org.jetbrains.assignment.model.RobotDirection;
import org.jetbrains.assignment.model.RobotMovement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class RobotMovementServiceTest {

    private RobotMovementService service = new RobotMovementService();

    @Test
    public void shouldReturnPositionsForGivenDirections() {
        var movementList = List.of(
                new RobotMovement(RobotDirection.EAST, 1),
                new RobotMovement(RobotDirection.NORTH, 3),
                new RobotMovement(RobotDirection.EAST, 3),
                new RobotMovement(RobotDirection.SOUTH, 5),
                new RobotMovement(RobotDirection.WEST, 2)
        );
        var result = service.storeMovements(movementList);
        assertThat(result)
                .containsExactly(
                        new Location(0, 0),
                        new Location(1, 0),
                        new Location(1, 3),
                        new Location(4, 3),
                        new Location(4, -2),
                        new Location(2, -2)
                );
    }

    @Test
    void shouldReturnDirectionsForGivenLocations() {
        var locations = List.of(new Location(0, 0),
                new Location(1, 0),
                new Location(1, 3),
                new Location(4, 3),
                new Location(4, -2),
                new Location(2, -2));
        var robotMovements = service.storeLocations(locations);
        assertThat(robotMovements)
                .containsExactly(new RobotMovement(RobotDirection.EAST, 1),
                        new RobotMovement(RobotDirection.NORTH, 3),
                        new RobotMovement(RobotDirection.EAST, 3),
                        new RobotMovement(RobotDirection.SOUTH, 5),
                        new RobotMovement(RobotDirection.WEST, 2));
    }
}