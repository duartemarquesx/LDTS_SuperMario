package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.RedMushroom;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class RedMushroomViewerTest {
    @Test
    void drawRedMushroom() {
        GUI gui = Mockito.mock(GUI.class);
        RedMushroom rm = new RedMushroom(new Position(5, 10));
        RedMushroomViewer redMushroomViewer = new RedMushroomViewer();
        redMushroomViewer.draw(rm, gui);

        verify(gui).drawRedMushroom(new Position(5, 10));
    }
}
