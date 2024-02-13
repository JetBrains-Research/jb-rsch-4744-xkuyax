package org.jetbrains.assignment.model;

public record RobotMovement(
        RobotDirection direction,
        int steps
) {
}
