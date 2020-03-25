package br.uece.peoo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class RoboPanel extends JPanel implements KeyListener, Runnable {

    // Constantes
    public static final int WIDTH = 400;
    public static final int HEIGTH = 400;

    private Graphics2D g2D;
    private BufferedImage image;

    private Thread thread;
    private boolean running;
    private long targetTime;


    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

    private void setFPS(int fps) {
        this.targetTime = 1000 / fps;
    }

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
        if (running) return;
        init();
        long startTime, elapsed, wait;
        while (running) {
            startTime = System.nanoTime();
            update();
            requestRender();
            elapsed = System.nanoTime() - startTime;
            wait = targetTime - elapsed / 1000000;
            if (wait > 0) {
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void init() {

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2D = image.createGraphics();
        running = true;
        setFPS(10);

    }

    public void requestRender() {
        render(g2D);
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

    }

    public void update() {

    }

    public void render(Graphics2D g2D) {
        g2D.clearRect(0, 0, WIDTH, HEIGHT);
    }

    public RoboPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }
}
