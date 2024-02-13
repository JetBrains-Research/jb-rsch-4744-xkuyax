package org.jetbrains.assignment.service;

import org.jetbrains.assignment.model.Location;
import org.jetbrains.assignment.model.RobotDirection;
import org.jetbrains.assignment.model.RobotMovement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotMovementService {

    public List<Location> storeMovements(List<RobotMovement> movements) {
        var positionX = 0;
        var positionY = 0;
        var locations = new ArrayList<>(List.of(new Location(positionX, positionY)));
        for (RobotMovement movement : movements) {
            positionX += movement.direction().getX() * movement.steps();
            positionY += movement.direction().getY() * movement.steps();
            locations.add(new Location(positionX, positionY));
        }
        return locations;
    }

    public List<RobotMovement> storeLocations(List<Location> locations) {
        if (locations.size() <= 1) {
            return new ArrayList<>();
        }
        var directions = new ArrayList<RobotMovement>();
        for (int i = 1; i < locations.size(); i++) {
            var previousLocation = locations.get(i - 1);
            var currentLocation = locations.get(i);
            var diffX = currentLocation.x() - previousLocation.x();
            var diffY = currentLocation.y() - previousLocation.y();
            var directionX = RobotDirection.fromXMovement(diffX);
            var directionY = RobotDirection.fromYMovement(diffY);
            var stepsX = Math.abs(diffX);
            var stepsY = Math.abs(diffY);
            if (directionX != null) {
                directions.add(new RobotMovement(directionX, stepsX));
            }
            if (directionY != null) {
                directions.add(new RobotMovement(directionY, stepsY));
            }
        }
        return directions;
    }
}
