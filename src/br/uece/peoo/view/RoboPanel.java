package br.uece.peoo.view;

import br.uece.peoo.exceptions.MovimentoInvalidoException;
import br.uece.peoo.model.Comida;
import br.uece.peoo.model.Entidade;
import br.uece.peoo.model.Robo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class RoboPanel extends JPanel implements KeyListener {

    // Constantes
    public static final int WIDTH = 400;
    public static final int HEIGTH = 400;

    int teste = 0;

    private Robo robo;

    private Comida comida;

    @Override
    public void addNotify() {
        super.addNotify();
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        int k = event.getKeyCode();
        try {
            if (k == KeyEvent.VK_UP) {
                this.robo.mover(Robo.UP);
                teste++;
            }
            if (k == KeyEvent.VK_DOWN) this.robo.mover(Robo.DOWN);
            if (k == KeyEvent.VK_RIGHT) this.robo.mover(Robo.RIGHT);
            if (k == KeyEvent.VK_LEFT) this.robo.mover(Robo.LEFT);
            paint(this.getGraphics());
            System.out.println(event); // Testando
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (MovimentoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    private void init() {
        robo = new Robo(Color.BLUE);
        comida = new Comida(100, 100);
    }


    public RoboPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setFocusable(true);
        setVisible(true);
        requestFocus();
        addKeyListener(this);
        init();
    }

    public void paintEntidade(Graphics g, Entidade entidade) {
        g.setColor(entidade.getColor());
        g.fillRect(entidade.getX(), entidade.getY(), Entidade.SIZE, Entidade.SIZE);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0, WIDTH, WIDTH); // Limpando tudo
        paintEntidade(g, robo); // Desenhando o Robo
        paintEntidade(g, comida); // Desenhando a Comida
    }
}
