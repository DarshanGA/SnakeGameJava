package org.jarc;

import org.jarc.util.Utils2D;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int panelDimWidth = 600, panelDimHeight = 600;
    final private Snake snake;
    private Thread gameThread;
    private boolean runGameLoop = true;
    private InputHandler inputHandler = new InputHandler();
    final private SnakeFood food;
    private double distanceDiff;

    public GamePanel(){


        this.setPreferredSize(new Dimension(this.panelDimWidth, this.panelDimHeight));
        this.setBackground(Color.BLACK);
        this.snake = new Snake(this);
        this.food = new SnakeFood(snake.width, this);
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

                Thread.sleep(20);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }

    public void paintComponent(Graphics graphics){


        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        snake.draw(graphics2D);
        food.draw(graphics2D);
        graphics2D.dispose();
    }

    public void update(){

        snake.move();
        distanceDiff = Utils2D.distance(snake.currentX, snake.currentY, food.originX, food.originY);
        if(distanceDiff > 0 && distanceDiff < 10)
            food.generate();
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
