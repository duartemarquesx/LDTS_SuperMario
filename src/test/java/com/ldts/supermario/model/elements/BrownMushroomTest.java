package com.ldts.supermario.model.elements;
import static org.junit.jupiter.api.Assertions.*;
import com.ldts.supermario.model.Position;
import org.junit.jupiter.api.Test;

public class BrownMushroomTest {
    @Test
    void constructorAndGettersTest() {
        BrownMushroom brownMushroom = new BrownMushroom(7, 6);

        Position position = brownMushroom.getPosition();
        assertEquals(7, position.getX());
        assertEquals(6, position.getY());
    }
    @Test
    void constructorAndGettersTest2() {
        Position p=new Position(7,6);
        BrownMushroom brownMushroom = new BrownMushroom(p);

        Position position = brownMushroom.getPosition();
        assertEquals(p, position);

    }


    @Test
    void testSetPosition() {
        BrownMushroom brownMushroom = new BrownMushroom(7, 6);

        brownMushroom.setPosition(new Position(3, 4));

        Position position = brownMushroom.getPosition();
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
    }

}
