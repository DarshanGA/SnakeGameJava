package org.jarc;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int panelDimWidth = 600, panelDimHeight = 600;
    private Snake snake;
    private Thread gameThread;
    private boolean runGameLoop = true;
    private InputHandler inputHandler = new InputHandler();

    public GamePanel(){


        this.setPreferredSize(new Dimension(this.panelDimWidth, this.panelDimHeight));
        this.setBackground(Color.BLACK);
        this.snake = new Snake(this);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
    }

    @Override
    public void run() {

        System.out.println("Inside Game thread 'run()' method: " + runGameLoop);
        while(runGameLoop){

            update();
            repaint();
            try {

                Thread.sleep(17);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }

    public void paintComponent(Graphics graphics){


        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        snake.draw(graphics2D);
        graphics2D.dispose();
    }

    public void update(){

        snake.move();
    }

    public void startGameThread(){

        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void endGameThread(){

        try{

            this.runGameLoop = false;
            if(gameThread != null)
                gameThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
