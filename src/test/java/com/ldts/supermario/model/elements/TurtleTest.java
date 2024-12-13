package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class TurtleTest {
    @Test
    void constructorAndGettersTest() {
        Turtle turtle= new Turtle(2, 6);

        Position position = turtle.getPosition();
        assertEquals(2, position.getX());
        assertEquals(6, position.getY());
    }
    @Test
    void constructorAndGettersTest2() {
        Position p=new Position(7,6);
        Turtle t = new Turtle(p);

        Position position = t.getPosition();
        assertEquals(p, position);

    }


    @Test
    void testSetPosition() {
        Turtle turtle = new Turtle(2, 6);

        turtle.setPosition(new Position(6, 4));

        Position position = turtle.getPosition();
        assertEquals(6, position.getX());
        assertEquals(4, position.getY());
    }
}
