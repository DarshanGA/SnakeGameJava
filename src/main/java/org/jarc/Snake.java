package org.jarc;

import java.awt.*;

public class Snake extends Entity{

    final int width = 6, headDimension = 10;
    public static Direction moveDirection = Direction.DOWN;
    final private GamePanel panel;
    private int length = 15, currentX, currentY, movementSpeed = 5;

    public Snake(GamePanel mainPanel){

        this.panel = mainPanel;
        this.originX = 5;
        this.originY = panel.panelDimHeight / 2;
        this.currentX = originX;
        this.currentY = originY;
    }

    public void draw(Graphics2D graphics2D){

        graphics2D.setColor(Color.white);
        switch(moveDirection){

            case RIGHT :
                graphics2D.fillRect(currentX, currentY, length, width); // snake body
                graphics2D.fillRect((currentX + length), currentY - ((headDimension - width) / 2), headDimension, headDimension); // snake head.
                break;
            case UP:
                graphics2D.fillRect(currentX, currentY, headDimension, headDimension); // snake head.
                graphics2D.fillRect(currentX + ((headDimension - width) / 2), currentY + headDimension, width, length); // snake body
                break;
            case LEFT:
                graphics2D.fillRect(currentX, currentY, headDimension, headDimension); // snake head.
                graphics2D.fillRect(currentX + headDimension, currentY + ((headDimension - width) / 2), length, width); // snake body
                break;
            case DOWN:
                graphics2D.fillRect(currentX + ((headDimension - width) / 2), currentY, width, length); // snake body
                graphics2D.fillRect(currentX, currentY + length, headDimension, headDimension); // snake head.
                break;
        }
    }

    public void move(){

        switch(moveDirection){

            case RIGHT -> currentX = ((currentX + length + headDimension) + movementSpeed) > panel.panelDimWidth ? 0 : (currentX + movementSpeed);
            case UP -> currentY = (currentY - movementSpeed) < 0 ? (panel.panelDimHeight - (length + headDimension)) : (currentY - movementSpeed);
            case LEFT -> currentX = (currentX - movementSpeed) < 0 ? (panel.panelDimWidth - (headDimension + length)) : (currentX - movementSpeed);
            case DOWN -> currentY = ((currentY + length + headDimension) + movementSpeed) > panel.panelDimHeight ? 0 : (currentY + movementSpeed);
        }
    }
}
