package org.jetbrains.assignment.controller;

import org.jetbrains.assignment.model.Location;
import org.jetbrains.assignment.model.RobotDirection;
import org.jetbrains.assignment.model.RobotMovement;
import org.jetbrains.assignment.service.RobotMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovementController {

    private final RobotMovementService movementService;

    public MovementController(RobotMovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping("locations")
    public ResponseEntity<List<Location>> locations(@RequestBody List<RobotMovement> movements) {
        return ResponseEntity.ok(movementService.storeMovements(movements));
    }

    @PostMapping("moves")
    public ResponseEntity<List<RobotMovement>> moves(@RequestBody List<Location> locations){
        return ResponseEntity.ok(movementService.storeLocations(locations));
    }
}
