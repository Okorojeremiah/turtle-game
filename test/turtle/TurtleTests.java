package turtle;

import turtle.Turtles;
import org.junit.Test;
import org.junit.jupiter.api.*;
//import org.testng.annotations.Test;
//import static com.Chapter7.Turtle.TurtlePackage.Direction.*;
import static org.junit.jupiter.api.Assertions.*;
//import static tddClass.turtle.Direction.*;
import static turtle.Direction.*;

public class TurtleTests {
    private Turtles ijapa;
    private SketchPad sketchPad;

    @BeforeEach
    public void setThisUP(){
        ijapa = new Turtles();
        sketchPad = new SketchPad(5,5);
    }
    @Test
    public void thereIsATurtle(){
        ijapa = new Turtles();
        assertNotNull(ijapa);
    }


    @Test
    public void testTurtleCanMovePenUp(){
        ijapa.penUp();
        assertTrue(ijapa.isPenUp());
    }

    @Test
    public void testThatTurtleCanMovePenDown(){
        ijapa.penUp();
        assertTrue(ijapa.isPenUp());

        ijapa.penDown();
        assertFalse(ijapa.isPenUp());
    }

    @Test
    public void testThatTurtleCanMoveRight_whileFacingEast(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanMoveRight_whileFacingSouth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanMoveRight_whileFacingWest(){
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
    }
    @Test
    public void testThatTurtleCanMoveRight_whileFacingNorth(){
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(EAST, ijapa.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeft_WhileFacingEast(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeft_WhileFacingNorth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeft_WhileFacingWest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanTurnLeft_WhileFacingSouth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(EAST, ijapa.getCurrentDirection());
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsUpAndFacingEast(){
        assertEquals(new TurtlePosition(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(0,10), ijapa.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsUpAndFacingSouth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        assertEquals(new TurtlePosition(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(0,10), ijapa.getCurrentPosition());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(10,10), ijapa.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsUpAndFacingWest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        assertEquals(new TurtlePosition(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(0,10), ijapa.getCurrentPosition());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(10,10), ijapa.getCurrentPosition());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(10,0), ijapa.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsUpAndFacingNorth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        assertEquals(new TurtlePosition(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(0,10), ijapa.getCurrentPosition());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(10,10), ijapa.getCurrentPosition());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(10,0), ijapa.getCurrentPosition());
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.move(10, sketchPad);
        assertEquals(new TurtlePosition(0,0), ijapa.getCurrentPosition());
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsDownAndFacingEast(){
        ijapa.penDown();
        assertEquals(new TurtlePosition(0, 0), ijapa.getCurrentPosition());
        assertFalse(ijapa.isPenUp());

        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(0,2), ijapa.getCurrentPosition());
        int[][] floor = sketchPad.getFloor();
        assertEquals(1, floor[0][0]);
        assertEquals(1, floor[0][1]);
        assertEquals(1, floor[0][2]);
        assertEquals(0, floor[0][3]);
        sketchPad.display();
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsDownAndFacingSouth(){
        ijapa.penDown();
        assertEquals(new TurtlePosition(0, 0), ijapa.getCurrentPosition());
        assertFalse(ijapa.isPenUp());

        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(0,2), ijapa.getCurrentPosition());
        int[][] floor = sketchPad.getFloor();
        assertEquals(1, floor[0][0]);
        assertEquals(1, floor[0][1]);
        assertEquals(1, floor[0][2]);
        assertEquals(0, floor[0][3]);

        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(2, 2), ijapa.getCurrentPosition());
        assertEquals(1, floor[0][2]);
        assertEquals(1, floor[1][2]);
        assertEquals(1, floor[2][2]);
        assertEquals(0, floor[3][2]);
        sketchPad.display();
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsDownAndFacingWest(){
        ijapa.penDown();
        assertEquals(new TurtlePosition(0, 0), ijapa.getCurrentPosition());
        assertFalse(ijapa.isPenUp());

        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(0,2), ijapa.getCurrentPosition());
        int[][] floor = sketchPad.getFloor();
        assertEquals(1, floor[0][0]);
        assertEquals(1, floor[0][1]);
        assertEquals(1, floor[0][2]);
        assertEquals(0, floor[0][3]);

        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(2, 2), ijapa.getCurrentPosition());
        assertEquals(1, floor[0][2]);
        assertEquals(1, floor[1][2]);
        assertEquals(1, floor[2][2]);
        assertEquals(0, floor[3][2]);

        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(2, 0), ijapa.getCurrentPosition());
        assertEquals(1, floor[2][2]);
        assertEquals(1, floor[2][1]);
        assertEquals(1, floor[2][0]);
        assertEquals(0, floor[1][0]);
        sketchPad.display();
    }

    @Test
    public void testThatTurtleCanMoveWhilePenIsDownAndFacingNorth(){
        ijapa.penDown();
        assertEquals(new TurtlePosition(0, 0), ijapa.getCurrentPosition());
        assertFalse(ijapa.isPenUp());

        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(0,2), ijapa.getCurrentPosition());
        int[][] floor = sketchPad.getFloor();
        assertEquals(1, floor[0][0]);
        assertEquals(1, floor[0][1]);
        assertEquals(1, floor[0][2]);
        assertEquals(0, floor[0][3]);

        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(2, 2), ijapa.getCurrentPosition());
        assertEquals(1, floor[0][2]);
        assertEquals(1, floor[1][2]);
        assertEquals(1, floor[2][2]);
        assertEquals(0, floor[3][2]);

        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(2, 0), ijapa.getCurrentPosition());
        assertEquals(1, floor[2][2]);
        assertEquals(1, floor[2][1]);
        assertEquals(1, floor[2][0]);
        assertEquals(0, floor[1][0]);

        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new TurtlePosition(0, 0), ijapa.getCurrentPosition());
        assertEquals(1, floor[2][0]);
        assertEquals(1, floor[1][0]);
        assertEquals(1, floor[0][0]);
//        assertEquals(0, floor[0][1]);
        sketchPad.display();
    }
}
