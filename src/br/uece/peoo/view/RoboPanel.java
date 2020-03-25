package br.uece.peoo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RoboPanel extends JPanel implements KeyListener, Runnable {

    public static final int WIDTH = 400;
    public static final int HEIGTH = 400;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }

    public RoboPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }
}
