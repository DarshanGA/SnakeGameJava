package org.jarc;

import java.awt.*;

public class Snake extends Entity{

    final int width = 6, headDimension = width + 4;
    public static Direction moveDirection = Direction.UP;
    final private GamePanel panel;
    private int length = 15, movementSpeed = 5;
    public int currentX, currentY;

    public Snake(GamePanel mainPanel){

        this.panel = mainPanel;
        this.originX = 10;
        this.originY = 10;
        this.currentX = originX;
        this.currentY = originY;
    }

    public void draw(Graphics2D graphics2D){

        graphics2D.setColor(Color.white);
        switch(moveDirection){

            case RIGHT :
                graphics2D.fillRect(currentX, currentY, headDimension, headDimension); // snake head.
                graphics2D.fillRect(currentX - length, currentY + (headDimension - width) / 2, length, width); // snake body.

                break;
            case UP:
                graphics2D.fillRect(currentX, currentY, headDimension, headDimension); // snake head.
                graphics2D.fillRect(currentX + ((headDimension - width) / 2), currentY + headDimension , width, length); // snake body
                break;
            case LEFT:
                graphics2D.fillRect(currentX, currentY, headDimension, headDimension); // snake head.
                graphics2D.fillRect(currentX + headDimension, currentY + ((headDimension - width) / 2), length, width); // snake body
                break;
            case DOWN:
                graphics2D.fillRect(currentX, currentY, headDimension, headDimension); // snake head.
                graphics2D.fillRect(currentX + ((headDimension - width) / 2), currentY - length, width, length); // snake body
                break;
        }
    }

    public void move(){

        switch(moveDirection){

            case RIGHT -> currentX = ((currentX + headDimension) + movementSpeed) > panel.panelDimWidth ? 0 : (currentX + movementSpeed);
            case UP -> currentY = (currentY - movementSpeed) < 0 ? (panel.panelDimHeight - (length + headDimension)) : (currentY - movementSpeed);
            case LEFT -> currentX = (currentX - movementSpeed) < 0 ? (panel.panelDimWidth - (headDimension + length)) : (currentX - movementSpeed);
            case DOWN -> currentY = ((currentY + length + headDimension) + movementSpeed) > panel.panelDimHeight ? 0 : (currentY + movementSpeed);
        }
    }
}
