package org.jarc;

import java.awt.*;
import java.util.Random;

public class SnakeFood extends Entity{

    private GamePanel panel;
    final int size;
    final Random random;

    public SnakeFood(int givenFoodSize, GamePanel givenGamePanel){

        this.size = givenFoodSize;
        this.panel = givenGamePanel;
        this.random = new Random();
        generate();
    }

    public void draw(Graphics2D graphics2D){

        graphics2D.fillRect(originX, originY, size,size);
    }

    public void generate(){

        this.originX = random.nextInt(panel.panelDimWidth);
        this.originY = random.nextInt(panel.panelDimHeight);
    }
}
