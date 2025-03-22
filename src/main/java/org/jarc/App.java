package org.jarc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class App {

    public static void main(String[] args) {

        final String gameName = "Snakes";

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setTitle(gameName);

        GamePanel panel = new GamePanel();
        mainFrame.add(panel);
        mainFrame.pack();

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        panel.startGameThread();

        mainFrame.addWindowListener(windowCloseOperations(panel));

    }

    public static WindowListener windowCloseOperations(GamePanel givenPanel){

        WindowListener windowListener = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

                givenPanel.endGameThread();
            }

            @Override
            public void windowClosed(WindowEvent e) {


            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        };
        return windowListener;
    }
}
