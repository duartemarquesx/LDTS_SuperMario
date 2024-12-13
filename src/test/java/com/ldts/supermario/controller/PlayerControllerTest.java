package com.ldts.supermario.controller;

import com.ldts.supermario.Game;
import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.Position;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.model.elements.Ground;
import com.ldts.supermario.model.elements.MysteryBlock;
import com.ldts.supermario.model.elements.Player;
import com.ldts.supermario.model.elements.Stair;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerControllerTest {
    private PlayerController controller;
    private Viewer viewer;
    private Player player;
    private Game game;
    private Map map;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {

        map = new Map(20, 20);
        game= Mockito.mock(Game.class);
        viewer = Mockito.mock(GameViewer.class);
        player = new Player(6, 16);
        map.setPlayer(player);
        //map.setGrounds(Arrays.asList());
        map.setStairs(Arrays.asList());
        map.setBlocks(Arrays.asList());
        map.setMysteryBlocks(Arrays.asList());
        map.setCoins(Arrays.asList());
        map.setPipes(Arrays.asList());
        map.setRedMushrooms(Arrays.asList());
        map.setGoalPoles(Arrays.asList());
        map.setMonsters(Arrays.asList());

        List<Ground> grounds = new ArrayList<>();
        for (int c = 0; c < 20; c++) {
            grounds.add(new Ground(c, 19));
            grounds.add(new Ground(c, 18));
            grounds.add(new Ground(c, 17));
        }
        map.setGrounds(grounds);

        controller = new PlayerController(map, viewer);
    }



    @Test
    void movePlayerRightEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.RIGHT, 100);
        assertEquals(new Position(7, 16), player.getPosition());
    }
    @Test
    void movePlayerLeftEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.LEFT, 100);
        assertEquals(new Position(5, 16), player.getPosition());
    }
    @Test
    void movePlayerUpEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.UP, 100);
        assertEquals(new Position(6, 12), player.getPosition());
    }
    @Test
    void movePlayerJumpRightEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.JUMPR, 100);
        assertEquals(new Position(10, 12), player.getPosition());
    }
    @Test
    void movePlayerJumpLeftEmpty() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.JUMPL, 100);
        assertEquals(new Position(2, 12), player.getPosition());
    }


    @Test
    void movePlayerRightNotEmpty() throws IOException, URISyntaxException, FontFormatException {
        map.setStairs(Arrays.asList(new Stair(7, 16)));
        controller.step(game, GUI.ACTION.RIGHT, 100);
        assertEquals(new Position(6,16), player.getPosition());
    }
    @Test
    void moveHeroLeftNotEmpty() throws IOException, URISyntaxException, FontFormatException {
        map.setStairs(Arrays.asList(new Stair(5, 16)));
        controller.step(game, GUI.ACTION.LEFT, 100);
        assertEquals(new Position(6,16), player.getPosition());
    }
    @Test
    void movePlayerUpNotEmpty() throws IOException, URISyntaxException, FontFormatException {
        map.setMysteryBlocks(Arrays.asList(new MysteryBlock(6, 13)));
        controller.step(game, GUI.ACTION.UP, 100);
        assertEquals(new Position(6,13), player.getPosition());
    }
/*
    @Test
    void collisionWithMonster() throws IOException, URISyntaxException, FontFormatException {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new BrownMushroom(6, 16));
        map.setMonsters(monsters);
        controller.step(game, GUI.ACTION.NONE, 100);
        assertEquals(game.getState().getClass(), GameOverState.class);
    }*/
}