package org.jetbrains.assignment.service;

import org.jetbrains.assignment.model.Location;
import org.jetbrains.assignment.model.RobotMovement;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RobotMovementService {

    public List<Location> storeMovements(List<RobotMovement> movements) {

        return List.of(new Location(0, 1));
    }
}
