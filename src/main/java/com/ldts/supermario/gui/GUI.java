package com.ldts.supermario.gui;

import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.elements.MysteryBlock;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayer(Position position);

    void drawGround(Position position);

    void drawMonster(Position position);

    void drawBlock(Position position);

    void drawMysteryBlock(MysteryBlock mb,Position position);

    void drawStair(Position position);

    void drawCoin(Position position);

    void drawPipe(Position position);

    void drawRedMushroom(Position position);

    void drawGoalPole(Position position);

    void drawBrownMushroom(Position position);

    void drawTurtle(Position position);

    void drawTurtleShell(Position position);

    void drawText(Position position, String text, String color);

    void drawCharacter(int x, int y, char c, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, JUMPR, JUMPL, NONE, QUIT, SELECT}
}
