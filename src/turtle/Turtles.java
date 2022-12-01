package turtle;

//import tddClass.turtle.Direction;

//import static com.Chapter7.Turtle.TurtlePackage.Direction.*;
//import static tddClass.turtle.Direction.*;

import static turtle.Direction.*;

public class Turtles {
    private Direction currentDirection = EAST;
    private TurtlePosition currentPosition = new TurtlePosition(0, 0);
    private boolean penIsUp;

    public void penUp() {
        penIsUp = true;
    }

    public boolean isPenUp() {
        return penIsUp;
    }

    public void penDown() {
        penIsUp = false;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void turnRight() {
        if(currentDirection == EAST) face(SOUTH);
        else if(currentDirection == SOUTH) face(WEST);
        else if(currentDirection == WEST) face(NORTH);
        else if(currentDirection == NORTH) face(EAST);
    }

    private void face(Direction newDirection) {
        currentDirection = newDirection;
    }

    public void turnLeft() {
        if(currentDirection == EAST) face(NORTH);
        else if(currentDirection == NORTH) face(WEST);
        else if(currentDirection == WEST) face(SOUTH);
        else if(currentDirection == SOUTH) face(EAST);

    }

    public TurtlePosition getCurrentPosition() {
        return currentPosition;
    }

    private void move(int noOfSteps) {
        if (currentDirection == EAST) currentPosition.setColumn(currentPosition.getColumn() + noOfSteps);
        if (currentDirection == SOUTH) currentPosition.setRow(currentPosition.getRow() + noOfSteps);
        if (currentDirection == WEST) currentPosition.setColumn(currentPosition.getColumn() - noOfSteps);
        if (currentDirection == NORTH) currentPosition.setRow(currentPosition.getRow() - noOfSteps);
    }

    public void move(int noOfSteps, SketchPad sketchPad) {
        noOfSteps = noOfSteps - 1;
        if(!penIsUp) writeOn(sketchPad, noOfSteps);
        move(noOfSteps);
    }
    private void writeOn(SketchPad sketchPad, int noOfSteps) {
        var floor = sketchPad.getFloor();
        int currentRow = currentPosition.getRow();
        int currentColumn = currentPosition.getColumn();
        if (currentDirection == EAST) {
            for (int i = 0; i <= noOfSteps; i++) {
                floor[currentRow][currentColumn++] = 1;
            }
        }
        if (currentDirection == SOUTH){
            for (int i = 0; i <= noOfSteps; i++){
                floor[currentRow++][currentColumn] = 1;
            }
        }
        if (currentDirection == WEST){
            for (int i = 0; i <= noOfSteps; i++){
                floor[currentRow][currentColumn--] = 1;
            }
        }
        if (currentDirection == NORTH){
            for (int i = 0; i <= noOfSteps; i++){
                floor[currentRow--][currentColumn] = 1;
            }
        }
    }

}
