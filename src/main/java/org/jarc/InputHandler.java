package org.jarc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){

            case KeyEvent.VK_W -> Snake.moveDirection = Entity.Direction.UP;
            case KeyEvent.VK_S -> Snake.moveDirection = Entity.Direction.DOWN;
            case KeyEvent.VK_A -> Snake.moveDirection = Entity.Direction.LEFT;
            case KeyEvent.VK_D -> Snake.moveDirection = Entity.Direction.RIGHT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
