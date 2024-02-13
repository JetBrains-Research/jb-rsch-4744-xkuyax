package org.jetbrains.assignment.model;

public enum RobotDirection {

    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0),
    NORTH(0, 1);

    private final int x;
    private final int y;

    RobotDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static RobotDirection fromXMovement(int x){
        if(x >= 1){
            return RobotDirection.EAST;
        }
        if(x<=-1){
            return RobotDirection.WEST;
        }
        return null;
    }

    public static RobotDirection fromYMovement(int y){
        if(y >= 1){
            return RobotDirection.NORTH;
        }
        if(y<=-1){
            return RobotDirection.SOUTH;
        }
        return null;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
